package com.bam.blog.services.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bam.blog.domain.PostStatus;
import com.bam.blog.domain.entities.Category;
import com.bam.blog.domain.entities.Post;
import com.bam.blog.domain.entities.Tag;
import com.bam.blog.repository.PostRepository;
import com.bam.blog.services.CategoryService;
import com.bam.blog.services.PostService;
import com.bam.blog.services.TagService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final CategoryService categoryService;
    private final TagService tagService;

    @Transactional(readOnly = true)
    @Override
    public List<Post> getAllPosts(UUID categoryId, UUID tagId) {
        if (categoryId != null && tagId != null) {
            Category category = categoryService.getCategoryById(categoryId);
            Tag tag = tagService.getTagById(tagId);
            return postRepository.findAllByStatusAndCategoryAndTagsContaining(
                    PostStatus.PUBLISHED, category, tag);
        }
        if (categoryId != null) {
            Category category = categoryService.getCategoryById(categoryId);
            return postRepository.findAllByStatusAndCategory(PostStatus.PUBLISHED, category);
        }

        if (tagId != null) {
            Tag tag = tagService.getTagById(tagId);
            return postRepository.findAllByStatusAndTagsContaining(PostStatus.PUBLISHED, tag);
        }

        return postRepository.findAllByStatus(PostStatus.PUBLISHED);
    }

}
