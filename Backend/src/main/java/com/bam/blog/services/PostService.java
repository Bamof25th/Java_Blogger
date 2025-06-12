package com.bam.blog.services;

import java.util.List;
import java.util.UUID;

import com.bam.blog.domain.CreatePostRequest;
import com.bam.blog.domain.UpdatePostRequest;
import com.bam.blog.domain.entities.Post;
import com.bam.blog.domain.entities.User;

public interface PostService {

    // @Query("")
    List<Post> getAllPosts(UUID categoryId, UUID tagId);

    List<Post> getDraftPosts(User user);

    Post createPost(User user, CreatePostRequest createPostRequest);

    Post updatePost(UUID id, UpdatePostRequest updatePostRequest);

    Post getPost(UUID id);

    void deletePost(UUID postId);

}
