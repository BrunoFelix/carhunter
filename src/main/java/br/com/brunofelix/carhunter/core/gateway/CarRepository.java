package br.com.brunofelix.carhunter.core.gateway;

import br.com.brunofelix.carhunter.core.domain.Car;

import java.time.LocalDateTime;
import java.util.List;

public interface CarRepository {
    void saveAll(List<Car> cars);
    Long countByDtCreateGreaterThanEqual(LocalDateTime date);
}
