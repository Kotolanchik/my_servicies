package ru.kolodkin.catalog.service;

import org.springframework.stereotype.Service;
import ru.kolodkin.catalog.domain.Category;
import ru.kolodkin.catalog.repository.CategoryRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category saveCategory(final Category category){
        return categoryRepository.save(category);
    }

    public Optional<Category> getCategory(final long categoryId) {
        return categoryRepository.findById(categoryId);
    }

    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }
}
