package com.example.productapi.service;

import com.example.productapi.dto.ProductRequest;
import com.example.productapi.dto.ProductResponse;
import com.example.productapi.exception.ProductAlreadyExistsException;
import com.example.productapi.model.Product;
import com.example.productapi.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductService productService;

    private Product product;
    private ProductRequest productRequest;
    private ProductResponse productResponse;

    @BeforeEach
    void setUp() {
        product = new Product("Laptop", new BigDecimal("1299.99"), 10);
        product.setId(1L);
        product.setDescription("High-performance laptop");
        product.setCategory("Electronics");
        product.setActive(true);
        product.setCreatedAt(LocalDateTime.now());
        product.setUpdatedAt(LocalDateTime.now());

        productRequest = new ProductRequest();
        productRequest.setName("Laptop");
        productRequest.setDescription("High-performance laptop");
        productRequest.setPrice(new BigDecimal("1299.99"));
        productRequest.setStock(10);
        productRequest.setCategory("Electronics");
        productRequest.setActive(true);

        productResponse = new ProductResponse(
                1L,
                "Laptop",
                "High-performance laptop",
                new BigDecimal("1299.99"),
                10,
                "Electronics",
                true,
                LocalDateTime.now(),
                LocalDateTime.now()
        );
    }

    @Test
    @DisplayName("getAllProducts - Should return all products")
    void getAllProducts_ReturnsAllProducts() {
        List<Product> products = Arrays.asList(product);
        when(productRepository.findAll()).thenReturn(products);

        List<ProductResponse> result = productService.getAllProducts();

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("Laptop", result.get(0).getName());
        verify(productRepository, times(1)).findAll();
    }

    @Test
    @DisplayName("getAllProducts - Should return empty list when no products")
    void getAllProducts_ReturnsEmptyList() {
        when(productRepository.findAll()).thenReturn(Arrays.asList());

        List<ProductResponse> result = productService.getAllProducts();

        assertNotNull(result);
        assertTrue(result.isEmpty());
        verify(productRepository, times(1)).findAll();
    }

    @Test
    @DisplayName("getProductById - Should return product when exists")
    void getProductById_WhenExists_ReturnsProduct() {
        when(productRepository.findById(1L)).thenReturn(Optional.of(product));

        Optional<ProductResponse> result = productService.getProductById(1L);

        assertTrue(result.isPresent());
        assertEquals("Laptop", result.get().getName());
        verify(productRepository, times(1)).findById(1L);
    }

    @Test
    @DisplayName("getProductById - Should return empty when not exists")
    void getProductById_WhenNotExists_ReturnsEmpty() {
        when(productRepository.findById(999L)).thenReturn(Optional.empty());

        Optional<ProductResponse> result = productService.getProductById(999L);

        assertFalse(result.isPresent());
        verify(productRepository, times(1)).findById(999L);
    }

    @Test
    @DisplayName("createProduct - Should create product when name is unique")
    void createProduct_WhenNameIsUnique_CreatesProduct() {
        when(productRepository.existsByName("Laptop")).thenReturn(false);
        when(productRepository.save(any(Product.class))).thenReturn(product);

        ProductResponse result = productService.createProduct(productRequest);

        assertNotNull(result);
        assertEquals("Laptop", result.getName());
        verify(productRepository, times(1)).existsByName("Laptop");
        verify(productRepository, times(1)).save(any(Product.class));
    }

    @Test
    @DisplayName("createProduct - Should throw exception when name already exists")
    void createProduct_WhenNameExists_ThrowsException() {
        when(productRepository.existsByName("Laptop")).thenReturn(true);

        assertThrows(ProductAlreadyExistsException.class, () -> {
            productService.createProduct(productRequest);
        });

        verify(productRepository, times(1)).existsByName("Laptop");
        verify(productRepository, never()).save(any(Product.class));
    }

    @Test
    @DisplayName("createProduct - Should throw exception when price is negative")
    void createProduct_WhenPriceIsNegative_ThrowsException() {
        productRequest.setPrice(new BigDecimal("-100"));

        assertThrows(IllegalArgumentException.class, () -> {
            productService.createProduct(productRequest);
        });

        verify(productRepository, never()).save(any(Product.class));
    }

    @Test
    @DisplayName("createProduct - Should throw exception when stock is negative")
    void createProduct_WhenStockIsNegative_ThrowsException() {
        productRequest.setStock(-5);

        assertThrows(IllegalArgumentException.class, () -> {
            productService.createProduct(productRequest);
        });

        verify(productRepository, never()).save(any(Product.class));
    }

    @Test
    @DisplayName("updateProduct - Should update product when exists")
    void updateProduct_WhenExists_UpdatesProduct() {
        ProductRequest updateRequest = new ProductRequest();
        updateRequest.setName("Updated Laptop");
        updateRequest.setDescription("Updated description");
        updateRequest.setPrice(new BigDecimal("1499.99"));
        updateRequest.setStock(20);
        updateRequest.setCategory("Electronics");
        updateRequest.setActive(true);

        when(productRepository.findById(1L)).thenReturn(Optional.of(product));
        when(productRepository.save(any(Product.class))).thenReturn(product);

        Optional<ProductResponse> result = productService.updateProduct(1L, updateRequest);

        assertTrue(result.isPresent());
        verify(productRepository, times(1)).findById(1L);
        verify(productRepository, times(1)).save(any(Product.class));
    }

    @Test
    @DisplayName("updateProduct - Should return empty when product not found")
    void updateProduct_WhenNotFound_ReturnsEmpty() {
        when(productRepository.findById(999L)).thenReturn(Optional.empty());

        Optional<ProductResponse> result = productService.updateProduct(999L, productRequest);

        assertFalse(result.isPresent());
        verify(productRepository, times(1)).findById(999L);
        verify(productRepository, never()).save(any(Product.class));
    }

    @Test
    @DisplayName("deleteProduct - Should delete product when exists")
    void deleteProduct_WhenExists_DeletesProduct() {
        when(productRepository.existsById(1L)).thenReturn(true);
        doNothing().when(productRepository).deleteById(1L);

        assertDoesNotThrow(() -> productService.deleteProduct(1L));

        verify(productRepository, times(1)).existsById(1L);
        verify(productRepository, times(1)).deleteById(1L);
    }

    @Test
    @DisplayName("deleteProduct - Should throw exception when not found")
    void deleteProduct_WhenNotFound_ThrowsException() {
        when(productRepository.existsById(999L)).thenReturn(false);

        assertThrows(RuntimeException.class, () -> {
            productService.deleteProduct(999L);
        });

        verify(productRepository, times(1)).existsById(999L);
        verify(productRepository, never()).deleteById(anyLong());
    }

    @Test
    @DisplayName("reduceStock - Should reduce stock when sufficient")
    void reduceStock_WhenSufficient_ReducesStock() {
        when(productRepository.findById(1L)).thenReturn(Optional.of(product));
        when(productRepository.save(any(Product.class))).thenReturn(product);

        productService.reduceStock(1L, 5);

        verify(productRepository, times(1)).findById(1L);
        verify(productRepository, times(1)).save(any(Product.class));
    }

    @Test
    @DisplayName("reduceStock - Should throw exception when insufficient stock")
    void reduceStock_WhenInsufficient_ThrowsException() {
        when(productRepository.findById(1L)).thenReturn(Optional.of(product));

        assertThrows(IllegalArgumentException.class, () -> {
            productService.reduceStock(1L, 20);
        });

        verify(productRepository, times(1)).findById(1L);
        verify(productRepository, never()).save(any(Product.class));
    }

    @Test
    @DisplayName("increaseStock - Should increase stock")
    void increaseStock_IncreasesStock() {
        when(productRepository.findById(1L)).thenReturn(Optional.of(product));
        when(productRepository.save(any(Product.class))).thenReturn(product);

        productService.increaseStock(1L, 10);

        verify(productRepository, times(1)).findById(1L);
        verify(productRepository, times(1)).save(any(Product.class));
    }

    @Test
    @DisplayName("findByPriceGreaterThanEqual - Should return products above price")
    void findByPriceGreaterThanEqual_ReturnsMatchingProducts() {
        List<Product> products = Arrays.asList(product);
        when(productRepository.findByPriceGreaterThanEqual(1000.0)).thenReturn(products);

        List<ProductResponse> result = productService.findByPriceGreaterThanEqual(new BigDecimal("1000"));

        assertNotNull(result);
        assertEquals(1, result.size());
        verify(productRepository, times(1)).findByPriceGreaterThanEqual(1000.0);
    }

    @Test
    @DisplayName("findByStockLessThanEqual - Should return products below stock threshold")
    void findByStockLessThanEqual_ReturnsMatchingProducts() {
        List<Product> products = Arrays.asList(product);
        when(productRepository.findByStockLessThanEqual(5)).thenReturn(products);

        List<ProductResponse> result = productService.findByStockLessThanEqual(5);

        assertNotNull(result);
        assertEquals(1, result.size());
        verify(productRepository, times(1)).findByStockLessThanEqual(5);
    }

    @Test
    @DisplayName("findAllByOrderByPriceAsc - Should return products ordered by price")
    void findAllByOrderByPriceAsc_ReturnsOrderedProducts() {
        List<Product> products = Arrays.asList(product);
        when(productRepository.findAllByOrderByPriceAsc()).thenReturn(products);

        List<ProductResponse> result = productService.findAllByOrderByPriceAsc();

        assertNotNull(result);
        assertEquals(1, result.size());
        verify(productRepository, times(1)).findAllByOrderByPriceAsc();
    }

    @Test
    @DisplayName("findAllByOrderByNameAsc - Should return products ordered by name")
    void findAllByOrderByNameAsc_ReturnsOrderedProducts() {
        List<Product> products = Arrays.asList(product);
        when(productRepository.findAllByOrderByNameAsc()).thenReturn(products);

        List<ProductResponse> result = productService.findAllByOrderByNameAsc();

        assertNotNull(result);
        assertEquals(1, result.size());
        verify(productRepository, times(1)).findAllByOrderByNameAsc();
    }
}