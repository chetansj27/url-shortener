package com.chetansj27.urlshortener.model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@NotNull
public record UrlRequest(@NotEmpty String longUrl) {
}
