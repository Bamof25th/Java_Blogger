package com.bam.blog.services;

import java.util.List;
import java.util.UUID;

import com.bam.blog.domain.entities.Post;

public interface PostService {

    // @Query("")
    List<Post> getAllPosts(UUID categoryId, UUID tagId);
}
