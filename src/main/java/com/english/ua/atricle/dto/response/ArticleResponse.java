package com.english.ua.atricle.dto.response;

import com.english.ua.atricle.entity.Complexity;

public record ArticleResponse(
        Long id,
        String title,
        String description,
        String image,
        Complexity complexity
) {
}
