package com.english.ua.atricle.dto.request;

import com.english.ua.atricle.entity.Complexity;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record ArticleUpdateRequest(
        @NotNull(message = "Id cannot be null")
        @Min(value = 1, message = "Id cannot be less than 1")
        Long id,
        @NotBlank(message = "Title cannot be blank")
        @Size(max = 255, message = "Title cannot be longer than 255 characters")
        String title,
        @Size(max = 255, message = "Description cannot be longer than 255 characters")
        String description,
        @NotNull(message = "Complexity cannot be null")
        Complexity complexity
) {
}
