package com.chetansj27.urlshortener.exception;

import com.chetansj27.urlshortener.model.ApplicationExceptionMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ServerWebInputException;
import reactor.core.publisher.Mono;

import static com.chetansj27.urlshortener.constant.Constant.BAD_REQUEST_BODY_MESSAGE;
import static com.chetansj27.urlshortener.constant.Constant.INTERNAL_SERVER_ERROR_MESSAGE;

@RestControllerAdvice
public class ControllerAdvice {
    Logger logger = LoggerFactory.getLogger(ControllerAdvice.class);

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ServerWebInputException.class)
    public Mono<ResponseEntity<String>> handleBadRequestBody(ServerWebInputException e) {
        logger.info("request body not valid {}", e.getCause().getMessage());
        return Mono.just(ResponseEntity.status(HttpStatus.BAD_REQUEST).body(BAD_REQUEST_BODY_MESSAGE));
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public Mono<ResponseEntity<String>> handleExceptions(Exception e) {
        logger.info("exception occurred  {}", e.getMessage());
        return Mono.just(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(INTERNAL_SERVER_ERROR_MESSAGE));
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(UrlException.class)
    public Mono<ResponseEntity<ApplicationExceptionMessage>> handleApplicationException(UrlException e) {
        logger.info("exception occurred {}", e.getMessage());
        return Mono.just(ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ApplicationExceptionMessage.builder().errorMessage(e.getMessage()).build()));
    }
}
