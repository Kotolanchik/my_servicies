package ru.kolodkin.catalog.controller;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.kolodkin.catalog.domain.Category;
import ru.kolodkin.catalog.domain.Product;
import ru.kolodkin.catalog.service.CategoryService;
import ru.kolodkin.catalog.service.ProductService;

import static lombok.AccessLevel.PRIVATE;

@RestController
@FieldDefaults(level = PRIVATE)
public class CategoryController {
    final ProductService productService;
    final CategoryService categoryService;

    public CategoryController(ProductService productService, CategoryService categoryService) {
        this.productService = productService;
        this.categoryService = categoryService;
    }

    @GetMapping("/pr/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable("id") final long id) {
        return ResponseEntity.ok(productService.getProduct(id));
    }

    @PostMapping("/save")
    public ResponseEntity<Category> getProduct(@RequestBody final Category category) {
        return ResponseEntity.ok(categoryService.saveCategory(category));
    }
}
