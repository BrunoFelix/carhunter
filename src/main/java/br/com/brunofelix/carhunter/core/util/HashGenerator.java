package br.com.brunofelix.carhunter.core.util;

import br.com.brunofelix.carhunter.core.domain.response.ResponseDto;
import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;

public final class HashGenerator {

    private HashGenerator() {}

    public static String from(ResponseDto dto) {
        return DigestUtils.md5DigestAsHex(
                (dto.getKm() + "|" + dto.getPrice() + "|" + dto.getYear() + "|" + dto.getModel() + "|" + dto.getBrand())
                        .getBytes(StandardCharsets.UTF_8));
    }
}
