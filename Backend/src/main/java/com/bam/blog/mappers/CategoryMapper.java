package com.bam.blog.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;

import com.bam.blog.domain.PostStatus;
import com.bam.blog.domain.dtos.CategoryDto;
import com.bam.blog.domain.dtos.CreateCategoryRequest;
import com.bam.blog.domain.entities.Category;
import com.bam.blog.domain.entities.Post;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CategoryMapper {

    @Mapping(target = "postCount", source = "posts", qualifiedByName = "calculatePostCount")
    CategoryDto toDto(Category category);

    Category toEntity(CreateCategoryRequest createCategoryRequest);

    @Named("calculatePostCount")
    default long calculatePostCount(List<Post> posts) {
        if (null == posts) {
            return 0;
        }
        return posts.stream()
                .filter(p -> PostStatus.PUBLISHED.equals(p.getStatus()))
                .count();
    }

}
