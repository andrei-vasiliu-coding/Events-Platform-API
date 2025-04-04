# 🎉 Java Events Platform API

A backend RESTful API for managing events, locations, organisers, and user registrations for an events platform. Built with Java 21, Spring Boot 3, JPA, and H2/PostgreSQL.

---
Link to the front-end repository: [Java Events Platform UI]https://github.com/andrei-vasiliu-coding/Events-Platform-Android-UI/tree/firebase
---
## 🚀 Features

- CRUD operations for Events, Organisers, Locations, and Event Registrations (only on branch, still in development)
- Search and filter events by title, date, location, organiser, and more
- Data validation using annotations (`@NotNull`, `@Size`, etc.)
- OpenAPI/Swagger integration for easy API documentation
- Composite key handling (EventRegistration; still in development)
- Supports **H2 (in-memory)**;**PostgreSQL** database implementation planned in the future weeks
- Role-based access setup ready via Spring Security

---

## 🛠️ Technologies

- Java 21
- Spring Boot 3.x
- Spring Data JPA
- H2 / PostgreSQL
- Lombok
- Swagger (springdoc-openapi)
- Maven

---

## 📦 Getting Started

### ✅ Prerequisites

Make sure you have the following installed:

- [Java 21+](https://jdk.java.net/21/)
- [Maven](https://maven.apache.org/install.html)
- [Git](https://git-scm.com/)
- (Optional) [PostgreSQL](https://www.postgresql.org/download/) if using production DB

---

## 🧪 Running the App Locally (H2 In-Memory Database)

1. **Clone the repository**
   ```bash
   git clone https://github.com/andrei-vasiliu-coding/Events-Platform-API.git
   cd Events-Platform-API
   ```

2. **Open the project in IntelliJ or any IDE**

3. **Ensure the `application.properties` looks like this**:
   ```properties
   spring.application.name=Java_Events_Platform
   spring.profiles.active=dev

   # Swagger
   springdoc.api-docs.path=/api-docs
   springdoc.swagger-ui.path=/swagger-ui.html

   # Enable H2 console
   spring.h2.console.enabled=true
   spring.h2.console.path=/h2-console
   ```

4. **Check `src/main/resources/application-dev.properties`**:
   ```properties
   spring.datasource.url=jdbc:h2:mem:Java_Events_Platform_db
   spring.datasource.driverClassName=org.h2.Driver
   spring.datasource.username=sa
   spring.datasource.password=

   spring.jpa.hibernate.ddl-auto=create-drop
   spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
   spring.jpa.show-sql=true
   spring.jpa.properties.hibernate.format_sql=true
   ```

5. **Run the project**
   - In IntelliJ, run `JavaEventsPlatformApplication.java`
   - Or use:
     ```bash
     mvn spring-boot:run
     ```

6. **Visit Swagger UI**
   - [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)
---

7. **Future improvements**
   - Deploy the API into a cloud service. Current H2 in-memory database is limited as the data is deleted once the API is terminated.
   - Fix Swagger UI.
   - Implement PostgreSQL.
   - Finish implementing a table linking user IDs to event registration IDs.

## 🛢️ Switching to PostgreSQL (Not currently available; planned implementation in the next weeks)

1. Create a PostgreSQL database:
   ```sql
   CREATE DATABASE events_platform_db;
   ```

2. Add this to `application-prod.properties`:
   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/events_platform_db
   spring.datasource.username=your_db_username
   spring.datasource.password=your_db_password
   spring.jpa.hibernate.ddl-auto=update
   spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect
   ```

3. Switch profile in `application.properties`:
   ```properties
   spring.profiles.active=prod
   ```

---

## 🔐 API Authentication (Optional Setup)

This project includes Spring Security and OAuth2 starter.  
You can configure authentication if needed by adding a security config in:
```
com.jveventsplatform.Java_Events_Platform.config.SecurityConfig
```

---

## 🧪 Testing the API

Use tools like [Postman](https://www.postman.com/) or Swagger UI to test the endpoints.

- `GET /api/v1/events` – fetch all events
- `POST /api/v1/event` – create a new event
- `GET /api/v1/events/title?title=Yoga` – search by title
- `DELETE /api/v1/event?id=3` – delete by ID

---

## 📂 Project Structure

```
src/
├── controller/        # REST controllers
├── model/             # JPA entities & enums
├── repository/        # JPA repositories
├── service/           # Business logic
├── exception/         # Custom exceptions & global handler
├── config/            # Security / Swagger config (optional)
└── resources/
    ├── application.properties
    ├── application-dev.properties
    └── application-prod.properties (for PostgreSQL in the future)
```

---

## 📄 License

This project is for educational/demo purposes only.

---

## 👨‍💻 Author

Developed by **Andrei Vasiliu**  
GitHub: [@andrei-vasiliu-coding](https://github.com/andrei-vasiliu-coding)

---

