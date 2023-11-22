package com.chetansj27.urlshortener.controller;

import com.chetansj27.urlshortener.service.UrlShortenerService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class UrlRedirectController {
    private final UrlShortenerService urlShortenerService;

    @Autowired
    UrlRedirectController(UrlShortenerService urlShortenerService) {
        this.urlShortenerService = urlShortenerService;
    }

    @GetMapping(value = "/{shortUrl}")
    @ResponseStatus(HttpStatus.FOUND)
    @Cacheable(value = "longUrl", key = "#shortUrl")
    public void getLongUrl(@PathVariable String shortUrl, HttpServletResponse httpServletResponse) {
        String longUrl = urlShortenerService.getLongUrl(shortUrl);
        httpServletResponse.setHeader("Location", longUrl);
        httpServletResponse.setStatus(302);
    }
}
