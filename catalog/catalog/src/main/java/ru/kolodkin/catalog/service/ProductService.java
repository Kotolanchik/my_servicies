package ru.kolodkin.catalog.service;

import org.springframework.stereotype.Service;
import ru.kolodkin.catalog.domain.Product;
import ru.kolodkin.catalog.repository.ProductRepository;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product getProduct(final long productId) {
        return productRepository.findById(productId);
    }

    public Product saveProduct(final Product product) { // TODO: 26.01.2023 добавить проверку категорий
        return productRepository.save(product);
    }

    public void deleteProduct(final long productId) {
        productRepository.deleteById(productId);
    }


}
