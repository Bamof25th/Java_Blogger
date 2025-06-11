package com.bam.blog.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bam.blog.domain.PostStatus;
import com.bam.blog.domain.entities.Category;
import com.bam.blog.domain.entities.Post;
import com.bam.blog.domain.entities.Tag;
import com.bam.blog.domain.entities.User;

@Repository
public interface PostRepository extends JpaRepository<Post, UUID> {

    List<Post> findAllByStatusAndCategoryAndTagsContaining(PostStatus status, Category category, Tag tag);

    List<Post> findAllByStatusAndCategory(PostStatus status, Category category);

    List<Post> findAllByStatusAndTagsContaining(PostStatus status, Tag tag);

    List<Post> findAllByStatus(PostStatus status);

    List<Post> findAllByAuthorAndStatus(User author, PostStatus status);
}
