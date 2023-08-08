package com.english.ua.article.dto.response;

import com.english.ua.article.entity.Complexity;

public record ArticleResponse(
        Long id,
        String title,
        String description,
        String image,
        Complexity complexity
) {
}
