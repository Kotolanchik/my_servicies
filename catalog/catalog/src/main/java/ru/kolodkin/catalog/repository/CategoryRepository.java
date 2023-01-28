package ru.kolodkin.catalog.repository;

import jakarta.persistence.EntityManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kolodkin.catalog.domain.Category;

@Repository
public interface CategoryRepository  extends JpaRepository<Category, Long> {
}
