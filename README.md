# Desarrollo de una API REST con persistencia en H2 y documentación con Swagger

El sistema debe soportar la creación, lectura, actualización y eliminación de registros de productos en un catálogo. Los productos tienen un nombre, precio y stock. El sistema debe asegurar que no haya productos con nombres duplicados y que los precios no sean negativos. La persistencia se realizará en una base de datos H2 y la documentación se generará con Swagger. El sistema debe manejar correctamente los errores de validación y proporcionar una respuesta adecuada al cliente.

## Informacion General

| Campo | Valor |
|-------|-------|
| **Tema** | Java Spring Boot |
| **Nivel** | junior-l1 |
| **Tipo** | practical |
| **Tiempo estimado** | 8 horas |

## Fases del Reto

### Fase 0: Configuración del Proyecto

**Objetivo:** Obtener el proyecto base funcional enviando el Código Base a un asistente de IA, que lo analizará, corregirá errores y generará un ZIP listo para usar.

**Tiempo estimado:** 15-30 minutos

**Instrucciones:**

- Asegúrate de tener instalado para ejecutar el proyecto: JDK 17+, Maven 3.9+, IDE con soporte Java.
- Copia todo el contenido del campo **Código Base** de este reto — incluyendo el texto de instrucciones que aparece al inicio.
- Abre un asistente de IA (Claude en claude.ai, ChatGPT o Gemini — se recomienda Claude), pega el contenido copiado en el chat y envíalo.
- El asistente analizará los archivos, corregirá errores y generará un archivo ZIP descargable. Descárgalo y extráelo en la carpeta donde quieras trabajar.
- Ejecuta `mvn compile` en la raíz. Si no hay errores, estás listo.

**Entregable:** El proyecto compila/arranca sin errores.

<details>
<summary>Pistas de conocimiento</summary>

- Copia el Código Base completo incluyendo el texto de instrucciones al inicio — esas instrucciones le indican al asistente exactamente qué hacer con los archivos.
- Si el asistente no genera el ZIP automáticamente al terminar el análisis, escríbele: "genera el ZIP ahora".
- Si el proyecto tiene errores al arrancar, comparte el mensaje de error con el mismo asistente para que lo corrija.

</details>

### Fase 1: Configuración del entorno y creación de la estructura básica

**Objetivo:** Configurar el entorno de desarrollo y crear la estructura básica de la API REST.

**Tiempo estimado:** 2 horas

**Instrucciones:**

- Configurar el proyecto para utilizar Spring Boot y H2.
- Definir el modelo de datos para el producto.
- Crear el repositorio para la persistencia de datos.
- Implementar los endpoints básicos para la gestión de productos.

**Entregable:** Proyecto Spring Boot con estructura básica y endpoints para CRUD de productos.

<details>
<summary>Pistas de conocimiento</summary>

- Considera la estructura de un proyecto Spring Boot y cómo definir modelos de datos.
- Piensa en cómo configurar H2 para persistencia en memoria.

</details>

### Fase 2: Implementación de la lógica de negocio y validaciones

**Objetivo:** Implementar la lógica de negocio y las validaciones necesarias para asegurar la integridad de los datos.

**Tiempo estimado:** 3 horas

**Instrucciones:**

- Agregar validaciones para asegurar que los nombres de los productos sean únicos y que los precios no sean negativos.
- Manejar los errores de validación y proporcionar respuestas adecuadas al cliente.

**Entregable:** API REST con validaciones implementadas y manejo de errores.

<details>
<summary>Pistas de conocimiento</summary>

- Considera cómo implementar validaciones en Spring Boot.
- Piensa en cómo manejar y responder a los errores de validación.

</details>

### Fase 3: Generación de documentación con Swagger

**Objetivo:** Generar documentación para la API utilizando Swagger.

**Tiempo estimado:** 3 horas

**Instrucciones:**

- Configurar Swagger para generar documentación automática de la API.
- Asegurar que la documentación incluya todos los endpoints y sus respectivas descripciones.

**Entregable:** API REST con documentación generada por Swagger.

<details>
<summary>Pistas de conocimiento</summary>

- Considera cómo integrar Swagger en un proyecto Spring Boot.
- Piensa en cómo asegurar que la documentación sea completa y clara.

</details>

## Dimensiones Evaluadas

- **queEs**: ¿Qué es Spring Boot y para qué se utiliza en este reto?
- **paraQueSirve**: ¿Para qué sirve la documentación generada por Swagger en este contexto?
- **comoSeUsa**: ¿Cómo se implementan las validaciones en este reto?
- **erroresComunes**: ¿Qué errores comunes pueden ocurrir al implementar las validaciones y cómo se manejan?

## Criterios de Evaluacion

- Configuración correcta del entorno de desarrollo con Spring Boot y H2.
- Implementación de la estructura básica de la API REST con endpoints para CRUD de productos.
- Aplicación de validaciones para asegurar la integridad de los datos.
- Manejo adecuado de los errores de validación y respuestas al cliente.
- Generación de documentación completa y clara con Swagger.

## Como trabajar con un asistente de IA

Hay dos caminos, elegi uno:

- **AGENTS.md** (recomendado) — instrucciones nativas del repo. Abri esta carpeta con tu agente local (Claude Code, Cursor, Codex, Copilot, Gemini) y las carga solo. Sabe que archivos faltan y con que comando se verifica, y completa el scaffold escribiendo en disco.
- **PROMPT_MEJORA.md** — para copiar y pegar en un chat (claude.ai, ChatGPT). Devuelve un ZIP con el proyecto. Sirve si no tenes un agente en el IDE.

Ninguno de los dos resuelve las fases del reto: eso es tu trabajo.

## Verificacion

El proyecto esta listo para trabajar cuando este comando corre sin errores:

```bash
el comando de build o arranque canonico del stack elegido
```

---

*Reto generado automaticamente por Challenge Generator - Pragma*
