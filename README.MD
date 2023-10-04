# Microservicio de Pedidos

Este es un microservicio que gestiona pedidos de productos e interactua con un microservicio externo de productos.

## Requisitos previos

- Java JDK 8 o superior
- Maven
- Base de datos MySQL

## Configuración

1. Clona el repositorio de `microservicio_pedidos`.
2. Crear base de datos MySQL si fuera necesario con las sentencias documentadas en el archivo create.sql
3. Configura la base de datos en el archivo `application.properties`.
4. Ejecuta el comando `mvn clean install` para compilar el proyecto y descargar las dependencias.

## Ejecución

1. Ejecuta el comando `mvn spring-boot:run` para iniciar el microservicio.
2. El microservicio estará disponible en `http://localhost:8080`.

## Endpoints

- `GET /pedidos`: Obtiene la lista de pedidos.
- `POST /pedidos/{codigoProducto}/{unidades}`: Crea un nuevo pedido para el producto especificado.



