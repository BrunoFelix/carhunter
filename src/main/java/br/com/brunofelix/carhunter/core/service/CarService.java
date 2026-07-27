package br.com.brunofelix.carhunter.core.service;

import br.com.brunofelix.carhunter.core.domain.Car;
import br.com.brunofelix.carhunter.core.domain.Parameter;
import br.com.brunofelix.carhunter.core.domain.ParameterEnum;
import br.com.brunofelix.carhunter.core.domain.response.ResponseDto;
import br.com.brunofelix.carhunter.core.gateway.CarRepository;
import br.com.brunofelix.carhunter.core.gateway.ParameterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CarService {

    private final CarRepository carRepository;

    private final ParameterRepository parameterRepository;

    public void save(List<ResponseDto> responsesDto) {
        parameterRepository.save(
                Parameter.builder()
                        .key(ParameterEnum.LAST_SEARCH.toString())
                        .value(LocalDateTime.now().toString())
                        .build()
        );

        List<Car> cars = responsesDto.stream().map(Car::of).collect(Collectors.toList());
        carRepository.saveAll(cars);
    }

    public Long countNewRecordsToday() {
        LocalDateTime today = LocalDateTime.now().withHour(0).withSecond(0);
        return carRepository.countByDtCreateGreaterThanEqual(today);
    }
}
