package com.bam.blog.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.bam.blog.domain.entities.Category;
import com.bam.blog.repository.CategoryRepository;
import com.bam.blog.services.CategoryService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public List<Category> listCategories() {
        return categoryRepository.findAllWithPostcount();
    }

    @Override
    public Category createCategory(Category category) {
        String categoryName = category.getName();
        if (categoryRepository.existsByNameIgnoreCase(categoryName)) {
            throw new IllegalArgumentException("Category Already Exists");
        }

        return categoryRepository.save(category);

    }

    @Override
    public void deleteCategory(UUID id) {
        // System.out.println("the id of the category is" + id);
        Optional<Category> category = categoryRepository.findById(id);
        if (category.isPresent()) {
            if (!category.get().getPosts().isEmpty()) {
                throw new IllegalStateException("Category has Posts associated with it!!");
            }
            categoryRepository.deleteById(id);
        }
    }

}
