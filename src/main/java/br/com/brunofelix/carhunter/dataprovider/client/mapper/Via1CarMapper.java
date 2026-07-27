package br.com.brunofelix.carhunter.dataprovider.client.mapper;

import br.com.brunofelix.carhunter.core.domain.response.ResponseDto;
import br.com.brunofelix.carhunter.core.util.NumberUtils;
import br.com.brunofelix.carhunter.dataprovider.client.via1.dto.Via1CarDto;

public final class Via1CarMapper {

    private Via1CarMapper() {}

    public static ResponseDto toResponse(Via1CarDto car) {
        return ResponseDto.builder()
                .km(NumberUtils.convertStringToInteger(car.getKm()))
                .year(NumberUtils.convertStringToInteger(car.getYear()))
                .price(NumberUtils.convertStringToInteger(car.getPrice()))
                .brand(car.getBrand().toUpperCase())
                .model(car.getModel())
                .version(car.getVersion())
                .transmission(car.getTransmission())
                .information("")
                .owner("Via1")
                .url(String.format("https://via1seminovos.com.br/seminovos/%s", car.getSlug()))
                .build();
    }
}
