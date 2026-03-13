# URL Shortener (Java + Spring Boot)

A simple URL Shortener service built with **Java**, **Spring Boot**, and **MySQL**.
This project converts long URLs into short links and redirects users to the original URL.

---

# Features

* Create short URLs
* Redirect short link to original URL
* Store links in MySQL database
* RESTful API using Spring Boot
* Simple backend architecture

---

# Tech Stack

* Java
* Spring Boot
* Spring Data JPA
* MySQL
* Maven

---

# Architecture

High-level architecture:

Client
↓
Spring Boot Controller
↓
Service Layer
↓
Repository (Spring Data JPA)
↓
MySQL Database

---

# API Endpoints

## Create Short Link

POST `/shorten`

Request Body

```json
{
  "url": "https://google.com"
}
```

Response

```
http://localhost:8080/Ab3kL2
```

---

## Redirect to Original URL

GET `/{code}`

Example

```
http://localhost:8080/Ab3kL2
```

The server will redirect to the original URL.

---

# Database Schema

Table: `links`

| Column       | Type    | Description          |
| ------------ | ------- | -------------------- |
| id           | BIGINT  | Primary key          |
| short_code   | VARCHAR | Generated short code |
| original_url | VARCHAR | Original long URL    |

---

# Project Structure

```
src/main/java/com/example/shortlink

controller/
    LinkController.java

service/
    LinkService.java

repository/
    LinkRepository.java

model/
    Link.java
    UrlRequest.java

ShortlinkApplication.java
```

---

# Run the Project

1. Clone the repository

```
git clone https://github.com/YOUR_USERNAME/url-shortener-java.git
```

2. Configure database in `application.properties`

```
spring.datasource.url=jdbc:mysql://localhost:3306/shortlink
spring.datasource.username=root
spring.datasource.password=YOUR_PASSWORD
```

3. Run the application

```
mvn spring-boot:run
```

Server runs at:

```
http://localhost:8080
```

---

# Example Workflow

1. Send POST request to `/shorten`
2. Server generates short code
3. URL stored in database
4. Access short URL
5. Server redirects to original link

---

# Future Improvements

* Click analytics
* Base62 short code generation
* Redis caching
* Link expiration
* Rate limiting

---

# Author

Built as a learning project for backend development with Java and Spring Boot.
