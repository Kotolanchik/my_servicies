package ru.kolodkin.catalog.controller;

import jakarta.ws.rs.core.Response;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;
import ru.kolodkin.catalog.dto.ProductDTO;
import ru.kolodkin.catalog.service.ProductService;

import java.util.List;

import static lombok.AccessLevel.PRIVATE;

@RestController
@RequestMapping("/product")
@FieldDefaults(level = PRIVATE)
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping("/{id}")
    public Response getProduct(@PathVariable("id") final long id) {
        return Response.ok(productService.getProduct(id))
                .build();
    }

    @GetMapping("/all")
    public Response getProducts() {
        return Response.ok(productService.getProducts())
                .build();
    }

    @GetMapping("/productsFromCategory")
    public Response getProductsByCategoryId(@RequestParam("productIds") Long categoryId) {
        return Response.ok(productService.getProductsFromCategory(categoryId))
                .build();
    }

    @GetMapping("/listByIds")
    public Response getProductsByIds(@RequestParam("productIds") List<Long> productIds) {
        return Response.ok(productService.getProductsByIds(productIds))
                .build();
    }

    @PostMapping("/add")
    public Response saveProduct(@RequestBody final ProductDTO product) {
        return Response.ok(productService.saveProduct(product))
                .build();
    }

    @DeleteMapping("/{id}/delete")
    public Response deleteProduct(@PathVariable("id") final long id) {
        productService.deleteProduct(id);
        return Response.ok()
                .build();
    }
}
