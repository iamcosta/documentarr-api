package dev.kitnet.documentarapi.utils;

import java.text.Normalizer;

public class StringUtils {

    public static String unaccent(String src) {
        return Normalizer
                .normalize(src, Normalizer.Form.NFD)
                .replaceAll("[^\\p{ASCII}]", "");
    }
}
