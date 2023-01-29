package ru.kolodkin.catalog.mapper;

import org.mapstruct.Mapper;
import ru.kolodkin.catalog.domain.Category;
import ru.kolodkin.catalog.dto.CategoryDTO;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    CategoryDTO toCategoryDTO(Category category);

    Category toCategory(CategoryDTO categoryDTO);
}
