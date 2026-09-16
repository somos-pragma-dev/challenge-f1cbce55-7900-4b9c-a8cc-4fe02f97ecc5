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