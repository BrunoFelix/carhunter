package br.com.brunofelix.carhunter.core.service;

import br.com.brunofelix.carhunter.core.domain.response.ResponseDto;

import java.util.Objects;
import java.util.stream.Stream;

public final class CarValidator {

    public static final int KM_MAX = 50000;

    private static final String[] EXCLUDED_TERMS = {"entrada", "-ent-", "jet-ski", "-gas-", "gnv", "parcelas",
            "petrolina", "garanhuns", "unidas", "localiza", "movida"};

    private CarValidator() {}

    public static boolean isValid(ResponseDto responseDto) {
        return !containsExcludedTerm(responseDto.getInformation())
                && isValidTransmission(responseDto.getPrice(), responseDto.getTransmission())
                && isValidKm(responseDto.getKm())
                && !containsExcludedTerm(responseDto.getUrl());
    }

    private static boolean containsExcludedTerm(String value) {
        return Stream.of(EXCLUDED_TERMS)
                .anyMatch(it -> Objects.nonNull(value) && value.toLowerCase().contains(it));
    }

    private static boolean isValidKm(int km) {
        return km <= KM_MAX && km > 1000;
    }

    private static boolean isValidTransmission(int price, String transmission) {
        return !transmission.equalsIgnoreCase("manual") || price <= 60000;
    }
}
