# Rule Engine Application

## Overview

This is a simple 3-tier rule engine application that determines user eligibility based on attributes such as age, department, income, and spend. It uses an Abstract Syntax Tree (AST) to represent conditional rules, allowing for dynamic creation, combination, and modification of these rules.

## Features

- **Rule Creation**: Define rules using a string representation that gets converted to an AST.
- **Rule Combination**: Combine multiple rules into a single AST.
- **Rule Evaluation**: Evaluate rules against user attributes.
- **Data Storage**: Store rules in a MySQL database.

## Technologies Used

- Java
- Spring Boot
- Hibernate
- MySQL
- Docker

## Dependencies

Make sure you have the following installed:

- Java 17 or higher
- Maven
- MySQL
- Docker (optional, for containerized setup)

## Build Instructions

1. **Clone the repository**:
   ```bash
   git clone https:/DewanganPiyush/github.com//rule-engine.git
   cd rule-engine

2. **Build the project using Maven**:
    ```bash
    mvn clean install

3. **Set up the MySQL database**:

Create a database named rule_engine.
Update the database credentials in src/main/resources/application.properties.

4. **Run the application**:
   ''bash
   mvn spring-boot:run

## API Endpoints

-**POST /rules**: Create a new rule.
-**GET /rules**: Retrieve all rules.
-**POST /rules/evaluate**: Evaluate a rule against given user data.
-**POST /rules/combine**: Combine multiple rules into a single AST.

## API Endpoints

-**POST /rules**: Create a new rule.
-**GET /rules**: Retrieve all rules.
-**POST /rules/evaluate**: Evaluate a rule against given user data.
-**POST /rules/combine**: Combine multiple rules into a single AST.

## Sample Rules

Rule 1: ((age > 30 AND department = 'Sales') OR (age < 25 AND department = 'Marketing')) AND (salary > 50000 OR experience > 5)
Rule 2: ((age > 30 AND department = 'Marketing')) AND (salary > 20000 OR experience > 5)

## Running Tests

You can add tests as needed to validate the functionality of your rule engine.

## Design Choices

-**AST Representation**: The Node class represents the structure of the AST, allowing dynamic modification.
-**Database Storage**: Used JPA for ORM with a MySQL database to persist rules.
-**RESTful API**: Built using Spring Boot, facilitating easy interaction with the rule engine.

## License

This project is licensed under the MIT License.

## Dockerfile

Here's a basic Dockerfile to containerize your Spring Boot application:

**Use OpenJDK 17 as the base image**
FROM openjdk:17-jdk-slim

**Set the working directory**
WORKDIR /app

**Copy the jar file from target to the working directory**
COPY target/rule-engine-0.0.1-SNAPSHOT.jar rule-engine.jar

**Expose the application port**
EXPOSE 8080

**Run the application**
ENTRYPOINT ["java", "-jar", "rule-engine.jar"]


   




