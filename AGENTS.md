# CarHunter — Agent Guide

## Project

Spring Boot 4.1.0 / Java 26 / Gradle app that scrapes Brazilian car listings from 5 sources (OLX, WebMotors, iCarros/Via1, AutoParvi, AutoLine), deduplicates, and persists to MySQL.

## Commands

| Task | Command |
|------|---------|
| Build | `./gradlew build` |
| Run | `./gradlew bootRun` |
| Test | `./gradlew test` |
| Single test | `./gradlew test --tests *ClassName.testMethod` |

Test framework is JUnit 5 (Jupiter), no extra flags needed.

## Architecture (hexagonal)

```
entrypoint/       — REST controllers, schedulers, Feign configs (inbound adapters)
core/             — domain, service, gateway interfaces (business logic)
dataprovider/     — database adapters, Feign clients, mappers (outbound adapters)
```

## Known issues

- **Mixed package names**: Directory structure is `br.com.brunofelix.carhunter` but most source files declare `package br.com.brunofelix.carhunter` (e.g. `SearchController.java`, `SearchScheduler.java`, all Feign clients). The build currently compiles only because the Gradle source root includes both. Do **not** rely on package declarations matching directory layout — verify before moving/refactoring files.
- **Missing application.properties**: Referenced properties `search.cron`, `*.client.url`, `via1.client.token` have no defaults. The app will fail at runtime without them.

## Search flow

1. Triggered via `GET /search` or cron (`${search.cron}`)
2. `SearchService.find()` fires parallel requests to all `ServiceClient` beans via `CompletableFuture.supplyAsync`
3. Results are deduplicated (`CarDeduplicator`) and validated (`CarValidator`)
4. Saved to MySQL via `CarService.save()` (also updates `LAST_SEARCH` timestamp)
5. Hardcoded search bounds: year 2015–2027, price up to R$110k, km up to `CarValidator.KM_MAX`

## Adding a new listing source

Create a package under `dataprovider/client/<name>/` with:
- Feign client interface (annotated `@FeignClient`)
- DTO classes for the API response
- Mapper (implements `dataprovider/client/mapper/*`)
- Service class extending `AbstractServiceClient` (which implements `core/service/ServiceClient`)
- Register in `core/service/ServiceClient` interface — services are auto-injected via `List<ServiceClient>`

## Database

MySQL via Spring Data JPA. Entities: `CarEntity`, `ParameterEntity`. Custom decoders in `dataprovider/database/adapter/` bridge gateway interfaces.

## Tests

Only one test exists (`CarhunterApplicationTests` — context load). Tests require a running MySQL instance (no H2/test profile configured).

## Notable patterns

- Lombok (`@Slf4j`, `@RequiredArgsConstructor`, `@Builder`, `@Getter`) used pervasively
- Feign client configs (user-agent, auth, custom decoder) live in `dataprovider/client/config/` — not `entrypoint/`
- A global `FeignClientConfig` provides a custom `Decoder` that strips non-JSON prefix garbage from responses
