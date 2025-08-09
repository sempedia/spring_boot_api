# Java Spring Boot API 🚀

This is a RESTful API built with **Spring Boot** to manage **customer, order, and product** related data. The application uses **Java 17**, **Spring Data JPA**, and **Hibernate** with a **MySQL** database.

---

## 💻 Tech Stack

* **Java 17**: The primary programming language.
* **Spring Boot**: The framework used to build the API.
* **Spring Data JPA**: Simplifies data access and persistence layers.
* **Hibernate**: The Object-Relational Mapping (ORM) tool.
* **MySQL**: The relational database management system.
* **Maven**: The project build automation tool.

---

## ⚙️ Configuration

The application is configured using `application.properties`. Below are the key properties:

| Property                      | Description                                                                                                                              |
| :---------------------------- | :--------------------------------------------------------------------------------------------------------------------------------------- |
| `spring.application.name`     | The name of the application.                                                                                                             |
| `server.port`                 | The port on which the application runs.                                                                                                  |
| `spring.datasource.url`       | The JDBC URL for the MySQL database.                                                                                                     |
| `spring.datasource.username`  | The database username.                                                                                                                   |
| `spring.datasource.password`  | The database password.                                                                                                                   |
| `spring.jpa.hibernate.ddl-auto` | Specifies the action to be performed on the database schema. Set to `update` to automatically update the schema based on your entities. |
| `spring.jpa.show-sql`         | A boolean flag to show SQL statements in the console.                                                                                    |

---

## ▶️ Getting Started

### Prerequisites

* **Java 17 SDK**: Make sure you have it installed.
* **Maven**: The project build automation tool.
* **MySQL Server**: A running instance of MySQL.

### Setup

1.  **Clone the repository**:
    ```bash
    git clone git@github.com:sempedia/spring_boot_api.git
    cd spring_boot_api
    ```

2.  **Database Setup**:
    * Create a database named **`trendyol`** in your MySQL instance.
    * Update the `spring.datasource.username` and `spring.datasource.password` in the `src/main/resources/application.properties` file with your MySQL credentials.

3.  **Build and Run**:
    * You can build and run the application using Maven:
        ```bash
        mvn spring-boot:run
        ```
    * Alternatively, you can run the main class `YourApplication.java` from your IDE.

---

## 📂 Project Structure

The application follows a standard layered architecture, separating concerns into distinct packages:

* `src/main/java/com/example/yourapplicationname/` (Replace `yourapplicationname` with your actual base package):
    * **`controller`**: Contains REST controllers that handle incoming HTTP requests and return responses.
    * **`entity`**: Defines the JPA entities that map to database tables (e.g., `Customer`, `Order`, `Product`).
    * **`repository`**: Provides interfaces for data access operations, extending `JpaRepository` for CRUD functionalities.
    * **`service`**: Implements the business logic of the application, orchestrating calls to repositories and handling data transformations.

---

## 📖 API Endpoints

This section would detail the available API endpoints for Customer, Order, and Product management. For example:

* **`GET /api/customers`**: Retrieves a list of all customers.
* **`POST /api/customers`**: Creates a new customer.
* **`GET /api/customers/{id}`**: Retrieves a specific customer by ID.
* **`GET /api/orders`**: Retrieves a list of all orders.
* **`POST /api/orders`**: Creates a new order.
* **`GET /api/products`**: Retrieves a list of all products.
* **`PUT /api/products/{id}`**: Updates an existing product.

---

## 🤝 Contribution

Author: Alina Bazavan ([@sempedia](https://github.com/sempedia))

Feel free to open issues or submit pull requests.

---

## 📄 License

This project is open source and available under the **MIT License**.