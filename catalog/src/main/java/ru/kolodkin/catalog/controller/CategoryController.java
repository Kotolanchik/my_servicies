package ru.kolodkin.catalog.controller;

import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.kolodkin.catalog.domain.Category;
import ru.kolodkin.catalog.dto.CategoryDTO;
import ru.kolodkin.catalog.service.CategoryService;
import ru.kolodkin.catalog.service.ProductService;

import java.util.List;

import static lombok.AccessLevel.PRIVATE;

@RestController
@ResponseBody
@FieldDefaults(level = PRIVATE)
public class CategoryController {
    final ProductService productService;
    final CategoryService categoryService;

    public CategoryController(ProductService productService, CategoryService categoryService) {
        this.productService = productService;
        this.categoryService = categoryService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Category>> getCategories() {
        return ResponseEntity.ok(categoryService.getCategories());
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<Category> getCategories(@PathVariable("id") final long id) {
        return ResponseEntity.ok(categoryService.getCategory(id));
    }

    @PostMapping("/save")
    public ResponseEntity<Category> saveCategory(@RequestBody final CategoryDTO category) {
        System.out.println("category = " + category);
        return ResponseEntity.ok(categoryService.saveCategory(category));
    }
}
