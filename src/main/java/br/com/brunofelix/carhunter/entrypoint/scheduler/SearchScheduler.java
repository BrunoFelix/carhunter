package br.com.brunofelix.carhunter.entrypoint.scheduler;

import br.com.brunofelix.carhunter.core.service.SearchService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class SearchScheduler {

    private final SearchService searchService;

    @Scheduled(cron = "${search.cron}")
    public void search() {
        log.info("Started Job...");
        searchService.find();
        log.info("Finished Job...");
    }
}
