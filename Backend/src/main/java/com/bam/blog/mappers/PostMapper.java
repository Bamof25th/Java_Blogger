package com.bam.blog.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import com.bam.blog.domain.CreatePostRequest;
import com.bam.blog.domain.UpdatePostRequest;
import com.bam.blog.domain.dtos.CreatePostRequestDto;
import com.bam.blog.domain.dtos.PostDto;
import com.bam.blog.domain.dtos.UpdatePostRequestDto;
import com.bam.blog.domain.entities.Post;

@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.IGNORE, uses = { CategoryMapper.class,
        TagMapper.class })
public interface PostMapper {

    @Mapping(target = "category", source = "category")
    @Mapping(target = "tags", source = "tags")
    @Mapping(target = "author", source = "author")
    @Mapping(target = "status", source = "status")
    PostDto toDto(Post post);

    CreatePostRequest toCreatePostRequest(CreatePostRequestDto createPostRequestDto);

    UpdatePostRequest toUpdatePostRequest(UpdatePostRequestDto updatePostRequestDto);
}
