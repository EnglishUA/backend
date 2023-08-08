package com.english.ua.article.service.impl;

import com.english.ua.article.entity.Article;
import com.english.ua.article.repository.ArticleRepository;
import com.english.ua.article.service.ArticleService;
import com.english.ua.shared.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ArticleServiceImpl implements ArticleService {

    private final ImageService imageService;
    private final ArticleRepository articleRepository;

    @Override
    public List<Article> findAll() {
        return articleRepository.findAll();
    }

    @Override
    public Article findById(final Long articleId) {
        return articleRepository.findById(articleId).orElseThrow();
    }

    @Override
    public Article save(final Article article) {
        return articleRepository.save(article);
    }

    @Override
    public Article updateImage(final Long articleId, final MultipartFile image) {
        final var article = findById(articleId);
        article.setImage(imageService.updateArticleImage(article.getId(), article.getImage(), image));
        return articleRepository.save(article);
    }

    @Override
    public Article update(final Article article) {
        return articleRepository.save(article);
    }

    @Override
    public void deleteById(final Long articleId) {
        articleRepository.deleteById(articleId);
    }
}
