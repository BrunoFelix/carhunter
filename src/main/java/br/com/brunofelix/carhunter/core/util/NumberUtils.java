package br.com.brunofelix.carhunter.core.util;

import java.util.Objects;

public final class NumberUtils {

    private NumberUtils() {}

    public static Integer convertStringToInteger(String value) {
        if (Objects.isNull(value) || value.isBlank()) {
            return 0;
        }
        String normalized = value.trim()
                .replace(".", "")
                .replace(",", ".");
        try {
            return (int) Double.parseDouble(normalized);
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}
