package br.com.brunofelix.carhunter.dataprovider.client.service;

import br.com.brunofelix.carhunter.core.domain.request.RequestDto;
import br.com.brunofelix.carhunter.core.domain.response.ResponseDto;
import br.com.brunofelix.carhunter.core.service.PaginationHelper;
import br.com.brunofelix.carhunter.dataprovider.client.AbstractServiceClient;
import br.com.brunofelix.carhunter.dataprovider.client.mapper.WebMotorsCarMapper;
import br.com.brunofelix.carhunter.dataprovider.client.webMotors.WebMotorsClient;
import br.com.brunofelix.carhunter.dataprovider.client.webMotors.dto.WebMotorsCarDto;
import br.com.brunofelix.carhunter.dataprovider.client.webMotors.dto.WebMotorsDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class WebMotorsService extends AbstractServiceClient {

    private final WebMotorsClient webMotorsClient;

    private final PaginationHelper paginationHelper;

    @Override
    protected String getServiceName() {
        return "WebMotors";
    }

    @Override
    protected List<ResponseDto> executeSearch(RequestDto requestDto) {
        List<WebMotorsCarDto> allCars = paginationHelper.fetchAll(
                page -> {
                    WebMotorsDto dto = this.get(requestDto, page);
                    return dto != null && dto.getCars() != null ? dto.getCars() : List.of();
                },
                it -> Objects.nonNull(it.getId())
        );
        return allCars.stream()
                .map(WebMotorsCarMapper::toResponse)
                .collect(Collectors.toList());
    }

    private WebMotorsDto get(RequestDto requestDto, int pageNumber) {
        return webMotorsClient.get(requestDto.getPriceStart(),
                requestDto.getPriceEnd(),
                requestDto.getYearStart(),
                requestDto.getYearEnd(),
                requestDto.getKmStart(),
                requestDto.getKmEnd(),
                pageNumber);
    }
}
