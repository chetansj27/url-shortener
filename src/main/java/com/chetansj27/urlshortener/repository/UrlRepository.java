package com.chetansj27.urlshortener.repository;

import com.chetansj27.urlshortener.entity.UrlDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UrlRepository extends MongoRepository<UrlDocument, String> {
    Optional<UrlDocument> findByLongUrl(String longUrl);

    Optional<UrlDocument> findByShortUrl(String shortUrl);
}
