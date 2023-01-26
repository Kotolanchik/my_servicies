package ru.kolodkin.catalog.domain;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    String name;
    String description;
    BigDecimal price;
    Long amount;
    @Enumerated(EnumType.STRING)
    private ProductState state;
    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    public void incrementAmount(long value) {
        amount = amount == null ? value : amount + value;
    }

    public enum ProductState {
        AVAILABLE,
        UNAVAILABLE
    }
}
