# Patient Health Records API

A secure REST API for managing patient health records built with Spring Boot.

## Tech Stack
- Java 22
- Spring Boot 4.0
- Spring Security + JWT
- MySQL
- Spring Data JPA / Hibernate
- Maven

## Features
- JWT Authentication
- Role-based access control (Admin, Doctor, Patient)
- Patient CRUD operations
- Audit logging — tracks who accessed what and when
- Global exception handling
- Secure password encryption with BCrypt

## Roles
| Role | Access |
|------|--------|
| ADMIN | Full access to all endpoints |
| DOCTOR | View and manage patient records |
| PATIENT | View own profile only |

## API Endpoints

### Auth
| Method | Endpoint | Access |
|--------|----------|--------|
| POST | /api/auth/login | Public |

### Patients
| Method | Endpoint | Access |
|--------|----------|--------|
| GET | /api/patients | Admin, Doctor |
| GET | /api/patients/{id} | Admin, Doctor |
| POST | /api/patients | Admin, Doctor |
| PUT | /api/patients/{id} | Admin, Doctor |
| DELETE | /api/patients/{id} | Admin, Doctor |
| GET | /api/patients/me | Patient |

### Audit Logs
| Method | Endpoint | Access |
|--------|----------|--------|
| GET | /api/audit | Admin only |
| GET | /api/audit/user/{email} | Admin only |

## Setup

1. Clone the repository
2. Create MySQL database:
```sql
   CREATE DATABASE health_records_db;
```
3. Copy `src/main/resources/application.properties.example` to `application.properties`
4. Update database credentials
5. Run the project

## Default Users
| Email | Password | Role |
|-------|----------|------|
| admin@hospital.com | admin123 | ADMIN |
| doctor@hospital.com | doctor123 | DOCTOR |
| patient@hospital.com | patient123 | PATIENT |