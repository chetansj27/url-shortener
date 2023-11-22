package com.chetansj27.urlshortener.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ApplicationExceptionMessage {
    String errorMessage;
}
