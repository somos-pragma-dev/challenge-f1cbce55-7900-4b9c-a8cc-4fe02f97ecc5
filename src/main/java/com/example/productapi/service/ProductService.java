package com.example.productapi.service;

import com.example.productapi.dto.ProductRequest;
import com.example.productapi.dto.ProductResponse;
import com.example.productapi.exception.ProductAlreadyExistsException;
import com.example.productapi.model.Product;
import com.example.productapi.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductResponse createProduct(ProductRequest request) {
        validarPrecioNoNegativo(request.getPrice());
        validarNombreUnico(request.getName(), null);
        validarStockNoNegativo(request.getStock());

        Product product = new Product(
            request.getName(),
            request.getPrice(),
            request.getStock()
        );
        product.setDescription(request.getDescription());
        product.setCategory(request.getCategory());
        product.setActive(request.getActive() != null ? request.getActive() : true);
        product.setCreatedAt(LocalDateTime.now());
        product.setUpdatedAt(LocalDateTime.now());

        Product saved = productRepository.save(product);
        return ProductResponse.fromEntity(saved);
    }

    @Transactional(readOnly = true)
    public List<ProductResponse> getAllProducts() {
        return productRepository.findAll()
            .stream()
            .map(ProductResponse::fromEntity)
            .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public Optional<ProductResponse> getProductById(Long id) {
        return productRepository.findById(id)
            .map(ProductResponse::fromEntity);
    }

    public Optional<ProductResponse> updateProduct(Long id, ProductRequest request) {
        Product existingProduct = productRepository.findById(id)
            .orElse(null);
        
        if (existingProduct == null) {
            return Optional.empty();
        }

        validarPrecioNoNegativo(request.getPrice());
        validarNombreUnico(request.getName(), id);
        validarStockNoNegativo(request.getStock());

        existingProduct.setName(request.getName());
        existingProduct.setDescription(request.getDescription());
        existingProduct.setPrice(request.getPrice());
        existingProduct.setStock(request.getStock());
        existingProduct.setCategory(request.getCategory());
        existingProduct.setActive(request.getActive() != null ? request.getActive() : existingProduct.getActive());
        existingProduct.setUpdatedAt(LocalDateTime.now());

        Product updated = productRepository.save(existingProduct);
        return Optional.of(ProductResponse.fromEntity(updated));
    }

    public void deleteProduct(Long id) {
        if (!productRepository.existsById(id)) {
            throw new IllegalArgumentException("Producto no encontrado con ID: " + id);
        }
        productRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public List<ProductResponse> findByPriceRange(BigDecimal minPrice, BigDecimal maxPrice) {
        if (minPrice == null || maxPrice == null) {
            throw new IllegalArgumentException("Los parámetros minPrice y maxPrice son obligatorios");
        }
        if (minPrice.compareTo(maxPrice) > 0) {
            throw new IllegalArgumentException("El precio mínimo no puede ser mayor que el máximo");
        }
        return productRepository.findByPriceRange(minPrice.doubleValue(), maxPrice.doubleValue())
            .stream()
            .map(ProductResponse::fromEntity)
            .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<ProductResponse> getProductsSortedByPrice() {
        return productRepository.findAllByOrderByPriceAsc()
            .stream()
            .map(ProductResponse::fromEntity)
            .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public int countProductsInStock() {
        return productRepository.countProductsInStock();
    }

    @Transactional(readOnly = true)
    public List<ProductResponse> findByPriceGreaterThanEqual(BigDecimal minPrice) {
        return productRepository.findByPriceGreaterThanEqual(minPrice.doubleValue())
            .stream()
            .map(ProductResponse::fromEntity)
            .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<ProductResponse> findByStockLessThanEqual(Integer maxStock) {
        return productRepository.findByStockLessThanEqual(maxStock)
            .stream()
            .map(ProductResponse::fromEntity)
            .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<ProductResponse> findAllByOrderByPriceAsc() {
        return productRepository.findAllByOrderByPriceAsc()
            .stream()
            .map(ProductResponse::fromEntity)
            .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<ProductResponse> findAllByOrderByNameAsc() {
        return productRepository.findAllByOrderByNameAsc()
            .stream()
            .map(ProductResponse::fromEntity)
            .collect(Collectors.toList());
    }

    public ProductResponse reduceStock(Long productId, Integer quantity) {
        Product product = productRepository.findById(productId)
            .orElseThrow(() -> new IllegalArgumentException("Producto no encontrado con ID: " + productId));
        
        if (quantity <= 0) {
            throw new IllegalArgumentException("La cantidad a reducir debe ser mayor a cero");
        }
        if (product.getStock() < quantity) {
            throw new IllegalArgumentException("Stock insuficiente. Disponible: " + product.getStock() + ", solicitado: " + quantity);
        }
        
        product.reduceStock(quantity);
        product.setUpdatedAt(LocalDateTime.now());
        Product updated = productRepository.save(product);
        return ProductResponse.fromEntity(updated);
    }

    public ProductResponse increaseStock(Long productId, Integer quantity) {
        Product product = productRepository.findById(productId)
            .orElseThrow(() -> new IllegalArgumentException("Producto no encontrado con ID: " + productId));
        
        if (quantity <= 0) {
            throw new IllegalArgumentException("La cantidad a incrementar debe ser mayor a cero");
        }
        
        product.increaseStock(quantity);
        product.setUpdatedAt(LocalDateTime.now());
        Product updated = productRepository.save(product);
        return ProductResponse.fromEntity(updated);
    }

    private void validarPrecioNoNegativo(BigDecimal price) {
        if (price == null) {
            throw new IllegalArgumentException("El precio es obligatorio");
        }
        if (price.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("El precio no puede ser negativo");
        }
    }

    private void validarStockNoNegativo(Integer stock) {
        if (stock == null) {
            throw new IllegalArgumentException("El stock es obligatorio");
        }
        if (stock < 0) {
            throw new IllegalArgumentException("El stock no puede ser negativo");
        }
    }

    private void validarNombreUnico(String name, Long excludeId) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("El nombre del producto es obligatorio");
        }
        
        Optional<Product> existing = productRepository.findByName(name);
        if (existing.isPresent()) {
            if (excludeId == null || !existing.get().getId().equals(excludeId)) {
                throw new ProductAlreadyExistsException("Ya existe un producto con el nombre: " + name);
            }
        }
    }
}