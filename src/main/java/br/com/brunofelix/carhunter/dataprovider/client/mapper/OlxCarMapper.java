package br.com.brunofelix.carhunter.dataprovider.client.mapper;

import br.com.brunofelix.carhunter.core.domain.response.ResponseDto;
import br.com.brunofelix.carhunter.core.util.NumberUtils;
import br.com.brunofelix.carhunter.dataprovider.client.olx.dto.OlxCarDto;
import br.com.brunofelix.carhunter.dataprovider.client.olx.dto.OlxPropertiesDto;
import br.com.brunofelix.carhunter.dataprovider.client.olx.dto.OlxTrackingSpecificDataDto;

import java.util.Objects;

public final class OlxCarMapper {

    private OlxCarMapper() {}

    public static ResponseDto toResponse(OlxCarDto car) {
        return ResponseDto.builder()
                .km(extractKm(car))
                .year(NumberUtils.convertStringToInteger(extractProperty(car, "regdate")))
                .price(NumberUtils.convertStringToInteger(car.getPrice()))
                .brand(extractProperty(car, "vehicle_brand").toUpperCase())
                .model(extractTrackingData(car, "model"))
                .version(car.getTitle())
                .transmission(extractProperty(car, "gearbox"))
                .information("")
                .owner("OLX")
                .url(car.getUrl())
                .build();
    }

    private static String extractProperty(OlxCarDto car, String key) {
        return car.getProperties().stream()
                .filter(it -> Objects.equals(it.getName(), key))
                .findFirst()
                .map(OlxPropertiesDto::getValue)
                .orElse("");
    }

    private static String extractTrackingData(OlxCarDto car, String key) {
        return car.getTrackingSpecificData().stream()
                .filter(it -> Objects.equals(it.getKey(), key))
                .findFirst()
                .map(OlxTrackingSpecificDataDto::getValue)
                .orElse("");
    }

    private static Integer extractKm(OlxCarDto car) {
        String value = extractProperty(car, "mileage");
        return !value.isEmpty() ? Integer.parseInt(value) : 0;
    }
}
