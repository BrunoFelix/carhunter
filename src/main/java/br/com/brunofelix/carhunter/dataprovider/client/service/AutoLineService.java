package br.com.brunofelix.carhunter.dataprovider.client.service;

import br.com.brunofelix.carhunter.core.domain.request.RequestDto;
import br.com.brunofelix.carhunter.core.domain.response.ResponseDto;
import br.com.brunofelix.carhunter.dataprovider.client.AbstractServiceClient;
import br.com.brunofelix.carhunter.dataprovider.client.autoLine.AutoLineClient;
import br.com.brunofelix.carhunter.dataprovider.client.autoLine.dto.AutoLineDto;
import br.com.brunofelix.carhunter.dataprovider.client.autoLine.dto.PayloadDto;
import br.com.brunofelix.carhunter.dataprovider.client.mapper.AutoLineCarMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class AutoLineService extends AbstractServiceClient {

    private final AutoLineClient autoLineClient;

    @Override
    protected String getServiceName() {
        return "AutoLine";
    }

    @Override
    protected List<ResponseDto> executeSearch(RequestDto requestDto) {
        AutoLineDto autoLineDto = this.get(requestDto);
        if (autoLineDto == null || autoLineDto.getCars() == null) {
            return List.of();
        }
        return autoLineDto.getCars().stream()
                .map(AutoLineCarMapper::toResponse)
                .collect(Collectors.toList());
    }

    private AutoLineDto get(RequestDto requestDto) {
        return autoLineClient.get(
                PayloadDto.builder()
                .endPrice(requestDto.getPriceEnd())
                .startModelYear(requestDto.getYearStart())
                .endModelYear(requestDto.getYearEnd())
                .maxKm(requestDto.getKmEnd())
                .build());
    }
}
