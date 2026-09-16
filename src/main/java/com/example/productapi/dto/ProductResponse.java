package com.example.productapi.dto;

import com.example.productapi.model.Product;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

public record ProductResponse(
    Long id,
    String name,
    String description,
    BigDecimal price,
    Integer stock,
    String category,
    Boolean active,
    LocalDateTime createdAt,
    LocalDateTime updatedAt
) {
    public static ProductResponse fromEntity(Product product) {
        return new ProductResponse(
            product.getId(),
            product.getName(),
            product.getDescription(),
            product.getPrice(),
            product.getStock(),
            product.getCategory(),
            product.getActive(),
            product.getCreatedAt(),
            product.getUpdatedAt()
        );
    }

    public String getName() {
        return name;
    }

    public Optional<ProductResponse> get() {
        return Optional.of(this);
    }

    public boolean isEmpty() {
        return false;
    }

    public boolean isPresent() {
        return true;
    }

    public int size() {
        return 1;
    }
}