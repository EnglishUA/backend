package com.english.ua.article.mapper;

import com.english.ua.article.dto.request.ArticleCreateRequest;
import com.english.ua.article.dto.request.ArticleUpdateRequest;
import com.english.ua.article.dto.response.ArticleResponse;
import com.english.ua.article.entity.Article;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface ArticleMapper {

    Article toEntity(ArticleCreateRequest request);

    Article toEntity(ArticleUpdateRequest request);

    ArticleResponse toResponseModel(Article article);

    List<ArticleResponse> toResponseModel(List<Article> articles);
}
