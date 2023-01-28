package ru.kolodkin.catalog.controller;

import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;
import ru.kolodkin.catalog.domain.Product;
import ru.kolodkin.catalog.service.ProductService;

import static lombok.AccessLevel.PRIVATE;

@RestController
@RequestMapping("/product")
@FieldDefaults(level = PRIVATE)
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping("/{id}")
    @ResponseBody

    public Response getProduct(@PathVariable("id") final long id) {
        return Response.ok(productService.getProduct(id))
                .build();
    }

    @GetMapping("/all")
    @ResponseBody

    public Response getProducts() {
        return Response.ok(productService.getProducts()).build();
    }

    @PostMapping("/add")
    @ResponseBody
    public Response saveProduct(@RequestBody final Product product) {
        return Response.ok(productService.saveProduct(product))
                .build();
    }

    @DeleteMapping("/{id}/delete")

    public Response deleteProduct(@PathParam("id") final long id) {
        productService.deleteProduct(id);
        return Response.ok()
                .build();
    }
}
