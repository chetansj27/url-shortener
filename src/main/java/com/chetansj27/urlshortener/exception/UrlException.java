package com.chetansj27.urlshortener.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UrlException extends RuntimeException {
    private final String message;
}
