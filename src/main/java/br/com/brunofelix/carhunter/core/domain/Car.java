package br.com.brunofelix.carhunter.core.domain;

import br.com.brunofelix.carhunter.core.domain.response.ResponseDto;
import br.com.brunofelix.carhunter.core.util.HashGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Car {

    private String id;
    private String brand;
    private String model;
    private Integer km;
    private Integer price;
    private Integer modelYear;
    private String transmission;
    private String url;
    private LocalDateTime dtCreate;
    private LocalDateTime dtUpdate;

    public static Car of(ResponseDto responseDto) {
        return Car.builder()
                .id(HashGenerator.from(responseDto))
                .brand(responseDto.getBrand())
                .model(responseDto.getModel())
                .km(responseDto.getKm())
                .price(responseDto.getPrice())
                .modelYear(responseDto.getYear())
                .transmission(responseDto.getTransmission())
                .url(responseDto.getUrl())
                .dtCreate(LocalDateTime.now())
                .build();
    }
}
