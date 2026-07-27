package br.com.brunofelix.carhunter.dataprovider.database.mapper;

import br.com.brunofelix.carhunter.core.domain.Parameter;
import br.com.brunofelix.carhunter.dataprovider.database.entity.ParameterEntity;

public final class ParameterEntityMapper {

    private ParameterEntityMapper() {}

    public static ParameterEntity toEntity(Parameter parameter) {
        if (parameter == null) {
            return null;
        }
        return ParameterEntity.builder()
                .key(parameter.getKey())
                .value(parameter.getValue())
                .build();
    }
}
