package com.english.ua.article.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record PageUpdateRequest(
        @NotNull(message = "Id cannot be null")
        @Min(value = 1, message = "Id cannot be less than 1")
        Long id,
        @NotNull(message = "Article Id cannot be null")
        @Min(value = 1, message = "Article Id cannot be less than 1")
        Long articleId,
        @NotBlank(message = "Title cannot be blank")
        @Size(max = 255, message = "Title cannot be longer than 255 characters")
        String title
) {
}
