# User Management System

Un proiect complet realizat cu Spring Boot pentru gestionarea utilizatorilor, cursurilor și rolurilor într-o aplicație web. Sistemul permite înregistrarea și autentificarea utilizatorilor, atribuirea de roluri și vizualizarea entităților asociate, totul cu o interfață web.

## 📌 Functionalități cheie

- Înregistrare utilizator (Sign Up)
- Autentificare (Login)
- Atribuirea unui rol (User / Admin etc.)
- Atribuirea unei adrese pentru fiecare utilizator
- Gestionarea cursurilor și categoriilor de curs
- Sistem de autentificare bazat pe Spring Security
- Logging & validare automată
- Acces diferențiat în funcție de rol
- Template-uri HTML cu Thymeleaf
- Persistență în PostgreSQL

## ⚙️ Tehnologii folosite

| Tehnologie         | Versiune aproximativă |
|--------------------|------------------------|
| Java               | 17 (Corretto)          |
| Spring Boot        | 3.0.5                  |
| Spring Data JPA    | ✅                     |
| Spring Security    | ✅                     |
| PostgreSQL         | ✅                     |
| Thymeleaf          | ✅                     |
| Lombok             | ✅                     |
| Maven              | ✅                     |
| Hibernate          | ✅                     |
| IntelliJ IDEA      | ✅                     |

## 📁 Structură director

```
src/
├── main/
│   ├── java/com/spring/studentmanagement/
│   │   ├── controllers/
│   │   ├── dto/
│   │   ├── exceptions/
│   │   ├── models/              # Entități JPA
│   │   ├── repositories/
│   │   ├── security/
│   │   ├── services/
│   │   ├── ServletInitializer.java
│   │   └── StudentManagementApplication.java
│   └── resources/
│       ├── db/                 # Scripturi SQL
│       ├── static/             # CSS / JS (opțional)
│       ├── templates/          # HTML Thymeleaf
│       ├── application.yaml
│       ├── application-local.yaml
│       └── data.sql
```

## 🏁 Cum rulez aplicația?

### 1. Setează PostgreSQL
Asigură-te că ai un user, parolă și DB creat. Ex:
```sql
CREATE DATABASE user_management;
```

### 2. Setează variabilele de mediu
Aplicația citește din:

```yaml
spring:
  datasource:
    url: ${DB_URL}
    username: ${DB_USER}
    password: ${DB_PASSWORD}
```

Le poți exporta:
```bash
export DB_URL=jdbc:postgresql://localhost:5432/user_management
export DB_USER=postgres
export DB_PASSWORD=parola_ta
```

### 3. Rulează aplicația
```bash
mvn spring-boot:run
```

sau direct:
```bash
java -jar target/user-management-main.jar
```

Accesează în browser:
```
http://localhost:4000/user-management
```

## 🧪 Utilizare

- `GET /users` – Listează utilizatori (doar pentru Admin)
- `GET /courses` – Listează cursuri
- `POST /sign-up` – Înregistrează un nou utilizator
- `POST /login` – Login
- `GET /users/{id}` – Vizualizează utilizator după ID

## 🧠 Observații

- Dacă folosești `spring.jpa.hibernate.ddl-auto=create`, Hibernate le generează automat la startup (alternativ la SQL-uri).
- Logging complet în `logs/student-management.log`.

## 🔐 Securitate

- Implementată cu `Spring Security`
- Filtru `AuthFilter` pentru protejarea rutelor
- Token JWT *NU* este folosit – autentificarea se face clasic (session-based).

