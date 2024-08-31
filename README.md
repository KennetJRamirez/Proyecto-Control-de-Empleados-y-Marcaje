# Proyecto: Parte del Backend para Control de Empleados

Este proyecto es una aplicación para gestionar empleados, sus registros de marcaje y sesiones, así como validar credenciales de acceso. Está desarrollado en Java utilizando el framework Spring Boot.

## Estructura del Proyecto

### 1. **src/controllers**
   Contiene los controladores que manejan las solicitudes HTTP y definen los endpoints de la API.

   - **empleadosController.java**: Gestiona las operaciones relacionadas con los empleados, como crear, actualizar, obtener por ID y validar credenciales.
   - **registrosController.java**: Maneja los registros de marcaje de los empleados, permitiendo registrar entradas y salidas.
   - **sesionesController.java**: Gestiona las sesiones de los empleados, permitiendo registrar el inicio y fin de una sesión.

### 2. **src/models**
   Define los modelos de datos que representan las entidades manejadas por la aplicación.

   - **empleados.java**: Modelo que representa a un empleado, con atributos como ID, nombre, email, contraseña y estado activo.
   - **registros_marcaje.java**: Modelo para los registros de marcaje de un empleado, incluyendo fecha, hora y tipo de marcaje (entrada/salida).
   - **sesiones.java**: Modelo que representa una sesión de trabajo de un empleado, con hora de inicio y fin.
   - **validationRequest.java**: Clase utilizada para validar las credenciales de acceso de un empleado.

### 3. **src/repository**
   Contiene las interfaces que interactúan con la base de datos utilizando Spring Data JPA.

   - **empleadosRepository**: Interfaz para manejar operaciones CRUD relacionadas con la entidad `empleados`.
   - **registrosRepository**: Interfaz para las operaciones relacionadas con los registros de marcaje.
   - **sesionesRepository**: Interfaz para las operaciones relacionadas con las sesiones de trabajo.

### 4. **ControlEmpleadosApplication.java**
   Clase principal que inicializa la aplicación Spring Boot.

## Funcionalidades Principales

- **Gestión de Empleados**: Crear, actualizar, y obtener información de empleados.
- **Validación de Empleados**: Validar las credenciales de un empleado para el inicio de sesión.
- **Registro de Marcajes**: Registrar entradas y salidas de empleados.
- **Gestión de Sesiones**: Registrar el inicio y fin de una sesión de trabajo.

## Endpoints de la API

- **GET /api/empleados**: Obtener todos los empleados.
- **GET /api/empleados/{id}**: Obtener un empleado por ID.
- **POST /api/login**: Validar las credenciales de un empleado.
- **POST /api/empleados**: Crear un nuevo empleado.
- **PUT /api/empleados/{id}**: Actualizar la información de un empleado.
- **PUT /api/empleados/estado/{id}/{estado}**: Actualizar el estado (activo/inactivo) de un empleado.
- **POST /api/registros/{id}/marcaje/{tipo}**: Registrar una entrada o salida para un empleado.
- **POST /api/sesion/inicio/{id}**: Registrar el inicio de una sesión de trabajo.
- **PUT /api/sesion/fin/{id}**: Registrar el fin de una sesión de trabajo.

## Requisitos

- **Java 17**
- **Spring Boot 3**
- **Base de datos compatible con JPA (MySQL en este proyecto)**

## Instrucciones para la Ejecución

1. Clonar el repositorio.
2. Configurar las credenciales de la base de datos en `application.properties`.
3. Ejecutar la aplicación usando `mvn spring-boot:run` o desplegándola en un servidor como lo fue para este primer proyecto del curso.

## Licencia

Este proyecto está licenciado a todo el publico, cualquier aporte o mejora es bienvenido.

