package com.example.productapi.controller;

import com.example.productapi.dto.ProductRequest;
import com.example.productapi.dto.ProductResponse;
import com.example.productapi.exception.ProductAlreadyExistsException;
import com.example.productapi.model.Product;
import com.example.productapi.service.ProductService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ProductController.class)
class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductService productService;

    @Autowired
    private ObjectMapper objectMapper;

    private ProductResponse productResponse;
    private ProductRequest productRequest;
    private Product product;

    @BeforeEach
    void setUp() {
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

        productRequest = new ProductRequest();
        productRequest.setName("Laptop");
        productRequest.setDescription("High-performance laptop");
        productRequest.setPrice(new BigDecimal("1299.99"));
        productRequest.setStock(10);
        productRequest.setCategory("Electronics");
        productRequest.setActive(true);
    }

    @Test
    @DisplayName("GET /api/products - Should return all products")
    void getAllProducts_ReturnsProductList() throws Exception {
        List<ProductResponse> products = Arrays.asList(productResponse);
        when(productService.getAllProducts()).thenReturn(products);

        mockMvc.perform(get("/api/products"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].name").value("Laptop"))
                .andExpect(jsonPath("$[0].price").value(1299.99));
    }

    @Test
    @DisplayName("GET /api/products/{id} - Should return product when exists")
    void getProductById_WhenExists_ReturnsProduct() throws Exception {
        when(productService.getProductById(1L)).thenReturn(Optional.of(productResponse));

        mockMvc.perform(get("/api/products/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.name").value("Laptop"));
    }

    @Test
    @DisplayName("GET /api/products/{id} - Should return 404 when not exists")
    void getProductById_WhenNotExists_Returns404() throws Exception {
        when(productService.getProductById(999L)).thenReturn(Optional.empty());

        mockMvc.perform(get("/api/products/999"))
                .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("POST /api/products - Should create product successfully")
    void createProduct_WhenValidRequest_ReturnsCreated() throws Exception {
        when(productService.createProduct(any(ProductRequest.class))).thenReturn(productResponse);

        mockMvc.perform(post("/api/products")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(productRequest)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.name").value("Laptop"));
    }

    @Test
    @DisplayName("POST /api/products - Should return 400 when product already exists")
    void createProduct_WhenAlreadyExists_Returns400() throws Exception {
        when(productService.createProduct(any(ProductRequest.class)))
                .thenThrow(new ProductAlreadyExistsException("Product with name Laptop already exists"));

        mockMvc.perform(post("/api/products")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(productRequest)))
                .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("POST /api/products - Should return 400 when name is blank")
    void createProduct_WhenNameBlank_Returns400() throws Exception {
        productRequest.setName("");

        mockMvc.perform(post("/api/products")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(productRequest)))
                .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("POST /api/products - Should return 400 when price is negative")
    void createProduct_WhenPriceNegative_Returns400() throws Exception {
        productRequest.setPrice(new BigDecimal("-100"));

        mockMvc.perform(post("/api/products")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(productRequest)))
                .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("PUT /api/products/{id} - Should update product successfully")
    void updateProduct_WhenValidRequest_ReturnsOk() throws Exception {
        ProductRequest updateRequest = new ProductRequest();
        updateRequest.setName("Updated Laptop");
        updateRequest.setDescription("Updated description");
        updateRequest.setPrice(new BigDecimal("1499.99"));
        updateRequest.setStock(20);
        updateRequest.setCategory("Electronics");
        updateRequest.setActive(true);

        ProductResponse updatedResponse = new ProductResponse(
                1L,
                "Updated Laptop",
                "Updated description",
                new BigDecimal("1499.99"),
                20,
                "Electronics",
                true,
                LocalDateTime.now(),
                LocalDateTime.now()
        );

        when(productService.updateProduct(anyLong(), any(ProductRequest.class))).thenReturn(Optional.of(updatedResponse));

        mockMvc.perform(put("/api/products/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(updateRequest)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Updated Laptop"))
                .andExpect(jsonPath("$.price").value(1499.99));
    }

    @Test
    @DisplayName("PUT /api/products/{id} - Should return 404 when product not found")
    void updateProduct_WhenNotFound_Returns404() throws Exception {
        when(productService.updateProduct(anyLong(), any(ProductRequest.class))).thenReturn(Optional.empty());

        mockMvc.perform(put("/api/products/999")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(productRequest)))
                .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("DELETE /api/products/{id} - Should delete product successfully")
    void deleteProduct_WhenExists_ReturnsNoContent() throws Exception {
        doNothing().when(productService).deleteProduct(1L);

        mockMvc.perform(delete("/api/products/1"))
                .andExpect(status().isNoContent());
    }

    @Test
    @DisplayName("DELETE /api/products/{id} - Should return 404 when not found")
    void deleteProduct_WhenNotFound_Returns404() throws Exception {
        doThrow(new RuntimeException("Product not found")).when(productService).deleteProduct(999L);

        mockMvc.perform(delete("/api/products/999"))
                .andExpect(status().isNotFound());
    }
}