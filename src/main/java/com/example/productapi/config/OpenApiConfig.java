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