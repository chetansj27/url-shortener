package com.chetansj27.urlshortener.service;

import com.chetansj27.urlshortener.entity.UrlDocument;
import com.chetansj27.urlshortener.model.UrlRequest;

public interface UrlShortenerService {
    UrlDocument generateShortUrl(UrlRequest urlRequest);

    String getLongUrl(String shortUrl);
}
