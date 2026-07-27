package br.com.brunofelix.carhunter.dataprovider.client.service;

import br.com.brunofelix.carhunter.core.domain.request.RequestDto;
import br.com.brunofelix.carhunter.core.domain.response.ResponseDto;
import br.com.brunofelix.carhunter.dataprovider.client.AbstractServiceClient;
import br.com.brunofelix.carhunter.dataprovider.client.mapper.Via1CarMapper;
import br.com.brunofelix.carhunter.dataprovider.client.via1.Via1Client;
import br.com.brunofelix.carhunter.dataprovider.client.via1.dto.Via1Dto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class Via1Service extends AbstractServiceClient {

    private final Via1Client via1Client;

    @Override
    protected String getServiceName() {
        return "Via1";
    }

    @Override
    protected List<ResponseDto> executeSearch(RequestDto requestDto) {
        Via1Dto via1 = this.get(requestDto);
        if (via1 == null || via1.getCars() == null) {
            return List.of();
        }
        return via1.getCars().stream()
                .map(Via1CarMapper::toResponse)
                .collect(Collectors.toList());
    }

    private Via1Dto get(RequestDto requestDto) {
        return via1Client.get(requestDto.getPriceStart(),
                requestDto.getPriceEnd(),
                requestDto.getYearStart(),
                requestDto.getYearEnd(),
                requestDto.getKmStart(),
                requestDto.getKmEnd());
    }
}
