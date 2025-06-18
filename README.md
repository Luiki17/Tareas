# 💻 Plataforma de Retos y Logros

Aplicación web fullstack desarrollada con Java y Spring Boot, que permite gestionar usuarios, retos y logros. Incluye autenticación segura y un diseño responsive gracias a Bootstrap.

## 🧠 Descripción

Esta plataforma permite a los usuarios registrarse, iniciar sesión y participar en una dinámica gamificada donde pueden:
- Crear y editar retos personales.
- Obtener logros.
- Visualizar y gestionar su perfil.

El proyecto está orientado a aprender y aplicar buenas prácticas en desarrollo backend con Spring Boot, trabajando con seguridad, bases de datos relacionales y vistas dinámicas.

## 🛠️ Tecnologías utilizadas

### Backend
- **Java 21**
- **Spring Boot 3**
  - Spring MVC
  - Spring Data JPA
  - Spring Security
- **Hibernate**
- **MySQL** (como base de datos relacional)
- **Lombok** (para reducir código repetitivo)
- **Maven** (gestión de dependencias)

### Frontend
- **Thymeleaf** (motor de plantillas para renderizar las vistas)
- **Bootstrap 5** (para maquetación responsive)
- HTML5 y CSS3

## 🔐 Funcionalidades de seguridad

- Inicio de sesión (login) con validación.
- Cierre de sesión (logout).
- Protección de rutas según autenticación.
- Formularios protegidos contra CSRF.
- Vista personalizada según si el usuario está autenticado o no.
## 📌 Funcionalidades principales

- CRUD de usuarios, retos y logros.
- Gestión desde vistas con formularios y validaciones.
- Seguridad con login/logout.
- Interfaz adaptativa y clara.
- DTOs para transportar datos entre capas de forma limpia.
- Excepciones personalizadas para errores controlados.

## ⚙️ Configuración

### Requisitos previos
- Java 21
- Maven
- MySQL instalado
