package com.chetansj27.urlshortener.util;

public class UrlEncoder {

    private static final String ALPHABET = "xWlP0b7NUt9qFkJzD4aXhHJ2yIiVfR6GZLQYnKpEo1r5v8m3cMgSsAeOuBwCxdT";
    private static final int BASE = 62;

    UrlEncoder() {

    }

    public static String encodedBase62() {
        StringBuilder str = new StringBuilder();
        long uniqueId = System.currentTimeMillis();
        while (uniqueId > 0) {
            str.insert(0, ALPHABET.charAt((int) (uniqueId % BASE)));
            uniqueId = uniqueId / BASE;
        }
        return str.toString();
    }


}
