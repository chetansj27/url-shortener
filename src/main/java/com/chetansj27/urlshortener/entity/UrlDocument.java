package com.chetansj27.urlshortener.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@Document("urls")
public class UrlDocument {
    @Id
    private String id;
    @Indexed(unique = true)
    private String shortUrl;
    private String longUrl;
    @CreatedDate
    private String createdDate;
}
