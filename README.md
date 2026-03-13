URL Shortener - Spring Boot Project

A simple URL Shortener Service built with:

Java

Spring Boot

Spring Data JPA

MySQL

The application converts long URLs into short codes and redirects users to the original URL.

Example:

Long URL: https://google.com
Short URL: http://localhost:8080/Ab3kL2
Project Architecture
Client (Browser / Postman)
        |
        v
Spring Boot Controller
        |
        v
Service Layer
        |
        v
Repository (Spring Data JPA)
        |
        v
MySQL Database
API Endpoints
1. Create Short Link

Endpoint

POST /shorten

Request Body

{
  "url": "https://google.com"
}

Flow

Controller receives request

Extract URL from request body

Generate short code

Save record to database

Return short URL

Example Database Record

id	short_code	original_url
1	Ab3kL2	https://google.com
2. Redirect to Original URL

Endpoint

GET /{code}

Example request:

GET /Ab3kL2

Flow

Controller receives short code

Repository searches database

Retrieve original URL

Return HTTP redirect response

Browser opens the original URL

Project Structure

Typical Spring Boot project structure

src/main/java/com/example/shortlink/

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
Database Schema

Table: links

Field	Type	Description
id	BIGINT	Primary key (auto increment)
short_code	VARCHAR	Generated short code
original_url	VARCHAR	Original long URL
Optional Future Fields
click_count INT
created_at DATETIME
expire_at DATETIME
Key Components
Controller

Handles HTTP requests.

Endpoints:

POST /shorten
GET /{code}
Service

Contains business logic:

Generate short code

Validate URLs

Handle redirect logic

Future features (analytics, expiration)

Repository

Spring Data JPA interface for database access.

Handles operations like:

save()
findByShortCode()
Entity

Maps Java objects to database tables.

Example:

@Entity
public class Link {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String shortCode;
    private String originalUrl;
}
Debugging Strategy

Instead of using many print statements, use the IntelliJ Debugger.

Steps

Place breakpoint

Run application in Debug mode

Send request (Postman / curl)

Inspect variables

Important things to check:

request.url
generatedCode
link object
database save result
Common Development Issues
Using Browser for POST request

Browsers only send GET requests by default.

Solution:

Use Postman or curl.

Database mismatch

Sometimes the application connects to a different database than MySQL Workbench.

Check with:

SELECT DATABASE();
Missing annotations

Common mistakes:

@Entity
@Id
@GeneratedValue
Possible Improvements

Production features you can add:

Click Analytics

Track how many times a link is opened.

click_count
Base62 Short Code Generation

Instead of random strings:

id -> Base62 encoded string
Redis Caching

Speed up redirect performance.

Link Expiration

Allow links to expire after a certain time.

Rate Limiting

Prevent spam or abuse.

Final Architecture Summary
Client
   |
   v
REST API (Spring Boot Controller)
   |
   v
Business Logic (Service Layer)
   |
   v
Data Access (Spring Data JPA Repository)
   |
   v
Database (MySQL)

This architecture follows a typical backend service pattern used in real-world Java applications.
