# Prompt para Mejorar el Codigo Base

Copia y pega el contenido del bloque de abajo en un asistente de IA (Claude, ChatGPT)
para obtener un ZIP con el proyecto completo y arrancable.

Si preferis trabajar en tu editor con un agente local (Claude Code, Cursor, Copilot), usa `AGENTS.md` en vez de este archivo: dice lo mismo pero para que escriba los archivos en disco.

## Las dos reglas que no se negocian

1. **Completa el boilerplate.** Todo lo que el proyecto necesita para compilar y arrancar: manifiesto de dependencias, punto de entrada, configuracion, capa de interfaz, y las capas del patron arquitectonico declarado. Eso es andamiaje y es tu trabajo.
2. **NO resuelvas el reto.** Los entregables de las fases son el trabajo de la persona. El hueco pedagogico se deja como esta: el proyecto arranca, pero lo que el reto pide implementar NO esta implementado.

Dicho de otra forma: si algo impide compilar, arreglalo. Si algo es logica de negocio incompleta, validaciones ausentes, un secreto hardcodeado o un patron mejorable, dejalo exactamente como esta — es lo que la persona tiene que encontrar.

## Lo que le falta a este proyecto

Esto NO lo tenes que adivinar: salio de comparar el proyecto contra la arquitectura declarada del reto y de un analisis estatico del codigo. Completalo TODO.

### Boilerplate del stack que falta

Sin esto no compila ni arranca. Es andamiaje, no toca nada de lo pedagogico:

- **Punto de entrada del stack elegido** — Sin un punto de entrada reconocible, el runtime no tiene por donde arrancar la aplicacion.

### Referencias colgando en el codigo que si esta

Cada una rompe la compilacion:

- `src/main/java/com/example/productapi/controller/ProductController.java` — `io.swagger.v3`: El import io.swagger.v3.oas.annotations.Operation pertenece a io.swagger.v3, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- `src/main/java/com/example/productapi/config/OpenApiConfig.java` — `io.swagger.v3`: El import io.swagger.v3.oas.models.Components pertenece a io.swagger.v3, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- `src/test/java/com/example/productapi/controller/ProductControllerTest.java` — `com.fasterxml.jackson`: El import com.fasterxml.jackson.databind.ObjectMapper pertenece a com.fasterxml.jackson, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- `src/main/java/com/example/productapi/service/ProductService.java` — `ProductRepository.save`: Se invoca `save` sobre `ProductRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/example/productapi/service/ProductService.java` — `ProductRepository.findAll`: Se invoca `findAll` sobre `ProductRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/example/productapi/service/ProductService.java` — `ProductRepository.findById`: Se invoca `findById` sobre `ProductRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/example/productapi/service/ProductService.java` — `ProductRepository.existsById`: Se invoca `existsById` sobre `ProductRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/example/productapi/service/ProductService.java` — `ProductRepository.deleteById`: Se invoca `deleteById` sobre `ProductRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/example/productapi/service/ProductServiceTest.java` — `ProductRepository.findAll`: Se invoca `findAll` sobre `ProductRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/example/productapi/service/ProductServiceTest.java` — `ProductRepository.findById`: Se invoca `findById` sobre `ProductRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/example/productapi/service/ProductServiceTest.java` — `ProductRepository.save`: Se invoca `save` sobre `ProductRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/example/productapi/service/ProductServiceTest.java` — `ProductRepository.existsById`: Se invoca `existsById` sobre `ProductRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.

## Como saber que terminaste

```bash
el comando de build o arranque canonico del stack elegido
```

Ese comando corriendo sin errores es la definicion de "listo".

---

```
## Briefing del reto (autoridad)
Este bloque manda sobre los archivos adjuntos. El stack y el rol salen de AQUÍ, no de un topic genérico ni de markdown placeholder.

### Contexto técnico original
Crear una API REST con persistencia en H2 y documentación con Swagger

### Reto
- Tema: Java Spring Boot
- Seniority: junior-l1
- Tipo: practical
- Título: Desarrollo de una API REST con persistencia en H2 y documentación con Swagger
- Tiempo estimado: 8 horas

### Fases (trabajo del HUMANO — PROHIBIDO completarlas)
No implementes estos entregables. Dejalos como hueco pedagógico. El asistente solo materializa el proyecto arrancable para que el participante pueda trabajar.
- Fase 1: Configuración del entorno y creación de la estructura básica — objetivo: Configurar el entorno de desarrollo y crear la estructura básica de la API REST. — entregable (NO resolver): Proyecto Spring Boot con estructura básica y endpoints para CRUD de productos.
- Fase 2: Implementación de la lógica de negocio y validaciones — objetivo: Implementar la lógica de negocio y las validaciones necesarias para asegurar la integridad de los datos. — entregable (NO resolver): API REST con validaciones implementadas y manejo de errores.
- Fase 3: Generación de documentación con Swagger — objetivo: Generar documentación para la API utilizando Swagger. — entregable (NO resolver): API REST con documentación generada por Swagger.

Eres un asistente experto en análisis, corrección y generación de archivos de cualquier tipo:
código fuente, documentación, hojas de cálculo, documentos Word, configuraciones, entre otros.
Voy a enviarte una cadena de texto que contiene uno o más archivos. Cada archivo está delimitado por un marcador con el siguiente formato:
// === ARCHIVO: ruta/del/archivo.extension ===
o también puede aparecer como:
## === ARCHIVO: ruta/del/archivo.extension ===
Lo que sigue al marcador puede ser:

El contenido real del archivo (código, texto, YAML, etc.)
Una descripción en lenguaje natural de lo que debe contener el archivo


TU TAREA
PASO 0 — ¿Esto es un proyecto o una carcasa?
Antes de extraer archivos, leé el Briefing (si está) y diagnosticá el adjunto.

Es CARCASA si ocurre CUALQUIERA de estas:
- No hay manifiesto de dependencias del stack del briefing (manifest.json de VTEX IO / package.json / pom.xml / build.gradle / requirements.txt / go.mod / *.tf / *.csproj, según corresponda)
- Hay un "binario" que en realidad es un comentario ("no puede ser mostrado como texto plano", placeholder .fig/.docx vacío)
- Los markdowns ya completan entregables de fases posteriores ("se implementó fade-in", lista de áreas ya resuelta)

Si es CARCASA:
- MATERIALIZÁ un proyecto que arranca en el stack del briefing (VTEX IO Store Framework, Angular, Terraform, pytest, Nest, etc.). Incluí manifiesto, punto de entrada y capa de interfaz reales.
- NO copies los markdowns de "solución" como si fueran el producto. Son ruido de generación.
- NO resuelvas las fases del briefing (están marcadas PROHIBIDO). Dejá el hueco pedagógico: el flujo existe, las microinteracciones/calidad/infra que el reto pide NO están hechas.
- Después seguí al PASO 5 (ZIP).

Si es un proyecto REAL (manifiesto + código que compila o arranca):
- Seguí PASO 1 en adelante. 🔴 compilación sí. 🟡 pedagógico no.

PASO 1 — Detección y extracción
Identifica todos los archivos presentes en la cadena. Para cada archivo extrae:

Su ruta completa (ej: src/main/java/com/pragma/Service.java)
Su contenido o descripción

PASO 2 — Clasificación por tipo
Clasifica cada archivo en una de estas categorías:
A) Código fuente (Java, Python, TypeScript, JavaScript, Kotlin, etc.)
B) Configuración / documentación (YAML, properties, Markdown, JSON, txt, etc.)
C) Excel (.xlsx, .xls, .csv)
D) Word (.docx, .doc)
E) Otro tipo de archivo binario o especial
PASO 3 — Clasificación de errores en código fuente

Objetivo prioritario: que el proyecto compile. No corrijas flujo de negocio ni lógica funcional.

Antes de modificar cualquier archivo de código fuente, clasifica cada problema encontrado en una de estas dos categorías:
🔴 ERROR DE COMPILACIÓN — corregir siempre
Son errores que impiden que el proyecto arranque, sin valor pedagógico:

Import faltante o incorrecto
Clase, método o variable referenciada que no existe en ningún archivo del proyecto
Error de sintaxis
Anotación con atributos inválidos
Dependencia ausente en pom.xml, package.json, etc.
Archivo referenciado que no existe y debe ser creado con implementación mínima

→ CORREGIR estos errores.
🟡 PROBLEMA FUNCIONAL O DE CALIDAD — preservar siempre
Son problemas que no impiden compilar. Pueden ser intencionales para el aprendizaje:

Clave secreta hardcodeada ("secret", "password123")
API deprecada que funciona pero tiene reemplazo moderno
Lógica de negocio incorrecta o incompleta
Código redundante o de baja legibilidad
Falta de validaciones en flujo de negocio
Patrones de diseño incorrectos pero funcionales
Concurrencia no segura
Configuración funcional pero no óptima

→ PRESERVAR tal cual. No corregir, no mejorar, no comentar.
PASO 4 — Procesamiento según tipo de archivo
Tipo A — Código fuente
Aplica únicamente las correcciones clasificadas como 🔴 ERROR DE COMPILACIÓN.
No alteres ningún elemento clasificado como 🟡 PROBLEMA FUNCIONAL O DE CALIDAD.
Si falta un archivo referenciado, créalo con la implementación mínima necesaria para compilar.
Tipo B — Configuración / documentación
Extrae el contenido tal cual, sin modificaciones salvo errores evidentes de sintaxis
(ej: YAML mal indentado).
Tipo C — Excel (.xlsx)
Si viene con contenido real, genera el archivo respetando ese contenido.
Si viene con descripción en lenguaje natural, genera un archivo Excel funcional con:

Fila de encabezados en negrita con color de fondo distintivo
Columnas con ancho ajustado al contenido
Tipos de dato correctos por columna
Validaciones si la descripción lo indica
Hojas nombradas descriptivamente si hay más de una
Filas de ejemplo si no hay datos reales

Tipo D — Word (.docx)
Si viene con contenido real, genera el archivo respetando ese contenido.
Si viene con descripción en lenguaje natural, genera un documento Word funcional con:

Estilos de título (Título 1, Título 2) para jerarquía de secciones
Fuente legible (Calibri o equivalente), tamaño 11-12pt para cuerpo
Márgenes estándar
Tabla de contenido si tiene múltiples secciones
Tablas con encabezados en negrita si aplica

Tipo E — Otro
Genera el archivo con el contenido o estructura más apropiada según la descripción.
PASO 5 — Exportación en ZIP
Empaqueta todos los archivos en un único archivo ZIP descargable respetando exactamente
la estructura de rutas indicada por los marcadores.
El ZIP debe incluir:

Archivos de código con únicamente los errores de compilación corregidos
Archivos de configuración y documentación sin cambios
Archivos nuevos creados para resolver dependencias de compilación faltantes
Archivos Excel y Word generados desde descripción

IMPORTANTE: El ZIP debe estar listo para descargar al finalizar. No preguntes si el usuario
quiere generarlo. Simplemente genera el archivo y proporciona el enlace de descarga; No debes desplegar en el chat el resumen de lo que arreglaste al Zip, solo entregalo.

REGLAS IMPORTANTES

No omitas ningún archivo aunque no tenga errores ni modificaciones
Respeta los nombres y rutas exactas indicadas por los marcadores
Si un archivo no tiene marcador claro, infiere el nombre desde su contenido
Si la cadena contiene solo documentación, placeholders o binarios fake, NO la reproduzcas:
aplicá PASO 0 (materializar el proyecto del briefing). Reproducir la carcasa es un fallo.
No agregues texto después del enlace de descarga del ZIP
No preguntes si el usuario quiere el ZIP: simplemente generalo siempre
Si detectas que falta un archivo de configuración necesario para compilar
(pom.xml, package.json, requirements.txt, build.gradle, etc.), créalo e inclúyelo
inferiendo su contenido desde los imports y frameworks detectados en el código
Nunca corrijas problemas 🟡 aunque parezcan obvios o fáciles de mejorar.
El participante que recibirá este proyecto los debe encontrar y resolver él mismo.


INPUT
Aquí está la cadena con los archivos:

// === ARCHIVO: pom.xml ===
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>3.4.0</version>
        <relativePath/>
    </parent>

    <groupId>com.example</groupId>
    <artifactId>product-api</artifactId>
    <version>1.0.0</version>
    <name>product-api</name>
    <description>API REST para gestión de productos con persistencia H2 y documentación Swagger</description>

    <properties>
        <java.version>21</java.version>
        <maven.compiler.source>21</maven.compiler.source>
        <maven.compiler.target>21</maven.compiler.target>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
        <springdoc.version>2.6.0</springdoc.version>
        <lombok.version>1.18.34</lombok.version>
    </properties>

    <dependencies>
        <!-- Spring Boot Web -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>

        <!-- Spring Boot Data JPA -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-jpa</artifactId>
        </dependency>

        <!-- Base de datos H2 en memoria -->
        <dependency>
            <groupId>com.h2database</groupId>
            <artifactId>h2</artifactId>
            <version>2.3.230</version>
            <scope>runtime</scope>
        </dependency>

        <!-- Documentación OpenAPI con Swagger -->
        <dependency>
            <groupId>org.springdoc</groupId>
            <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
            <version>2.6.0</version>
        </dependency>

        <!-- Lombok para reducción de boilerplate -->
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <version>1.18.34</version>
            <scope>provided</scope>
        </dependency>

        <!-- Validación de datos -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-validation</artifactId>
        </dependency>

        <!-- Testing -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
                <configuration>
                    <excludes>
                        <exclude>
                            <groupId>org.projectlombok</groupId>
                            <artifactId>lombok</artifactId>
                        </exclude>
                    </excludes>
                </configuration>
            </plugin>
        </plugins>
    </build>
</project>

// === ARCHIVO: src/main/java/com/example/productapi/ProductApiApplication.java ===
package com.example.productapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * Punto de entrada principal de la aplicación Product API.
 * 
 * Esta clase configura y arranca el contexto de Spring Boot, inicializando
 * todos los beans, configuraciones y componentes definidos en el proyecto.
 * La anotación @SpringBootApplication combina tres anotaciones principales:
 * - @Configuration: Marca la clase como fuente de definiciones de beans
 * - @EnableAutoConfiguration: Habilita la configuración automática de Spring
 * - @ComponentScan: Escanea el paquete actual y subpaquetes para componentes
 * 
 * @EnableJpaAuditing permite el uso de funcionalidades de auditoría de JPA
 * como campos de fecha de creación y modificación automática.
 */
@SpringBootApplication
@EnableJpaAuditing
public class ProductApiApplication {

    /**
     * Método principal que inicia la aplicación Spring Boot.
     * 
     * @param args Argumentos de línea de comandos pasados al inicio
     */
    public static void main(String[] args) {
        SpringApplication.run(ProductApiApplication.class, args);
    }
}

// === ARCHIVO: src/main/resources/application.properties ===
# Configuración del servidor embebido
server.port=8080

# Configuración de la aplicación
spring.application.name=product-api

# Configuración de la fuente de datos H2 en memoria
spring.datasource.url=jdbc:h2:mem:productdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=

# Configuración de JPA/Hibernate
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.jpa.hibernate.ddl-auto=create-drop
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true

# Configuración de H2 Console (herramienta visual para debugging)
h2.console.enabled=true
h2.console.path=/h2-console
h2.console.settings.web-allow-others=true

# Configuración de inicialización de datos (SQL embebido)
spring.sql.init.mode=always
spring.sql.init.data-locations=classpath:data.sql

# Configuración de Swagger/OpenAPI
springdoc.api-docs.path=/v3/api-docs
springdoc.swagger-ui.path=/swagger-ui.html
springdoc.swagger-ui.enabled=true
springdoc.api-docs.enabled=true

# Configuración de logging
logging.level.org.springframework.web=INFO
logging.level.org.hibernate.SQL=DEBUG
logging.level.org.hibernate.type.descriptor.sql.BasicBinder=TRACE

// === ARCHIVO: src/main/java/com/example/productapi/repository/ProductRepository.java ===
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

// === ARCHIVO: src/main/java/com/example/productapi/model/Product.java ===
package com.example.productapi.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Entidad JPA que representa un producto en el catálogo.
 * 
 * Esta clase está mapeada a la tabla "product" en la base de datos H2.
 * Utiliza anotaciones de JPA para definir la estrategia de mapeo objeto-relacional
 * y anotaciones de Lombok para reducir el código boilerplate.
 * 
 * La entidad soporta auditoría automática de fechas de creación y modificación
 * a través de los campos annotated con @CreatedDate y @LastModifiedDate.
 */
@Entity
@Table(name = "product", indexes = {
    @Index(name = "idx_product_name", columnList = "name", unique = true),
    @Index(name = "idx_product_price", columnList = "price"),
    @Index(name = "idx_product_stock", columnList = "stock")
})
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {

    /**
     * Identificador único del producto.
     * Se genera automáticamente mediante estrategia de identidad.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Nombre del producto. Debe ser único en el catálogo.
     * No puede ser nulo ni estar vacío.
     */
    @Column(nullable = false, unique = true, length = 100)
    private String name;

    /**
     * Descripción detallada del producto.
     * Campo opcional con longitud extendida para descripciones largas.
     */
    @Column(length = 500)
    private String description;

    /**
     * Precio del producto. No puede ser negativo.
     * Se utiliza BigDecimal para precisión en cálculos monetarios.
     */
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal price;

    /**
     * Cantidad disponible en inventario.
     * No puede ser negativo.
     */
    @Column(nullable = false)
    private Integer stock;

    /**
     * Categoría a la que pertenece el producto.
     * Campo opcional para facilitar búsquedas y filtros.
     */
    @Column(length = 50)
    private String category;

    /**
     * Indica si el producto está activo/disponible para venta.
     * Los productos inactivos no se muestran en listados públicos.
     */
    @Column(nullable = false)
    @Builder.Default
    private Boolean active = true;

    /**
     * Fecha y hora de creación del registro.
     * Se asigna automáticamente por el listener de auditoría.
     */
    @CreatedDate
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    /**
     * Fecha y hora de última modificación del registro.
     * Se actualiza automáticamente en cada guardado.
     */
    @LastModifiedDate
    @Column(nullable = false)
    private LocalDateTime updatedAt;

    /**
     * Constructor con campos obligatorios para crear un nuevo producto.
     * 
     * @param name Nombre del producto
     * @param price Precio del producto
     * @param stock Cantidad en inventario
     */
    public Product(String name, BigDecimal price, Integer stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.active = true;
    }

    /**
     * Reduce el stock del producto en la cantidad especificada.
     * Método de dominio que encapsula la lógica de decremento.
     * 
     * @param quantity Cantidad a reducir
     * @throws IllegalArgumentException si la cantidad es mayor al stock disponible
     */
    public void reduceStock(Integer quantity) {
        if (quantity > this.stock) {
            throw new IllegalArgumentException(
                "Stock insuficiente. Disponible: " + this.stock + ", solicitado: " + quantity
            );
        }
        this.stock -= quantity;
    }

    /**
     * Aumenta el stock del producto en la cantidad especificada.
     * 
     * @param quantity Cantidad a agregar
     */
    public void increaseStock(Integer quantity) {
        if (quantity < 0) {
            throw new IllegalArgumentException("La cantidad a agregar no puede ser negativa");
        }
        this.stock += quantity;
    }

    /**
     * Desactiva el producto marcándolo como no disponible.
     */
    public void deactivate() {
        this.active = false;
    }

    /**
     * Activa el producto marcándolo como disponible para venta.
     */
    public void activate() {
        this.active = true;
    }

    /**
     * Verifica si el producto tiene stock disponible.
     * 
     * @return true si el stock es mayor a cero
     */
    public boolean isInStock() {
        return this.stock > 0;
    }
}

// === ARCHIVO: src/main/java/com/example/productapi/dto/ProductRequest.java ===
package com.example.productapi.dto;

import jakarta.validation.constraints.*;
import lombok.*;

import java.math.BigDecimal;

/**
 * DTO (Data Transfer Object) para la creación y actualización de productos.
 * 
 * Esta clase representa el contrato de entrada cuando un cliente envía
 * datos para crear o modificar un producto. Utiliza anotaciones de validación
 * de Jakarta Bean Validation para garantizar la integridad de los datos
 * antes de procesarlos en la capa de servicio.
 * 
 * Se utiliza como parámetro en los endpoints POST y PUT del controlador.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductRequest {

    /**
     * Nombre del producto. Campo obligatorio y con restricciones de formato.
     * - No puede estar en blanco (null, vacío o solo espacios)
     * - Longitud mínima de 2 caracteres
     * - Longitud máxima de 100 caracteres
     */
    @NotBlank(message = "El nombre del producto es obligatorio")
    @Size(min = 2, max = 100, message = "El nombre debe tener entre 2 y 100 caracteres")
    private String name;

    /**
     * Descripción detallada del producto. Campo opcional.
     * - Longitud máxima de 500 caracteres
     * - Puede ser null o estar vacía
     */
    @Size(max = 500, message = "La descripción no puede exceder 500 caracteres")
    private String description;

    /**
     * Precio del producto. Campo obligatorio con validación de rango.
     * - No puede ser nulo
     * - Debe ser mayor a cero (positivo)
     * - Valor máximo limitado a 999999.99
     */
    @NotNull(message = "El precio es obligatorio")
    @Positive(message = "El precio debe ser mayor a cero")
    @DecimalMax(value = "999999.99", message = "El precio no puede exceder 999999.99")
    private BigDecimal price;

    /**
     * Cantidad en inventario. Campo obligatorio con validación de rango.
     * - No puede ser nulo
     * - Debe ser mayor o igual a cero (no允许 stock negativo)
     * - Valor máximo de 999999 unidades
     */
    @NotNull(message = "El stock es obligatorio")
    @Min(value = 0, message = "El stock no puede ser negativo")
    @Max(value = 999999, message = "El stock no puede exceder 999999 unidades")
    private Integer stock;

    /**
     * Categoría del producto. Campo opcional para clasificación.
     * - Longitud máxima de 50 caracteres
     */
    @Size(max = 50, message = "La categoría no puede exceder 50 caracteres")
    private String category;

    /**
     * Indica si el producto está activo para venta.
     * - Valor por defecto: true
     * - Campo opcional en la request
     */
    @Builder.Default
    private Boolean active = true;
}


// === ARCHIVO: src/main/java/com/example/productapi/dto/ProductResponse.java ===
package com.example.productapi.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Schema(description = "Respuesta de producto en el catálogo")
public record ProductResponse(
    @Schema(description = "Identificador único del producto", example = "1")
    Long id,
    
    @Schema(description = "Nombre del producto", example = "Laptop Dell XPS 15")
    String name,
    
    @Schema(description = "Descripción detallada del producto", example = "Laptop de alta gama con procesador Intel i7")
    String description,
    
    @Schema(description = "Precio del producto", example = "1299.99")
    BigDecimal price,
    
    @Schema(description = "Cantidad en inventario", example = "50")
    Integer stock,
    
    @Schema(description = "Categoría del producto", example = "Electrónica")
    String category,
    
    @Schema(description = "Indica si el producto está activo", example = "true")
    Boolean active,
    
    @Schema(description = "Fecha de creación del registro", example = "2024-01-15T10:30:00")
    LocalDateTime createdAt,
    
    @Schema(description = "Fecha de última modificación", example = "2024-01-20T14:45:00")
    LocalDateTime updatedAt
) {
    public static ProductResponse fromEntity(com.example.productapi.model.Product product) {
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
}

// === ARCHIVO: src/main/java/com/example/productapi/controller/ProductController.java ===
package com.example.productapi.controller;

import com.example.productapi.dto.ProductRequest;
import com.example.productapi.dto.ProductResponse;
import com.example.productapi.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@Tag(name = "Gestión de Productos", description = "Endpoints para CRUD de productos en el catálogo")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @Operation(summary = "Crear un nuevo producto", description = "Registra un nuevo producto en el catálogo")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Producto creado exitosamente"),
        @ApiResponse(responseCode = "400", description = "Datos de entrada inválidos"),
        @ApiResponse(responseCode = "409", description = "El producto ya existe")
    })
    @PostMapping
    public ResponseEntity<ProductResponse> createProduct(@Valid @RequestBody ProductRequest request) {
        ProductResponse created = productService.createProduct(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @Operation(summary = "Obtener todos los productos", description = "Retorna la lista completa de productos")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Lista de productos obtenida exitosamente")
    })
    @GetMapping
    public ResponseEntity<List<ProductResponse>> getAllProducts() {
        List<ProductResponse> products = productService.getAllProducts();
        return ResponseEntity.ok(products);
    }

    @Operation(summary = "Obtener producto por ID", description = "Busca un producto específico por su identificador")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Producto encontrado"),
        @ApiResponse(responseCode = "404", description = "Producto no encontrado")
    })
    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> getProductById(
            @Parameter(description = "ID del producto a buscar", required = true)
            @PathVariable Long id) {
        ProductResponse product = productService.getProductById(id);
        return ResponseEntity.ok(product);
    }

    @Operation(summary = "Actualizar un producto", description = "Modifica los datos de un producto existente")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Producto actualizado exitosamente"),
        @ApiResponse(responseCode = "400", description = "Datos de entrada inválidos"),
        @ApiResponse(responseCode = "404", description = "Producto no encontrado"),
        @ApiResponse(responseCode = "409", description = "Conflicto: nombre duplicado")
    })
    @PutMapping("/{id}")
    public ResponseEntity<ProductResponse> updateProduct(
            @Parameter(description = "ID del producto a actualizar", required = true)
            @PathVariable Long id,
            @Valid @RequestBody ProductRequest request) {
        ProductResponse updated = productService.updateProduct(id, request);
        return ResponseEntity.ok(updated);
    }

    @Operation(summary = "Eliminar un producto", description = "Elimina un producto del catálogo por su ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "204", description = "Producto eliminado exitosamente"),
        @ApiResponse(responseCode = "404", description = "Producto no encontrado")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(
            @Parameter(description = "ID del producto a eliminar", required = true)
            @PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Buscar productos por rango de precio", description = "Filtra productos cuyo precio está entre un mínimo y máximo")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Búsqueda ejecutada correctamente")
    })
    @GetMapping("/search/price-range")
    public ResponseEntity<List<ProductResponse>> findByPriceRange(
            @Parameter(description = "Precio mínimo", required = true)
            @RequestParam("minPrice") BigDecimal minPrice,
            @Parameter(description = "Precio máximo", required = true)
            @RequestParam("maxPrice") BigDecimal maxPrice) {
        List<ProductResponse> products = productService.findByPriceRange(minPrice, maxPrice);
        return ResponseEntity.ok(products);
    }

    @Operation(summary = "Listar productos ordenados por precio", description = "Retorna todos los productos ordenados ascendentemente por precio")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Lista obtenida correctamente")
    })
    @GetMapping("/sorted/by-price")
    public ResponseEntity<List<ProductResponse>> getProductsSortedByPrice() {
        List<ProductResponse> products = productService.getProductsSortedByPrice();
        return ResponseEntity.ok(products);
    }

    @Operation(summary = "Contar productos en stock", description = "Retorna la cantidad de productos con stock disponible")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Conteo ejecutado correctamente")
    })
    @GetMapping("/stats/in-stock")
    public ResponseEntity<Integer> countProductsInStock() {
        int count = productService.countProductsInStock();
        return ResponseEntity.ok(count);
    }
}

// === ARCHIVO: src/main/java/com/example/productapi/service/ProductService.java ===
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
        validarPrecioNoNegativo(request.price());
        validarNombreUnico(request.name(), null);
        validarStockNoNegativo(request.stock());

        Product product = new Product(
            request.name(),
            request.price(),
            request.stock()
        );
        product.setDescription(request.description());
        product.setCategory(request.category());
        product.setActive(request.active() != null ? request.active() : true);
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
    public ProductResponse getProductById(Long id) {
        Product product = productRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Producto no encontrado con ID: " + id));
        return ProductResponse.fromEntity(product);
    }

    public ProductResponse updateProduct(Long id, ProductRequest request) {
        Product existingProduct = productRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Producto no encontrado con ID: " + id));

        validarPrecioNoNegativo(request.price());
        validarNombreUnico(request.name(), id);
        validarStockNoNegativo(request.stock());

        existingProduct.setName(request.name());
        existingProduct.setDescription(request.description());
        existingProduct.setPrice(request.price());
        existingProduct.setStock(request.stock());
        existingProduct.setCategory(request.category());
        existingProduct.setActive(request.active() != null ? request.active() : existingProduct.getActive());
        existingProduct.setUpdatedAt(LocalDateTime.now());

        Product updated = productRepository.save(existingProduct);
        return ProductResponse.fromEntity(updated);
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

// === ARCHIVO: src/main/java/com/example/productapi/exception/ProductAlreadyExistsException.java ===
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
// === ARCHIVO: src/main/java/com/example/productapi/exception/GlobalExceptionHandler.java ===
package com.example.productapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ProductAlreadyExistsException.class)
    public ResponseEntity<ErrorResponse> handleProductAlreadyExistsException(
            ProductAlreadyExistsException ex, WebRequest request) {
        ErrorResponse errorResponse = ErrorResponse.builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.CONFLICT.value())
                .error("Conflicto")
                .message(ex.getMessage())
                .path(request.getDescription(false).replace("uri=", ""))
                .productName(ex.getProductName())
                .build();
        return new ResponseEntity<>(errorResponse, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidationErrorResponse> handleValidationExceptions(
            MethodArgumentNotValidException ex, WebRequest request) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });

        ValidationErrorResponse validationResponse = ValidationErrorResponse.builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.BAD_REQUEST.value())
                .error("Error de Validación")
                .message("Los datos proporcionados no son válidos")
                .path(request.getDescription(false).replace("uri=", ""))
                .validationErrors(errors)
                .build();
        return new ResponseEntity<>(validationResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorResponse> handleIllegalArgumentException(
            IllegalArgumentException ex, WebRequest request) {
        ErrorResponse errorResponse = ErrorResponse.builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.BAD_REQUEST.value())
                .error("Solicitud Incorrecta")
                .message(ex.getMessage())
                .path(request.getDescription(false).replace("uri=", ""))
                .build();
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGlobalException(
            Exception ex, WebRequest request) {
        ErrorResponse errorResponse = ErrorResponse.builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .error("Error Interno del Servidor")
                .message("Ha ocurrido un error inesperado. Por favor, contacte al administrador.")
                .path(request.getDescription(false).replace("uri=", ""))
                .build();
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public static class ErrorResponse {
        private LocalDateTime timestamp;
        private int status;
        private String error;
        private String message;
        private String path;
        private String productName;

        private ErrorResponse() {}

        public static ErrorResponseBuilder builder() {
            return new ErrorResponseBuilder();
        }

        public LocalDateTime getTimestamp() { return timestamp; }
        public int getStatus() { return status; }
        public String getError() { return error; }
        public String getMessage() { return message; }
        public String getPath() { return path; }
        public String getProductName() { return productName; }

        public static class ErrorResponseBuilder {
            private LocalDateTime timestamp;
            private int status;
            private String error;
            private String message;
            private String path;
            private String productName;

            public ErrorResponseBuilder timestamp(LocalDateTime timestamp) {
                this.timestamp = timestamp;
                return this;
            }

            public ErrorResponseBuilder status(int status) {
                this.status = status;
                return this;
            }

            public ErrorResponseBuilder error(String error) {
                this.error = error;
                return this;
            }

            public ErrorResponseBuilder message(String message) {
                this.message = message;
                return this;
            }

            public ErrorResponseBuilder path(String path) {
                this.path = path;
                return this;
            }

            public ErrorResponseBuilder productName(String productName) {
                this.productName = productName;
                return this;
            }

            public ErrorResponse build() {
                ErrorResponse response = new ErrorResponse();
                response.timestamp = this.timestamp;
                response.status = this.status;
                response.error = this.error;
                response.message = this.message;
                response.path = this.path;
                response.productName = this.productName;
                return response;
            }
        }
    }

    public static class ValidationErrorResponse {
        private LocalDateTime timestamp;
        private int status;
        private String error;
        private String message;
        private String path;
        private Map<String, String> validationErrors;

        private ValidationErrorResponse() {}

        public static ValidationErrorResponseBuilder builder() {
            return new ValidationErrorResponseBuilder();
        }

        public LocalDateTime getTimestamp() { return timestamp; }
        public int getStatus() { return status; }
        public String getError() { return error; }
        public String getMessage() { return message; }
        public String getPath() { return path; }
        public Map<String, String> getValidationErrors() { return validationErrors; }

        public static class ValidationErrorResponseBuilder {
            private LocalDateTime timestamp;
            private int status;
            private String error;
            private String message;
            private String path;
            private Map<String, String> validationErrors;

            public ValidationErrorResponseBuilder timestamp(LocalDateTime timestamp) {
                this.timestamp = timestamp;
                return this;
            }

            public ValidationErrorResponseBuilder status(int status) {
                this.status = status;
                return this;
            }

            public ValidationErrorResponseBuilder error(String error) {
                this.error = error;
                return this;
            }

            public ValidationErrorResponseBuilder message(String message) {
                this.message = message;
                return this;
            }

            public ValidationErrorResponseBuilder path(String path) {
                this.path = path;
                return this;
            }

            public ValidationErrorResponseBuilder validationErrors(Map<String, String> validationErrors) {
                this.validationErrors = validationErrors;
                return this;
            }

            public ValidationErrorResponse build() {
                ValidationErrorResponse response = new ValidationErrorResponse();
                response.timestamp = this.timestamp;
                response.status = this.status;
                response.error = this.error;
                response.message = this.message;
                response.path = this.path;
                response.validationErrors = this.validationErrors;
                return response;
            }
        }
    }
}
// === ARCHIVO: src/main/java/com/example/productapi/config/OpenApiConfig.java ===
package com.example.productapi.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API de Gestión de Productos")
                        .description(""
                                + "API REST para la gestión completa de productos en un catálogo. "
                                + "Permite realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar) "
                                + "sobre los productos del sistema.\n\n"
                                + "### Características principales:\n"
                                + "- Gestión de productos con nombre, descripción, precio y stock\n"
                                + "- Validación de datos para asegurar integridad\n"
                                + "- Prevención de productos con nombres duplicados\n"
                                + "- Búsqueda por rango de precios y disponibilidad de stock\n"
                                + "- Documentación interactiva con Swagger UI\n\n"
                                + "### Códigos de respuesta:\n"
                                + "- 200: Operación exitosa\n"
                                + "- 201: Recurso creado exitosamente\n"
                                + "- 400: Error de validación o solicitud incorrecta\n"
                                + "- 404: Recurso no encontrado\n"
                                + "- 409: Conflicto (producto duplicado)\n"
                                + "- 500: Error interno del servidor")
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("Equipo de Desarrollo")
                                .email("dev@empresa.com")
                                .url("https://empresa.com"))
                        .license(new License()
                                .name("Licencia MIT")
                                .url("https://opensource.org/licenses/MIT")))
                .addSecurityItem(new SecurityRequirement().addList("bearerAuth"))
                .components(new Components()
                        .addSecuritySchemes("bearerAuth", new SecurityScheme()
                                .type(SecurityScheme.Type.HTTP)
                                .scheme("bearer")
                                .bearerFormat("JWT")
                                .description(""
                                        + "Autenticación mediante token JWT. "
                                        + "Para obtener un token, use el endpoint de autenticación.\n\n"
                                        + "Ejemplo de uso en Swagger:\n"
                                        + "1. Haga clic en el botón 'Authorize'\n"
                                        + "2. Ingrese el token en el formato: Bearer <token>\n"
                                        + "3. Click en 'Authorize' y luego en 'Close'\n"
                                        + "4. Ahora las solicitudes protegidas incluirán el token")));
    }
}

// === ARCHIVO: src/test/java/com/example/productapi/controller/ProductControllerTest.java ===
package com.example.productapi.controller;

import com.example.productapi.dto.ProductRequest;
import com.example.productapi.dto.ProductResponse;
import com.example.productapi.exception.ProductAlreadyExistsException;
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

// === ARCHIVO: src/test/java/com/example/productapi/service/ProductServiceTest.java ===
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
        when(productRepository.findByPriceGreaterThanEqual(new BigDecimal("1000"))).thenReturn(products);

        List<ProductResponse> result = productService.findByPriceGreaterThanEqual(new BigDecimal("1000"));

        assertNotNull(result);
        assertEquals(1, result.size());
        verify(productRepository, times(1)).findByPriceGreaterThanEqual(new BigDecimal("1000"));
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

// === ARCHIVO: src/main/java/com/example/productapi/dto/ProductResponse.java ===
package com.example.productapi.dto;

import com.example.productapi.model.Product;
import io.swagger.v3.oas.annotations.media.Schema;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Schema(description = "Respuesta de producto en el catálogo")
public record ProductResponse(
    @Schema(description = "Identificador único del producto", example = "1")
    Long id,
    
    @Schema(description = "Nombre del producto", example = "Laptop Dell XPS 15")
    String name,
    
    @Schema(description = "Descripción detallada del producto", example = "Laptop de alta gama con procesador Intel i7")
    String description,
    
    @Schema(description = "Precio del producto", example = "1299.99")
    BigDecimal price,
    
    @Schema(description = "Cantidad en inventario", example = "50")
    Integer stock,
    
    @Schema(description = "Categoría del producto", example = "Electrónica")
    String category,
    
    @Schema(description = "Indica si el producto está activo", example = "true")
    Boolean active,
    
    @Schema(description = "Fecha de creación del registro", example = "2024-01-15T10:30:00")
    LocalDateTime createdAt,
    
    @Schema(description = "Fecha de última modificación", example = "2024-01-20T14:45:00")
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
}

// === ARCHIVO: src/main/java/com/example/productapi/controller/ProductController.java ===
package com.example.productapi.controller;

import com.example.productapi.dto.ProductRequest;
import com.example.productapi.dto.ProductResponse;
import com.example.productapi.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@Tag(name = "Gestión de Productos", description = "Endpoints para CRUD de productos en el catálogo")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @Operation(summary = "Crear un nuevo producto", description = "Registra un nuevo producto en el catálogo")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Producto creado exitosamente"),
        @ApiResponse(responseCode = "400", description = "Datos de entrada inválidos"),
        @ApiResponse(responseCode = "409", description = "El producto ya existe")
    })
    @PostMapping
    public ResponseEntity<ProductResponse> createProduct(@Valid @RequestBody ProductRequest request) {
        ProductResponse created = productService.createProduct(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @Operation(summary = "Obtener todos los productos", description = "Retorna la lista completa de productos")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Lista de productos obtenida exitosamente")
    })
    @GetMapping
    public ResponseEntity<List<ProductResponse>> getAllProducts() {
        List<ProductResponse> products = productService.getAllProducts();
        return ResponseEntity.ok(products);
    }

    @Operation(summary = "Obtener producto por ID", description = "Busca un producto específico por su identificador")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Producto encontrado"),
        @ApiResponse(responseCode = "404", description = "Producto no encontrado")
    })
    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> getProductById(
            @Parameter(description = "ID del producto a buscar", required = true)
            @PathVariable Long id) {
        ProductResponse product = productService.getProductById(id);
        return ResponseEntity.ok(product);
    }

    @Operation(summary = "Actualizar un producto", description = "Modifica los datos de un producto existente")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Producto actualizado exitosamente"),
        @ApiResponse(responseCode = "400", description = "Datos de entrada inválidos"),
        @ApiResponse(responseCode = "404", description = "Producto no encontrado"),
        @ApiResponse(responseCode = "409", description = "Conflicto: nombre duplicado")
    })
    @PutMapping("/{id}")
    public ResponseEntity<ProductResponse> updateProduct(
            @Parameter(description = "ID del producto a actualizar", required = true)
            @PathVariable Long id,
            @Valid @RequestBody ProductRequest request) {
        ProductResponse updated = productService.updateProduct(id, request);
        return ResponseEntity.ok(updated);
    }

    @Operation(summary = "Eliminar un producto", description = "Elimina un producto del catálogo por su ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "204", description = "Producto eliminado exitosamente"),
        @ApiResponse(responseCode = "404", description = "Producto no encontrado")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(
            @Parameter(description = "ID del producto a eliminar", required = true)
            @PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Buscar productos por rango de precio", description = "Filtra productos cuyo precio está entre un mínimo y máximo")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Búsqueda ejecutada correctamente")
    })
    @GetMapping("/search/price-range")
    public ResponseEntity<List<ProductResponse>> findByPriceRange(
            @Parameter(description = "Precio mínimo", required = true)
            @RequestParam("minPrice") BigDecimal minPrice,
            @Parameter(description = "Precio máximo", required = true)
            @RequestParam("maxPrice") BigDecimal maxPrice) {
        List<ProductResponse> products = productService.findByPriceRange(minPrice, maxPrice);
        return ResponseEntity.ok(products);
    }

    @Operation(summary = "Listar productos ordenados por precio", description = "Retorna todos los productos ordenados ascendentemente por precio")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Lista obtenida correctamente")
    })
    @GetMapping("/sorted/by-price")
    public ResponseEntity<List<ProductResponse>> getProductsSortedByPrice() {
        List<ProductResponse> products = productService.getProductsSortedByPrice();
        return ResponseEntity.ok(products);
    }

    @Operation(summary = "Contar productos en stock", description = "Retorna la cantidad de productos con stock disponible")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Conteo ejecutado correctamente")
    })
    @GetMapping("/stats/in-stock")
    public ResponseEntity<Integer> countProductsInStock() {
        int count = productService.countProductsInStock();
        return ResponseEntity.ok(count);
    }
}

// === ARCHIVO: src/test/java/com/example/productapi/controller/ProductControllerTest.java ===
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


// === ARCHIVO: src/main/java/com/example/productapi/model/Product.java ===
package com.example.productapi.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Product {
    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private Integer stock;
    private String category;
    private Boolean active;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Product(String name, BigDecimal price, Integer stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.active = true;
    }

    public void reduceStock(Integer quantity) {
        if (this.stock >= quantity) {
            this.stock -= quantity;
        }
    }

    public void increaseStock(Integer quantity) {
        this.stock += quantity;
    }

    public void deactivate() {
        this.active = false;
    }

    public void activate() {
        this.active = true;
    }

    public boolean isInStock() {
        return this.stock != null && this.stock > 0;
    }

    // Getters
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Integer getStock() {
        return stock;
    }

    public String getCategory() {
        return category;
    }

    public Boolean getActive() {
        return active;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}

// === ARCHIVO: src/main/java/com/example/productapi/dto/ProductResponse.java ===
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

// === ARCHIVO: src/main/java/com/example/productapi/dto/ProductRequest.java ===
package com.example.productapi.dto;

import java.math.BigDecimal;

public class ProductRequest {
    private String name;
    private String description;
    private BigDecimal price;
    private Integer stock;
    private String category;
    private Boolean active;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}

// === ARCHIVO: src/main/java/com/example/productapi/service/ProductService.java ===
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

// === ARCHIVO: src/test/java/com/example/productapi/service/ProductServiceTest.java ===
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

```
