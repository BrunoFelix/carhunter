package br.com.brunofelix.carhunter.dataprovider.client.mapper;

import br.com.brunofelix.carhunter.core.domain.response.ResponseDto;
import br.com.brunofelix.carhunter.core.util.NumberUtils;
import br.com.brunofelix.carhunter.dataprovider.client.autoLine.dto.AutoLineCarDto;

public final class AutoLineCarMapper {

    private AutoLineCarMapper() {}

    public static ResponseDto toResponse(AutoLineCarDto car) {
        return ResponseDto.builder()
                .km(car.getKm())
                .year(NumberUtils.convertStringToInteger(car.getModelYear()))
                .price(NumberUtils.convertStringToInteger(car.getPrice()))
                .brand(car.getMakeName().toUpperCase())
                .model(car.getModelName())
                .version(car.getVersionName())
                .transmission(car.getTransmission())
                .information(car.getAdditionalInformation())
                .owner("AutoLine")
                .url(car.getLinkAnuncio())
                .build();
    }
}
