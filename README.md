# 🚀 CRM de Ventas - MCR-VENTAS

![Java](https://img.shields.io/badge/Java-17-orange?style=flat&logo=java)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.1-green?style=flat&logo=spring)
![MySQL](https://img.shields.io/badge/MySQL-8.0-blue?style=flat&logo=mysql)

Un sistema CRM para gestión de ventas desarrollado con Java Spring Boot.  
Permite administrar productos, clientes y transacciones comerciales con autenticación personalizada.

---

## ✨ Características principales

- 🔐 Autenticación personalizada (sin Spring Security)
- 📊 Dashboard con datos clave
- 🔄 CRUD completo para:
  - 📦 Productos
  - 👥 Usuarios
  - 💰 Ventas
- 🔗 Relaciones entre entidades
- 🧠 API REST lista para integraciones
- 🎨 Interfaz web con HTML/CSS/JS y Thymeleaf

---

## 🛠️ Tecnologías utilizadas

| Categoría       | Tecnologías                                                                 |
|-----------------|------------------------------------------------------------------------------|
| Backend         | Java 17, Spring Boot 3.1, Spring Data JPA, Hibernate                        |
| Base de Datos   | MySQL 8.0                                                                    |
| Frontend        | HTML5, CSS3, JavaScript Vanilla, Thymeleaf                                  |
| Herramientas    | Maven, Git, GitHub                                                           |
| Entorno Dev     | IntelliJ IDEA, VS Code                                                       |

---

## 📦 Requisitos previos

- Java JDK 17+
- MySQL 8.0+
- Maven 3.8+
- Navegador moderno

---

## 🚀 Instalación y configuración

### 1. Clonar el repositorio

```bash
git clone https://github.com/jahirtheprogramer/MCR-VENTAS.git
cd MCR-VENTAS
2. Crear la base de datos MySQL
sql
Copiar
Editar
CREATE DATABASE proyecto_crm CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
3. Importar la estructura y datos
bash
Copiar
Editar
mysql -u tu_usuario -p proyecto_crm < db/crm_ventas.sql
4. Configurar la aplicación
Copia el archivo de ejemplo:

bash
Copiar
Editar
cp src/main/resources/application-example.properties src/main/resources/application.properties
Edita el archivo application.properties:

properties
Copiar
Editar
spring.datasource.url=jdbc:mysql://localhost:3306/proyecto_crm?useSSL=false
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña
5. Ejecutar la aplicación
Opción 1: Con Maven

bash
Copiar
Editar
./mvnw spring-boot:run
Opción 2: Desde tu IDE favorito (IntelliJ, VS Code, etc.)

🌐 Acceso a la aplicación
Una vez iniciada, abre tu navegador:

arduino
Copiar
Editar
http://localhost:8080
Credenciales de prueba:

Usuario: admin@example.com

Contraseña: Admin123

📂 Estructura del proyecto
plaintext
Copiar
Editar
MCR-VENTAS/
├── db/                     # Scripts de base de datos
├── src/
│   ├── main/
│   │   ├── java/com/crm/   # Código fuente Java
│   │   │   ├── config/         # Configuraciones
│   │   │   ├── controllers/
│   │   │   ├── models/         # Entidades
│   │   │   ├── repositories/
│   │   │   ├── services/
│   │   │   └── utils/          # Utilidades
│   │   └── resources/
│   │       ├── static/         # JS, CSS, imágenes
│   │       ├── templates/      # Vistas Thymeleaf
│   │       └── application.properties
├── pom.xml               # Configuración Maven
└── README.md             # Este archivo
📡 Endpoints API REST
Método	Endpoint	Descripción
GET	/api/productos	Listar todos los productos
POST	/api/productos	Crear nuevo producto
GET	/api/productos/{id}	Obtener producto por ID
PUT	/api/productos/{id}	Actualizar producto
DELETE	/api/productos/{id}	Eliminar producto

🔁 Estructura similar para /api/usuarios y /api/ventas

🤝 Contribuciones
¡Las contribuciones son bienvenidas!
Para colaborar:

Haz fork al proyecto

Crea una rama:

bash
Copiar
Editar
git checkout -b feature/nueva-funcionalidad
Realiza tus cambios:

bash
Copiar
Editar
git commit -m "Agrega nueva funcionalidad"
Haz push a tu rama:

bash
Copiar
Editar
git push origin feature/nueva-funcionalidad
Abre un Pull Request

✉️ Contacto
Jahir Vera
📧 kevinnveralopez@gmail.com
🌐 github.com/jahirtheprogramer

⭐ ¡Dale una estrella!
Si este proyecto te resultó útil, considera darle ⭐ en GitHub.
¡Gracias por tu apoyo!
