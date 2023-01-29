package ru.kolodkin.catalog.mapper;

import org.mapstruct.Mapper;
import ru.kolodkin.catalog.domain.Product;
import ru.kolodkin.catalog.dto.ProductDTO;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    Product toProduct(ProductDTO product);

    ProductDTO toProductDTO(Product product);
}
