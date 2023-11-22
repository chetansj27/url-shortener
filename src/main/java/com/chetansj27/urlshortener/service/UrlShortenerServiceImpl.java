package com.chetansj27.urlshortener.service;

import com.chetansj27.urlshortener.entity.UrlDocument;
import com.chetansj27.urlshortener.exception.UrlException;
import com.chetansj27.urlshortener.model.UrlRequest;
import com.chetansj27.urlshortener.repository.UrlRepository;
import com.chetansj27.urlshortener.util.UrlEncoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Optional;

import static com.chetansj27.urlshortener.constant.Constant.INVALID_URL_PASSED_MESSAGE;

@Service
public class UrlShortenerServiceImpl implements UrlShortenerService {
    Logger logger = LoggerFactory.getLogger(UrlShortenerServiceImpl.class);
    private final UrlRepository urlRepository;

    @Autowired
    public UrlShortenerServiceImpl(UrlRepository urlRepository) {
        this.urlRepository = urlRepository;
    }

    @Override
    public UrlDocument generateShortUrl(UrlRequest urlRequest) {
        checkUrlIsValid(urlRequest.longUrl());
        Optional<UrlDocument> existingUrl = urlRepository.findByLongUrl(urlRequest.longUrl());
        if (existingUrl.isPresent()) {
            logger.info("entry for this url already exist in db {}", urlRequest.longUrl());
            return existingUrl.get();
        }
        UrlDocument urlDocument = UrlDocument.builder().shortUrl(UrlEncoder.encodedBase62()).longUrl(urlRequest.longUrl()).build();
        return urlRepository.save(urlDocument);
    }

    private void checkUrlIsValid(String longUrl) {
        try {
            new URL(longUrl).toURI();
        } catch (MalformedURLException | URISyntaxException e) {
            logger.error("url is not valid {}", longUrl);
            throw new UrlException(INVALID_URL_PASSED_MESSAGE);
        }
    }

    @Override
    public String getLongUrl(String shortUrl) {
        Optional<UrlDocument> urlDocument = urlRepository.findByShortUrl(shortUrl);
        if (urlDocument.isPresent()) {
            return urlDocument.get().getLongUrl();
        }
        logger.info("{} url doesn't exist in db", shortUrl);
        return shortUrl;
    }
}
