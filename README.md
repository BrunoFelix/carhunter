# CarHunter

Agregador de anúncios de carros seminovos em Pernambuco. Busca em 5 fontes (OLX, WebMotors, iCarros/Via1, AutoParvi, AutoLine), deduplica e persiste em MySQL.

## Stack

- **Java 26 + Spring Boot 4.1.0**
- **Gradle 9.4.1** com `spring-cloud-starter-openfeign`
- **MySQL 8.0** via Spring Data JPA + Hibernate
- **Lombok**, **Jackson 3.x** (`tools.jackson`)

## Arquitetura (Hexagonal)

```
entrypoint/        Adaptadores de entrada
├── controller/    REST endpoints
└── scheduler/     Tarefas agendadas (cron)

core/              Núcleo do negócio
├── domain/        Entidades de domínio (Car, Parameter)
├── gateway/       Interfaces de saída (portas)
├── service/       Lógica: busca, dedup, validação
└── util/          HashGenerator, NumberUtils

dataprovider/      Adaptadores de saída
├── client/        Feign clients para cada fonte
│   ├── config/    Decoder global + configs por cliente
│   ├── mapper/    DTO → ResponseDto
│   └── service/   Implementações ServiceClient
└── database/      JPA entities, repositories, mappers
```

## Pré-requisitos

- JDK 26
- MySQL 8.0 (ou use o `docker-compose.yaml`)

## Configuração

### Banco

```bash
docker compose up -d
```

### Propriedades

Edite `src/main/resources/application.properties` ou use variáveis de ambiente:

| Propriedade | Obrigatório | Padrão |

| `olx.client.token` | sim (env `OLX_TOKEN`) | — |<br>
| `via1.client.token` | sim (env `VIA1_TOKEN`) | — |<br>
| `search.cron` | não | `0 0 9,12,15,18 * * *` |

## Executar

```bash
./gradlew bootRun
```

## Endpoints

| Método | Path | Descrição |
|---|---|---|
| `GET` | `/search` | Dispara busca em todas as fontes |

A busca também executa automaticamente no cron configurado (`search.cron`).

## Testes

```bash
./gradlew test
```

Requer MySQL rodando (sem profile H2 configurado).

## Busca (como funciona)

1. `SearchService.find()` monta um `RequestDto` com limites fixos:
    - Ano: 2015–2027
    - Preço: até R$ 110k
    - KM: até 50.000
2. Dispara requisições paralelas via `CompletableFuture.supplyAsync` para todos os beans `ServiceClient`
3. Resultados passam por deduplicação (`CarDeduplicator`) e validação (`CarValidator`)
4. Salvos em MySQL via `CarService.save()` (atualiza timestamp `LAST_SEARCH`)

## Adicionar nova fonte

1. Criar pacote em `dataprovider/client/<nome>/` com:
    - Feign client (`@FeignClient`)
    - DTOs da resposta
    - Mapper (implementa `dataprovider/client/mapper/*`)
    - Service (estende `AbstractServiceClient`)
2. A injeção é automática via `List<ServiceClient>`
