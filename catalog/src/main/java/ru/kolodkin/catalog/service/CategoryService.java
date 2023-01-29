package ru.kolodkin.catalog.service;

import org.springframework.stereotype.Service;
import ru.kolodkin.catalog.domain.Category;
import ru.kolodkin.catalog.dto.CategoryDTO;
import ru.kolodkin.catalog.mapper.CategoryMapper;
import ru.kolodkin.catalog.repository.CategoryRepository;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;
    public CategoryService(CategoryRepository categoryRepository, CategoryMapper categoryMapper) {
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
    }

    public Category saveCategory(final CategoryDTO category){
        if (category == null) {
            throw new NullPointerException("Попытка создания категории без параметров.");
        }

        return categoryRepository.save(categoryMapper.toCategory(category));
    }

    public Category getCategory(final long categoryId) {
        return categoryRepository.findById(categoryId)
                .orElseThrow(NoSuchElementException::new);
    }

    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }
}
