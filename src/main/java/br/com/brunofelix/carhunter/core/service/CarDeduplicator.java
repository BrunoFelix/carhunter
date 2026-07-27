package br.com.brunofelix.carhunter.core.service;

import br.com.brunofelix.carhunter.core.domain.response.ResponseDto;

import java.util.List;

public final class CarDeduplicator {

    private CarDeduplicator() {}

    public static boolean isDuplicate(List<ResponseDto> existing, ResponseDto candidate) {
        return existing.stream().anyMatch(
                it -> (it.getKm() / 1000) == (candidate.getKm() / 1000)
                        && it.getYear().equals(candidate.getYear())
                        && (it.getPrice() / 1000) == (candidate.getPrice() / 1000)
                        && it.getModel().equals(candidate.getModel()));
    }
}
