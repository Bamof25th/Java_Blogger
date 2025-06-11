package com.bam.blog.domain.dtos;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

import com.bam.blog.domain.PostStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostDto {
    public UUID id;
    private String title;
    private String content;
    private AuthorDto author;
    private CategoryDto category;
    private Set<TagDto> tags;
    private Integer readingTime;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private PostStatus status;

}
