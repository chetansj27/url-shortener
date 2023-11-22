package com.chetansj27.urlshortener.controller;

import com.chetansj27.urlshortener.entity.UrlDocument;
import com.chetansj27.urlshortener.model.UrlRequest;
import com.chetansj27.urlshortener.service.UrlShortenerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.net.URI;

@RestController
public class UrlShortenerController {
    private final UrlShortenerService urlShortenerService;

    @Autowired
    UrlShortenerController(UrlShortenerService urlShortenerService) {
        this.urlShortenerService = urlShortenerService;
    }

    @PostMapping("/generateShortUrl")
    public Mono<ResponseEntity<UrlDocument>> generateShortUrl(@Valid @RequestBody UrlRequest urlRequest) {
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(urlShortenerService.generateShortUrl(urlRequest)));
    }
}
