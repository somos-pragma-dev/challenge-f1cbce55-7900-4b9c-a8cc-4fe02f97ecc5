package com.example.productapi.exception;

public class ProductAlreadyExistsException extends RuntimeException {
    private final String productName;
    private final Long existingProductId;

    public ProductAlreadyExistsException(String productName) {
        super(String.format("Ya existe un producto con el nombre: %s", productName));
        this.productName = productName;
        this.existingProductId = null;
    }

    public ProductAlreadyExistsException(String productName, Long existingProductId) {
        super(String.format("Ya existe un producto con el nombre: %s (ID existente: %d)", 
            productName, existingProductId));
        this.productName = productName;
        this.existingProductId = existingProductId;
    }

    public String getProductName() {
        return productName;
    }

    public Long getExistingProductId() {
        return existingProductId;
    }

    public String getMessage() {
        return super.getMessage();
    }

    @Override
    public String toString() {
        return "ProductAlreadyExistsException{" +
                "productName='" + productName + '\'' +
                ", existingProductId=" + existingProductId +
                '}';
    }
}