# URL Shortener Project -- Architecture & Development Workflow

## 1. Project Overview

A simple URL Shortener built with: - Java - Spring Boot - Spring Data
JPA - MySQL

Goal: Convert long URLs into short codes and redirect users to the
original URL.

Example:

Long URL: https://google.com

Short URL: http://localhost:8080/Ab3kL2

------------------------------------------------------------------------

# 2. High-Level Architecture

Client (Browser / Postman) \| v Spring Boot Controller \| v Service
Layer \| v Repository (Spring Data JPA) \| v MySQL Database

------------------------------------------------------------------------

# 3. Request Flow

## 3.1 Create Short Link

POST /shorten

Client sends JSON:

{ "url": "https://google.com" }

Flow:

1.  Controller receives request
2.  Extract URL from body
3.  Generate short code
4.  Save record to database
5.  Return short URL

Database record:

id \| short_code \| original_url 1 \| Ab3kL2 \| https://google.com

------------------------------------------------------------------------

## 3.2 Redirect Flow

GET /{code}

Example:

GET /Ab3kL2

Flow:

1.  Controller receives code
2.  Repository searches database
3.  Retrieve original URL
4.  Return redirect response
5.  Browser opens original URL

------------------------------------------------------------------------

# 4. Project Structure

Typical Spring Boot structure:

src/main/java/com/example/shortlink/

controller/ LinkController.java

service/ LinkService.java

repository/ LinkRepository.java

model/ Link.java UrlRequest.java

ShortlinkApplication.java

------------------------------------------------------------------------

# 5. Database Schema

Table: links

id (BIGINT, PK, AUTO_INCREMENT)

short_code (VARCHAR)

original_url (VARCHAR)

Optional future fields:

click_count INT

created_at DATETIME

expire_at DATETIME

------------------------------------------------------------------------

# 6. Key Components

## Controller

Handles HTTP requests.

Endpoints:

POST /shorten GET /{code}

------------------------------------------------------------------------

## Service

Business logic:

generate short code

validation

future features (analytics, expiration)

------------------------------------------------------------------------

## Repository

Spring Data JPA interface.

Handles:

save()

findByShortCode()

------------------------------------------------------------------------

## Entity

Maps Java object to database table.

Example:

@Entity class Link

------------------------------------------------------------------------

# 7. Debugging Strategy

Instead of print statements:

Use IntelliJ debugger.

Steps:

1.  Place breakpoint
2.  Run application in debug mode
3.  Send request
4.  Inspect variables

Important checks:

request.url

generated code

link object

database save

------------------------------------------------------------------------

# 8. Common Issues During Development

1.  Using browser for POST request

Solution: Use Postman or curl.

2.  Database mismatch

Java connected to different DB than MySQL Workbench.

Check:

SELECT DATABASE();

3.  Missing annotations

@Entity

@Id

------------------------------------------------------------------------

# 9. Possible Improvements

Production features:

1.  Click analytics

count link visits

2.  Base62 short code generation

id → encoded string

3.  Redis caching

faster redirects

4.  Link expiration

disable old links

5.  Rate limiting

prevent spam links

------------------------------------------------------------------------

# 10. Final Architecture Summary

Client \| v REST API (Spring Boot Controller) \| v Business Logic
(Service) \| v Data Access (Spring Data JPA Repository) \| v Database
(MySQL)

------------------------------------------------------------------------

This architecture represents a typical backend service pattern used in
many real-world Java applications.
