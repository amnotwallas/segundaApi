
# 🧪 SegundaApi – API REST Educativa con Java y Spring Boot

![Estado](https://img.shields.io/badge/Estado-En%20desarrollo-blue)
![Versión](https://img.shields.io/badge/Versi%C3%B3n-1.0-green)

**SegundaApi** es una API REST simple que permite gestionar usuarios mediante operaciones CRUD. Este proyecto está diseñado con fines educativos y utiliza almacenamiento en memoria, sin persistencia en base de datos.

🎯 **Objetivo**
---------------
- Practicar la construcción de APIs RESTful con Java y Spring Boot.
- Aplicar el patrón de arquitectura por capas: Controller, Service, Repository, Entity.
- Comprender el uso de métodos HTTP (`GET`, `POST`, `PUT`, `DELETE`) en el backend.

---

🛠️ **Tecnologías Utilizadas**
-----------------------------
- Java 17
- Spring Boot
- Maven
- Postman (para pruebas)

---

🗂️ **Estructura del Proyecto**
------------------------------
```
src/main/java/com/notwallas/segundaApi/
├── controller/     # Exposición de endpoints HTTP
├── service/        # Lógica de negocio
├── repository/     # Almacenamiento en memoria o base de datos
├── entity/         # Modelo de datos
└── SegundaApiApplication.java
```

---

🔍 **Definición de Capas**
--------------------------

| Capa         | Descripción                                                                 |
|--------------|-----------------------------------------------------------------------------|
| **Controller** | Gestiona las peticiones HTTP entrantes y retorna respuestas al cliente.   |
| **Service**    | Implementa la lógica de negocio, validaciones y llamadas al repositorio.  |
| **Repository** | Maneja el acceso a los datos; aquí utiliza una lista estática como base de datos. |
| **Entity**     | Representa la estructura de los objetos de dominio (`User`).              |
| **DTO**        | *(No utilizado en este proyecto)*. En general, sirve para transportar datos de forma segura entre el cliente y el backend, evitando exponer directamente las entidades.

---

📌 **Endpoints y Ejemplos de Uso**
----------------------------------

| Método | Endpoint                          | Descripción                            |
|--------|-----------------------------------|----------------------------------------|
| GET    | `/api/users/ping`                 | Verifica que la API esté activa        |
| POST   | `/api/users/create/{...}`         | Crea un nuevo usuario                  |
| GET    | `/api/users/getAll`               | Retorna todos los usuarios registrados |
| GET    | `/api/users/get/{id}`             | Retorna un usuario por ID              |
| PUT    | `/api/users/update/{...}`         | Actualiza todos los campos del usuario |
| DELETE | `/api/users/delete/{id}`          | Elimina un usuario por ID              |

---

🧪 **Pruebas con Postman**
---------------------------

### 🔄 Verificar la API (GET)
```
http://localhost:8080/api/users/ping
```

### ➕ Crear usuario (POST)
```
http://localhost:8080/api/users/create/Juan/25/juan@mail.com/1234/Ingenieria
```

### 📋 Obtener todos los usuarios (GET)
```
http://localhost:8080/api/users/getAll
```

### 🔍 Obtener usuario por ID (GET)
```
http://localhost:8080/api/users/get/1
```

### ✏️ Actualizar usuario (PUT)
```
http://localhost:8080/api/users/update/1/JuanActualizado/30/juan_actualizado@mail.com/claveNueva/Arquitectura
```

### ❌ Eliminar usuario (DELETE)
```
http://localhost:8080/api/users/delete/1
```

---

🧠 **Mejoras Futuras Sugeridas**
---------------------------------
- Implementar DTOs y validaciones con `@NotBlank`, `@Email`, etc.
- Agregar persistencia con base de datos como H2 o PostgreSQL.
- Reemplazar instancias `new` por inyección con `@Autowired`.
- Agregar manejo de errores globales con `@ControllerAdvice`.
- Migrar creación y actualización a `@RequestBody`.

---

👤 **Autor**
------------
- Nombre: Walter AR
- GitHub: [amnotwallas](https://github.com/amnotwallas)
- Proyecto creado como práctica personal para fortalecer conocimientos de Java y Spring Boot.

> ¡Siente la libertad de usar este proyecto como base para tus ideas o proyectos más grandes!
