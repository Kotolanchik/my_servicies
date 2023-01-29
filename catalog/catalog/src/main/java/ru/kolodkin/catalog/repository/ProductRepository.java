package ru.kolodkin.catalog.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.kolodkin.catalog.domain.Product;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findById(final long id);

    @Query("SELECT prod from Product prod " +
            "WHERE prod.category.id != null AND prod.category.id = :categoryId")
    List<Product> getProductsByCategoryQuery(@Param("categoryId") final long categoryId);
}
