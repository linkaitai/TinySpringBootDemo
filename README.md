

---

# TinySpringBootDemo

This project is a simple backend system built with Spring Boot, which implements the following features:

- User registration
- User login
- Viewing user information
- Updating user information
- File upload functionality

## Project Structure

The main package structure of the project is as follows:

```
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
            ├── pojo                  # POJOs for User and Result
            │   ├── User
            │   └── Result
            ├── service               # Service interfaces and implementations
            │   ├── UserService
            │   └── Impl
            │       └── UserServiceImpl
            ├── utils                 # Utility classes
            │   ├── JwtUtil
            │   └── ThreadLocalUtil
            └── TinyApplication       # Main application entry point
```

## Features and Endpoints

### User Registration

- **Endpoint:** `POST /user/register`
- **Description:** Registers a new user with a username and password.
- **Request Parameters:**
<<<<<<< HEAD
  - `username` (String): The username of the new user.
  - `password` (String): The password for the new user.
- **Response:** 
  - `200 OK` if the registration is successful.
  - `400 BAD REQUEST` if the username already exists.
=======
    - `username` (String): The username of the new user.
    - `password` (String): The password for the new user.
- **Response:**
    - `200 OK` if the registration is successful.
    - `400 BAD REQUEST` if the username already exists.
>>>>>>> 0df5395 (加入操作日志功能)

---

### User Login

- **Endpoint:** `POST /user/login`
- **Description:** Authenticates the user and returns a token upon successful login.
- **Request Parameters:**
<<<<<<< HEAD
  - `username` (String): The username of the user.
  - `password` (String): The password for the user.
- **Response:** 
  - `200 OK` with a JWT token if the login is successful.
  - `400 BAD REQUEST` if the user does not exist or the password is incorrect.
=======
    - `username` (String): The username of the user.
    - `password` (String): The password for the user.
- **Response:**
    - `200 OK` with a JWT token if the login is successful.
    - `400 BAD REQUEST` if the user does not exist or the password is incorrect.
>>>>>>> 0df5395 (加入操作日志功能)

---

### View User Information

- **Endpoint:** `GET /user/userInfo`
- **Description:** Retrieves the logged-in user's information.
<<<<<<< HEAD
- **Headers:** 
  - `Authorization`: The JWT token of the logged-in user.
- **Response:** 
  - `200 OK` with the user's information.
=======
- **Headers:**
    - `Authorization`: The JWT token of the logged-in user.
- **Response:**
    - `200 OK` with the user's information.
>>>>>>> 0df5395 (加入操作日志功能)

---

### Update User Information

- **Endpoint:** `PUT /user/update`
- **Description:** Updates the user's profile information.
- **Request Body:**
<<<<<<< HEAD
  - JSON representation of the `User` object.
- **Response:** 
  - `200 OK` if the update is successful.
=======
    - JSON representation of the `User` object.
- **Response:**
    - `200 OK` if the update is successful.
>>>>>>> 0df5395 (加入操作日志功能)

---

### Update Password

- **Endpoint:** `PATCH /user/updatePwd`
- **Description:** Updates the user's password after verifying the old password.
<<<<<<< HEAD
- **Headers:** 
  - `Authorization`: The JWT token of the logged-in user.
- **Request Body:**
  - `old_pwd` (String): The old password.
  - `new_pwd` (String): The new password.
  - `re_pwd` (String): The confirmation of the new password.
- **Response:** 
  - `200 OK` if the password is updated successfully.
  - `400 BAD REQUEST` if the old password is incorrect or the new passwords do not match.
=======
- **Headers:**
    - `Authorization`: The JWT token of the logged-in user.
- **Request Body:**
    - `old_pwd` (String): The old password.
    - `new_pwd` (String): The new password.
    - `re_pwd` (String): The confirmation of the new password.
- **Response:**
    - `200 OK` if the password is updated successfully.
    - `400 BAD REQUEST` if the old password is incorrect or the new passwords do not match.
>>>>>>> 0df5395 (加入操作日志功能)

---

### File Upload (TODO)

- The `FileUploadController` is designed for handling file uploads. Implement the actual functionality as needed.

## Technologies Used

- **Spring Boot:** Framework for building the application.
- **MyBatis:** ORM tool for database interactions.
- **Redis:** Used for token storage and session management.
- **JWT (JSON Web Tokens):** For user authentication and authorization.
- **Lombok (optional):** To reduce boilerplate code for POJOs (not used in this project based on user preference).

## How to Run

1. Clone this repository:
   ```bash
   git clone https://github.com/linkaitai/TinySpringBootDemo.git
   cd TinySpringBootDemo
   ```

2. Build and run the project:
   ```bash
   ./mvnw spring-boot:run
   ```

3. Access the application via `http://localhost:8080`.

## Notes

- Ensure that Redis is running on your machine or server before starting the application.
- Update the `application.properties` file for the correct database and Redis configurations.

---
