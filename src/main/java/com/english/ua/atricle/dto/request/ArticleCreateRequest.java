package com.english.ua.atricle.dto.request;

import com.english.ua.atricle.entity.Complexity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record ArticleCreateRequest(
        @NotBlank(message = "Title cannot be blank")
        @Size(max = 255, message = "Title cannot be longer than 255 characters")
        String title,
        @Size(max = 255, message = "Description cannot be longer than 255 characters")
        String description,
        @NotNull(message = "Complexity cannot be null")
        Complexity complexity
) {
}
