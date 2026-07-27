package br.com.brunofelix.carhunter.core.gateway;

import br.com.brunofelix.carhunter.core.domain.Parameter;

public interface ParameterRepository {
    void save(Parameter parameter);
}
