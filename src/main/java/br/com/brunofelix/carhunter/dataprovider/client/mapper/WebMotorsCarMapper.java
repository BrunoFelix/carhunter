package br.com.brunofelix.carhunter.dataprovider.client.mapper;

import br.com.brunofelix.carhunter.core.domain.response.ResponseDto;
import br.com.brunofelix.carhunter.dataprovider.client.webMotors.dto.WebMotorsCarDto;

public final class WebMotorsCarMapper {

    private WebMotorsCarMapper() {}

    public static ResponseDto toResponse(WebMotorsCarDto car) {
        return ResponseDto.builder()
                .km(car.getSpecification().getKm())
                .year(car.getSpecification().getYearModel())
                .price(car.getPrice().getPrice())
                .brand(car.getSpecification().getMake().getValue())
                .model(car.getSpecification().getModel().getValue())
                .version(car.getSpecification().getVersion().getValue())
                .transmission(car.getSpecification().getTransmission())
                .information("")
                .owner("WebMotors")
                .url(String.format("https://www.webmotors.com.br/comprar/%s/%s/%s/%s/%s/%s",
                        car.getSpecification().getMake().getValue(),
                        car.getSpecification().getModel().getValue(),
                        car.getSpecification().getVersion().getValue()
                                .replace(".", "")
                                .replaceAll("á", "a")
                                .replaceAll("Á", "a")
                                .replace(" ", "-")
                                .toLowerCase(),
                        "4-portas",
                        car.getSpecification().getYearModel(),
                        car.getId()))
                .build();
    }
}
