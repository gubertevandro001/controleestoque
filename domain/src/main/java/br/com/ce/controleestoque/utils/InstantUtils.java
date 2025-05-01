package br.com.ce.controleestoque.utils;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

public class InstantUtils {

    private InstantUtils() {}

    public static Instant now() {
        return Instant.now().minus(3, ChronoUnit.HOURS).truncatedTo(ChronoUnit.MICROS);
    }
}
