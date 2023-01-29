package ru.kolodkin.catalog.service;

import org.springframework.stereotype.Service;
import ru.kolodkin.catalog.domain.Product;
import ru.kolodkin.catalog.dto.ProductDTO;
import ru.kolodkin.catalog.mapper.ProductMapper;
import ru.kolodkin.catalog.repository.CategoryRepository;
import ru.kolodkin.catalog.repository.ProductRepository;

import java.util.List;

@Service
public class ProductService {
    private final ProductMapper productMapper;
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public ProductService(ProductMapper productMapper, ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productMapper = productMapper;
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    public List<Product> getProductsFromCategory(final Long categoryId) {
        return productRepository.getProductsByCategoryQuery(categoryId);
    }

    public List<Product> getProductsByIds(final List<Long> productsIds) {
        return productRepository.findAllById(productsIds);
    }

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public Product getProduct(final long productId) {
        return productRepository.findById(productId);
    }

    public Product saveProduct(final ProductDTO product) { // TODO: 26.01.2023 добавить проверку категорий
        return productRepository.save(productMapper.toProduct(product));
    }

    public void deleteProduct(final long productId) {
        productRepository.deleteById(productId);
    }


}
