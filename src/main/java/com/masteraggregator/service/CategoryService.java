package com.masteraggregator.service;

import com.masteraggregator.entity.Category;
import com.masteraggregator.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository repository;

    public CategoryService(CategoryRepository repository) {
        this.repository = repository;
    }

    /**
     * Создать новую категорию
     */
    public Category createCategory(Category category) {
        return repository.save(category);
    }

    /**
     * Получить все категории
     */
    public List<Category> getAllCategories() {
        return repository.findAll();
    }

    /**
     * Получить категорию по ID
     */
    public Category getCategoryById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));
    }

    /**
     * Обновить категорию
     */
    public Category updateCategory(Long id, String newName) {
        Category category = getCategoryById(id);
        category.setName(newName);
        return repository.save(category);
    }
    public Category getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));
    }

    /**
     * Удалить категорию
     */
    public void deleteCategory(Long id) {
        repository.deleteById(id);
    }
}
