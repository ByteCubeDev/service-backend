package com.masteraggregator.service;

import com.masteraggregator.entity.Category;
import com.masteraggregator.exception.CategoryNotFoundException;
import com.masteraggregator.repository.CategoryRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository repository;

    @Transactional
    public Category createCategory(Category category) {
        return repository.save(category);
    }

    public List<Category> getAllCategories() {
        return repository.findAll();
    }

    public Category getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Category not found with id=" + id));
    }

    @Transactional
    public Category updateCategory(Long id, String newName) {
        Category category = getById(id);
        category.setName(newName);
        return repository.save(category);
    }

    @Transactional
    public void deleteCategory(Long id) {
        Category category = repository.findById(id)
                .orElseThrow(() -> new CategoryNotFoundException(id));
        repository.delete(category);
    }

}