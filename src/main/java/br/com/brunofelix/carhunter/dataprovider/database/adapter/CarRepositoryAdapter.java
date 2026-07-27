package br.com.brunofelix.carhunter.dataprovider.database.adapter;

import br.com.brunofelix.carhunter.core.domain.Car;
import br.com.brunofelix.carhunter.core.gateway.CarRepository;
import br.com.brunofelix.carhunter.dataprovider.database.entity.CarEntity;
import br.com.brunofelix.carhunter.dataprovider.database.mapper.CarEntityMapper;
import br.com.brunofelix.carhunter.dataprovider.database.repository.SpringDataCarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CarRepositoryAdapter implements CarRepository {

    private final SpringDataCarRepository repository;

    @Override
    public void saveAll(List<Car> cars) {
        List<CarEntity> entities = cars.stream()
                .map(CarEntityMapper::toEntity)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());
        repository.saveAll(entities);
    }

    @Override
    public Long countByDtCreateGreaterThanEqual(LocalDateTime date) {
        return repository.countByDtCreateGreaterThanEqual(date);
    }
}
