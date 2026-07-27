package br.com.brunofelix.carhunter.dataprovider.client.service;

import br.com.brunofelix.carhunter.core.domain.request.RequestDto;
import br.com.brunofelix.carhunter.core.domain.response.ResponseDto;
import br.com.brunofelix.carhunter.core.service.PaginationHelper;
import br.com.brunofelix.carhunter.dataprovider.client.AbstractServiceClient;
import br.com.brunofelix.carhunter.dataprovider.client.autoParvi.AutoParviClient;
import br.com.brunofelix.carhunter.dataprovider.client.autoParvi.dto.AutoParviCarDto;
import br.com.brunofelix.carhunter.dataprovider.client.autoParvi.dto.AutoParviDto;
import br.com.brunofelix.carhunter.dataprovider.client.mapper.AutoParviCarMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class AutoParviService extends AbstractServiceClient {

    private static final int PAGE_SIZE = 12;

    private final AutoParviClient autoParviClient;

    private final PaginationHelper paginationHelper;

    @Override
    protected String getServiceName() {
        return "AutoParvi";
    }

    @Override
    protected List<ResponseDto> executeSearch(RequestDto requestDto) {
        List<AutoParviCarDto> allCars = paginationHelper.fetchAll(
                page -> {
                    AutoParviDto dto = this.get(requestDto, (page - 1) * PAGE_SIZE);
                    return dto != null && dto.getCars() != null ? dto.getCars() : List.of();
                },
                it -> Objects.nonNull(it.getId())
        );
        return allCars.stream()
                .map(AutoParviCarMapper::toResponse)
                .collect(Collectors.toList());
    }

    private AutoParviDto get(RequestDto requestDto, int offset) {
        return autoParviClient.get(requestDto.getPriceStart(),
                requestDto.getPriceEnd(),
                requestDto.getYearStart(),
                requestDto.getYearEnd(),
                requestDto.getKmStart(),
                requestDto.getKmEnd(),
                "Pernambuco",
                offset);
    }
}
