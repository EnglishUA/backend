package com.english.ua.atricle.mapper;

import com.english.ua.atricle.dto.request.ArticleCreateRequest;
import com.english.ua.atricle.dto.request.ArticleUpdateRequest;
import com.english.ua.atricle.dto.response.ArticleResponse;
import com.english.ua.atricle.entity.Article;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface ArticleMapper {

    Article toEntity(ArticleCreateRequest request);

    Article toEntity(ArticleUpdateRequest request);

    ArticleResponse toResponseModel(Article article);

    List<ArticleResponse> toResponseModel(List<Article> articles);
}
