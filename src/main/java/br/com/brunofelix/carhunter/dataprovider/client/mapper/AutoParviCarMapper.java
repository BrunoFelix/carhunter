package br.com.brunofelix.carhunter.dataprovider.client.mapper;

import br.com.brunofelix.carhunter.core.domain.response.ResponseDto;
import br.com.brunofelix.carhunter.core.util.NumberUtils;
import br.com.brunofelix.carhunter.dataprovider.client.autoParvi.dto.AutoParviCarDto;

public final class AutoParviCarMapper {

    private AutoParviCarMapper() {}

    public static ResponseDto toResponse(AutoParviCarDto car) {
        return ResponseDto.builder()
                .km(car.getKm())
                .year(car.getYear())
                .price(NumberUtils.convertStringToInteger(car.getPrice()))
                .brand(car.getBrand().toUpperCase())
                .model(car.getModel())
                .version(car.getVersion())
                .transmission(car.getTransmission())
                .information("")
                .owner("AutoParvi")
                .url(String.format("https://www.autoparvi.com.br/seminovos/%s", car.getCode()))
                .build();
    }
}
