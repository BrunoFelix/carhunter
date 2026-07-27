package br.com.brunofelix.carhunter.core.service;

import br.com.brunofelix.carhunter.core.domain.request.RequestDto;
import br.com.brunofelix.carhunter.core.domain.response.ResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class SearchService {

    private static final int YEAR_START = 2015;
    private static final int YEAR_END = 2027;
    private static final int PRICE_END = 110000;

    private final List<ServiceClient> serviceClients;

    private final CarService carService;

    public void find() {
        try {
            log.info("Initing...");

            final RequestDto requestDto = RequestDto.builder()
                    .kmStart(0)
                    .kmEnd(CarValidator.KM_MAX)
                    .yearStart(YEAR_START)
                    .yearEnd(YEAR_END)
                    .priceStart(0)
                    .priceEnd(PRICE_END)
                    .build();

            List<CompletableFuture<List<ResponseDto>>> futures = serviceClients.stream()
                    .map(service -> CompletableFuture.supplyAsync(() -> service.find(requestDto)))
                    .collect(Collectors.toList());

            List<ResponseDto> allResponses = futures.stream()
                    .flatMap(future -> future.join().stream())
                    .collect(Collectors.toList());

            List<ResponseDto> responses = new ArrayList<>();
            for (ResponseDto responseDto : allResponses) {
                addToResponseList(responses, responseDto);
            }

            carService.save(responses);
            log.info("Done...");
        } catch (Exception e) {
            log.error("Error executing search...", e);
        }
    }

    private void addToResponseList(List<ResponseDto> responses, ResponseDto responseDto) {
        try {
            if (CarDeduplicator.isDuplicate(responses, responseDto)) {
                return;
            }
            if (!CarValidator.isValid(responseDto)) {
                return;
            }

            responses.add(responseDto);
        } catch (Exception e) {
            log.error("Failed when add to list...", e);
        }
    }

}
