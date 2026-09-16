package com.example.productapi.repository;

import com.example.productapi.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repositorio para la entidad Product que proporciona operaciones CRUD
 * y consultas personalizadas sobre la tabla de productos.
 * 
 * Esta interfaz extiende JpaRepository que proporciona automáticamente
 * las operaciones básicas de persistencia: save, findById, findAll, delete, etc.
 * 
 * Spring Data JPA genera la implementación en tiempo de ejecución basándose
 * en los métodos declarados en esta interfaz mediante el mecanismo de
 * query derivation (derivación de consultas por nombre de método).
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    /**
     * Busca un producto por su nombre exacto.
     * Spring Data deriva automáticamente la consulta SQL de este método.
     * 
     * @param name Nombre del producto a buscar
     * @return Optional containing el producto si existe, o vacío si no
     */
    Optional<Product> findByName(String name);

    /**
     * Verifica si existe un producto con el nombre especificado.
     * Utilizado para validar unicidad antes de crear nuevos productos.
     * 
     * @param name Nombre del producto a verificar
     * @return true si existe un producto con ese nombre, false en caso contrario
     */
    boolean existsByName(String name);

    /**
     * Busca productos cuyo precio sea mayor o igual al valor especificado.
     * 
     * @param minPrice Precio mínimo a filtrar
     * @return Lista de productos que cumplen el criterio
     */
    List<Product> findByPriceGreaterThanEqual(Double minPrice);

    /**
     * Busca productos cuyo stock sea menor o igual al valor especificado.
     * Útil para identificar productos con bajo inventario.
     * 
     * @param maxStock Stock máximo a filtrar
     * @return Lista de productos con stock bajo
     */
    List<Product> findByStockLessThanEqual(Integer maxStock);

    /**
     * Consulta JPQL personalizada para buscar productos en un rango de precios.
     * 
     * @param minPrice Precio mínimo del rango
     * @param maxPrice Precio máximo del rango
     * @return Lista de productos en el rango de precios especificado
     */
    @Query("SELECT p FROM Product p WHERE p.price BETWEEN :minPrice AND :maxPrice")
    List<Product> findByPriceRange(@Param("minPrice") Double minPrice, 
                                    @Param("maxPrice") Double maxPrice);

    /**
     * Consulta nativa para contar productos con stock disponible.
     * 
     * @return Número de productos con stock mayor a cero
     */
    @Query(value = "SELECT COUNT(*) FROM product WHERE stock > 0", nativeQuery = true)
    int countProductsInStock();

    /**
     * Busca productos ordenados por precio ascendente.
     * 
     * @return Lista de productos ordenada por precio
     */
    List<Product> findAllByOrderByPriceAsc();

    /**
     * Busca productos ordenados por nombre ascendente.
     * 
     * @return Lista de productos ordenada alfabéticamente
     */
    List<Product> findAllByOrderByNameAsc();
}