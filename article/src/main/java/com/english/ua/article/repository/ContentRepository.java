package com.english.ua.article.repository;

import com.english.ua.article.entity.Content;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContentRepository extends MongoRepository<Content, String> {
}
