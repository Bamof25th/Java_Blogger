package com.bam.blog.services;

import java.util.List;
import java.util.Set;
import java.util.UUID;

import com.bam.blog.domain.entities.Tag;

public interface TagService {

    List<Tag> getTags();

    List<Tag> createTags(Set<String> tagNames);

    void deleteTag(UUID tagId);

    Tag getTagById(UUID tagId);

    List<Tag> getTagByIds(Set<UUID> ids);
}
