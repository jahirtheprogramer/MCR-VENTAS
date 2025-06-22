🚀 CRM de Ventas - MCR-VENTAS
https://img.shields.io/badge/Java-17-orange?style=flat&logo=java
https://img.shields.io/badge/Spring_Boot-3.1-green?style=flat&logo=spring
https://img.shields.io/badge/MySQL-8.0-blue?style=flat&logo=mysql
https://img.shields.io/badge/License-MIT-yellow

Un sistema CRM para gestión de ventas desarrollado con Java Spring Boot que permite administrar productos, clientes y transacciones comerciales con autenticación personalizada.

✨ Características principales
Autenticación personalizada sin Spring Security

Dashboard interactivo con datos clave

CRUD completo para:

📦 Productos

👥 Usuarios

💰 Ventas

Relaciones avanzadas entre entidades

Interfaz intuitiva con HTML/CSS/JS

API REST para integraciones futuras

🛠️ Tecnologías utilizadas
Categoría	Tecnologías
Backend	Java 17, Spring Boot 3.1, Spring Data JPA, Hibernate
Base de datos	MySQL 8.0
Frontend	HTML5, CSS3, JavaScript vanilla, Thymeleaf
Herramientas	Maven, Git, GitHub
Desarrollo	IntelliJ IDEA, VS Code
📦 Requisitos previos
Java JDK 17+

MySQL 8.0+

Maven 3.8+

Navegador moderno

🚀 Instalación y configuración
1. Clonar el repositorio
bash
git clone https://github.com/jahirtheprogramer/MCR-VENTAS.git
cd MCR-VENTAS
2. Configurar base de datos
Crear una base de datos MySQL:

sql
CREATE DATABASE proyecto_crm CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
Importar la estructura inicial:

bash
mysql -u usuario -p proyecto_crm < db/crm_ventas.sql
3. Configurar aplicación
Copiar y editar el archivo de propiedades:

bash
cp src/main/resources/application-example.properties src/main/resources/application.properties
Editar application.properties con tus credenciales:

properties
spring.datasource.url=jdbc:mysql://localhost:3306/proyecto_crm?useSSL=false
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña
4. Ejecutar la aplicación
Opción 1: Con Maven:

bash
./mvnw spring-boot:run
Opción 2: Desde tu IDE favorito

🌐 Acceso a la aplicación
Una vez iniciada, accede en tu navegador:

text
http://localhost:8080
Credenciales de prueba:

Usuario: admin@example.com

Contraseña: Admin123

📂 Estructura del proyecto
text
MCR-VENTAS/
├── db/                   # Scripts de base de datos
├── src/
│   ├── main/
│   │   ├── java/com/crm/ # Código fuente Java
│   │   │   ├── config/   # Configuraciones
│   │   │   ├── controllers/
│   │   │   ├── models/   # Entidades
│   │   │   ├── repositories/
│   │   │   ├── services/
│   │   │   └── utils/    # Utilidades
│   │   └── resources/    # Recursos estáticos
│   │       ├── static/   # JS, CSS, imágenes
│   │       ├── templates/ # Vistas Thymeleaf
│   │       └── application.properties
├── pom.xml               # Configuración Maven
└── README.md             # Este archivo
📝 Documentación adicional
Endpoints API REST
Método	Endpoint	Descripción
GET	/api/productos	Listar todos los productos
POST	/api/productos	Crear nuevo producto
GET	/api/productos/{id}	Obtener producto por ID
PUT	/api/productos/{id}	Actualizar producto
DELETE	/api/productos/{id}	Eliminar producto
Similar estructura para usuarios y ventas

🤝 Contribuciones
¡Las contribuciones son bienvenidas! Sigue estos pasos:

Haz fork al proyecto

Crea una rama (git checkout -b feature/nueva-funcionalidad)

Haz commit de tus cambios (git commit -m 'Agrega nueva funcionalidad')

Haz push a la rama (git push origin feature/nueva-funcionalidad)

Abre un Pull Request


✉️ Contacto
Jahir Vera
📧 [kevinnveralopez@gmail.com]
🌐 https://github.com/jahirtheprogramer
