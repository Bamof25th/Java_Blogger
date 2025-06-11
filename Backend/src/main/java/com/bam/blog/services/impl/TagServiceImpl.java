package com.bam.blog.services.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.bam.blog.domain.entities.Tag;
import com.bam.blog.repository.TagRepository;
import com.bam.blog.services.TagService;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TagServiceImpl implements TagService {

    private final TagRepository tagRepository;

    @Override
    public List<Tag> getTags() {
        return tagRepository.findAllWithPostCount();
    }

    @Transactional
    @Override
    public List<Tag> createTags(Set<String> tagNames) {
        List<Tag> existingTags = tagRepository.findByNameIn(tagNames);
        Set<String> existingTagNames = existingTags.stream().map(Tag::getName)
                .collect(Collectors.toSet());
        List<Tag> newTags = tagNames.stream().filter(name -> !existingTagNames.contains(name))
                .map(name -> Tag.builder().name(name)
                        .posts(new HashSet<>())
                        .build())
                .toList();
        List<Tag> savedTags = new ArrayList<>();
        if (!newTags.isEmpty()) {
            savedTags = tagRepository.saveAll(newTags);
        }
        savedTags.addAll(existingTags);
        return savedTags;
    }

    @Transactional
    @Override
    public void deleteTag(UUID tagId) {

        tagRepository.findById(tagId).ifPresent(tag -> {
            if (!tag.getPosts().isEmpty()) {
                throw new IllegalStateException("Can not delete tags with Posts!");
            }
            tagRepository.deleteById(tagId);
        });

    }

    @Override
    public Tag getTagById(UUID tagId) {
        return tagRepository.findById(tagId)
                .orElseThrow(() -> new EntityNotFoundException("Tag Not found with Id" + tagId));
    }

}
