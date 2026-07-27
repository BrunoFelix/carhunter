package br.com.brunofelix.carhunter.dataprovider.database.mapper;

import br.com.brunofelix.carhunter.core.domain.Car;
import br.com.brunofelix.carhunter.dataprovider.database.entity.CarEntity;

import java.util.Optional;

public final class CarEntityMapper {

    private CarEntityMapper() {}

    public static Optional<CarEntity> toEntity(Car car) {
        if (car == null) {
            return Optional.empty();
        }
        return Optional.of(CarEntity.builder()
                .id(car.getId())
                .brand(car.getBrand())
                .model(car.getModel())
                .km(car.getKm())
                .price(car.getPrice())
                .modelYear(car.getModelYear())
                .transmission(car.getTransmission())
                .url(car.getUrl())
                .dtCreate(car.getDtCreate())
                .dtUpdate(car.getDtUpdate())
                .build());
    }
}
