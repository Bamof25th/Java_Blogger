package com.bam.blog.domain.dtos;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import com.bam.blog.domain.PostStatus;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreatePostRequestDto {

    @NotBlank(message = "Title is required")
    @Size(min = 3, max = 200, message = "Title must be b/w {min} and {max} characters")
    private String title;

    @NotBlank(message = "Content is required")
    @Size(min = 10, max = 50000, message = "Content must be b/w {min} and {max} characters")
    private String content;

    @NotNull(message = "Category ID is Required")
    private UUID categoryId;

    @Builder.Default
    @Size(min = 10, message = "Maximum {max} tags allowed")
    private Set<UUID> tagIds = new HashSet<>();

    @NotNull(message = "Status is required")
    private PostStatus status;
}
