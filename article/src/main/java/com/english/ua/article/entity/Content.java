package com.english.ua.article.entity;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Map;

@Data
@Document
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Content {

    @Id
    private String id;
    @DBRef(lazy = true)
    private Content parent;
    private Type type;
    private Map<String, String> properties;
    @DBRef(lazy = true)
    private List<Content> contents;
}
