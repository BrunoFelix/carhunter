package br.com.brunofelix.carhunter.dataprovider.client.service;

import br.com.brunofelix.carhunter.core.domain.request.RequestDto;
import br.com.brunofelix.carhunter.core.domain.response.ResponseDto;
import br.com.brunofelix.carhunter.core.service.PaginationHelper;
import br.com.brunofelix.carhunter.dataprovider.client.AbstractServiceClient;
import br.com.brunofelix.carhunter.dataprovider.client.mapper.OlxCarMapper;
import br.com.brunofelix.carhunter.dataprovider.client.olx.OlxClient;
import br.com.brunofelix.carhunter.dataprovider.client.olx.dto.OlxCarDto;
import br.com.brunofelix.carhunter.dataprovider.client.olx.dto.OlxDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class OlxService extends AbstractServiceClient {

    private static final int OLX_YEAR_START = 66;
    private static final int OLX_YEAR_END = 74;
    private static final int OLX_KM_START = 0;
    private static final int OLX_KM_END = 60000;

    private final OlxClient olxClient;

    private final PaginationHelper paginationHelper;

    @Override
    protected String getServiceName() {
        return "OLX";
    }

    @Override
    protected List<ResponseDto> executeSearch(RequestDto requestDto) {
        List<OlxCarDto> allCars = paginationHelper.fetchAll(
                page -> {
                    OlxDto dto = this.get(requestDto, page);
                    if (dto != null && dto.getPageProps() != null && dto.getPageProps().getCars() != null) {
                        return dto.getPageProps().getCars();
                    }
                    return List.of();
                },
                it -> Objects.nonNull(it.getTitle())
        );
        return allCars.stream()
                .map(OlxCarMapper::toResponse)
                .collect(Collectors.toList());
    }

    private OlxDto get(RequestDto requestDto, int pageNumber) {
        return olxClient.get(requestDto.getPriceStart(),
                requestDto.getPriceEnd(),
                OLX_YEAR_START,
                OLX_YEAR_END,
                OLX_KM_START,
                OLX_KM_END,
                pageNumber);
    }
}
