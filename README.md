# TinySpringBootDemo

TinySpringBootDemo is a simple backend system built with Spring Boot, designed to demonstrate basic features like user management, authentication, and file uploads. The project is structured for easy scalability and maintainability.

---

## Features

### User Management
- **User Registration:** Create new user accounts with a username and password.
- **User Login:** Authenticate users and provide a JWT token for session management.
- **View User Information:** Retrieve details of the logged-in user.
- **Update User Information:** Modify user profile details.
- **Update Password:** Change user passwords securely.

### File Management
- **File Upload (To Be Implemented):** Handle file uploads through the `FileUploadController`.

### Logging
- **Operation Logs:** Logs user activities such as method calls, parameters, and execution times.

---

## Endpoints

### User Registration
- **Endpoint:** `POST /user/register`
- **Request Parameters:**
  - `username` (String): The username of the new user.
  - `password` (String): The password for the new user.
- **Response:**
  - `200 OK` if the registration is successful.
  - `400 BAD REQUEST` if the username already exists.

### User Login
- **Endpoint:** `POST /user/login`
- **Request Parameters:**
  - `username` (String): The username of the user.
  - `password` (String): The password for the user.
- **Response:**
  - `200 OK` with a JWT token if the login is successful.
  - `400 BAD REQUEST` if the user does not exist or the password is incorrect.

### View User Information
- **Endpoint:** `GET /user/userInfo`
- **Headers:**
  - `Authorization`: The JWT token of the logged-in user.
- **Response:**
  - `200 OK` with the user's information.

### Update User Information
- **Endpoint:** `PUT /user/update`
- **Request Body:** JSON representation of the `User` object.
- **Response:**
  - `200 OK` if the update is successful.

### Update Password
- **Endpoint:** `PATCH /user/updatePwd`
- **Headers:**
  - `Authorization`: The JWT token of the logged-in user.
- **Request Body:**
  - `old_pwd` (String): The old password.
  - `new_pwd` (String): The new password.
  - `re_pwd` (String): Confirmation of the new password.
- **Response:**
  - `200 OK` if the password is updated successfully.
  - `400 BAD REQUEST` if the old password is incorrect or the new passwords do not match.

---

## Project Structure

The main package structure of the project is as follows:

```plaintext
src
└── main
    └── java
        └── com.eureka.tiny
            ├── config                # Configuration files (e.g., WebConfig)
            ├── controller            # RESTful API controllers
            │   ├── FileUploadController
            │   └── UserController
            ├── exception             # Global exception handler
            │   └── GlobalExceptionHandler
            ├── interceptor           # Interceptors for request handling
            │   └── LoginInterceptor
            ├── mapper                # MyBatis mapper interfaces
            │   └── UserMapper
            ├── pojo                  # POJOs for User and OperateLog
            │   ├── User
            │   └── OperateLog
            ├── service               # Service interfaces and implementations
            │   ├── UserService
            │   └── Impl
            │       └── UserServiceImpl
            ├── utils                 # Utility classes
            │   ├── JwtUtil
            │   └── ThreadLocalUtil
            └── TinyApplication       # Main application entry point
```

---

## Technologies Used

- **Spring Boot:** Framework for building the application.
- **MyBatis:** ORM tool for database interactions.
- **Redis:** For token storage and session management.
- **JWT (JSON Web Tokens):** For user authentication and authorization.

---

## Getting Started

### Prerequisites
- Java 17 or above
- Redis installed and running
- MySQL configured for database operations

### Installation
1. Clone the repository:
   ```bash
   git clone https://github.com/linkaitai/TinySpringBootDemo.git
   cd TinySpringBootDemo
   ```

2. Configure the database and Redis settings in the `application.properties` file.

3. Build and run the project:
   ```bash
   ./mvnw spring-boot:run
   ```

4. Access the application via `http://localhost:8080`.

---

## Notes

- Ensure Redis is running before starting the application.
- The `OperateLog` feature tracks user operations, providing insights into API usage and performance.
- File upload functionality is currently a placeholder and needs further implementation.

---

## Future Enhancements

- Implement file upload functionality.
- Add unit and integration tests.
- Extend logging features to include detailed error tracking.

---

## License
This project is licensed under the MIT License. See the LICENSE file for details.

