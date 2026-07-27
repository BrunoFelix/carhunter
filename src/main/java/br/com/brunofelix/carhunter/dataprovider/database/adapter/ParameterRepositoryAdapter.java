package br.com.brunofelix.carhunter.dataprovider.database.adapter;

import br.com.brunofelix.carhunter.core.domain.Parameter;
import br.com.brunofelix.carhunter.core.gateway.ParameterRepository;
import br.com.brunofelix.carhunter.dataprovider.database.mapper.ParameterEntityMapper;
import br.com.brunofelix.carhunter.dataprovider.database.repository.SpringDataParameterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ParameterRepositoryAdapter implements ParameterRepository {

    private final SpringDataParameterRepository repository;

    @Override
    public void save(Parameter parameter) {
        repository.save(ParameterEntityMapper.toEntity(parameter));
    }
}
