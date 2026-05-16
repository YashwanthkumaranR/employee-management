# Employee Management System

A full stack REST API built with Java Spring Boot and MySQL.

## Tech Stack
- Java 21
- Spring Boot 4.0
- Spring Data JPA
- MySQL
- Lombok
- Postman for testing

## Features
- Create, Read, Update, Delete employees
- RESTful API endpoints
- Global exception handling
- Connected to MySQL database

## API Endpoints
| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | /api/employees | Create employee |
| GET | /api/employees | Get all employees |
| GET | /api/employees/{id} | Get employee by ID |
| PUT | /api/employees/{id} | Update employee |
| DELETE | /api/employees/{id} | Delete employee |

## Setup
1. Clone the repository
2. Create MySQL database named `employeedb`
3. Update application.properties with your MySQL credentials
4. Run EmployeeManagementApplication.java
5. Test endpoints using Postman on port 8081