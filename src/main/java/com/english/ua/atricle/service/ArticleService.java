package com.english.ua.atricle.service;

import com.english.ua.atricle.entity.Article;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ArticleService {

    List<Article> findAll();

    Article findById(Long articleId);

    Article save(Article article);

    Article updateImage(Long articleId, MultipartFile image);

    Article update(Article article);

    void deleteById(Long articleId);
}
