<h1 align="center">Welcome to Kafka-Demo-Backend 👋</h1>
<p>
  <a href="https://opensource.org/licenses/MIT" target="_blank">
    <img alt="License: MIT " src="https://img.shields.io/badge/License-MIT -yellow.svg" />
  </a>
</p>

## Description

Backend service for user management in a web application, developed with Java and Spring Boot. It provides basic operations such as:

- Creating new users.
- Listing all users.
- Updating user details.
- Deleting a user.

This service uses a local MySQL database to store user data.


## Project Structure

The project is organized into the following folders:

- Controller: Handles HTTP requests and responses.
- Model: Defines data models and entities.
- Service: Contains business logic and processing.
- Repository: Interfaces with the database using Spring Data JPA.


## Technologies Used

- Kafka
- Java 17 (or higher)
- Spring Boot (latest version)
- Spring Data JPA
- MySQL
- Maven

## Clone the Repository

```sh
git clone https://github.com/arh91/Kafka-Demo-Backend.git
```


## Set Up the Database 

Ensure MySQL is installed and running locally. Create a database named mensajes_kafka:

```sh
CREATE DATABASE mensajes_kafka;
```


## Configure the Application

Edit src/main/resources/application.properties to set up the database connection:

```sh
spring.datasource.url=jdbc:mysql://localhost:3306/mensajes_kafka
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.kafka.bootstrap-servers=localhost:9092
spring.kafka.consumer.group-id=grupo-demo
spring.kafka.consumer.auto-offset-reset=earliest
spring.kafka.consumer.key-deserializer=org.apache.kafka.common.serialization.StringDeserializer
spring.kafka.consumer.value-deserializer=org.apache.kafka.common.serialization.StringDeserializer

```


## Install

```sh
mvn install
```

## Usage

After installing the dependencies, you can start the application by running the next command:

```sh
mvn spring-boot:run
```

## Run tests

```sh
mvn test
```

## Author

👤 **arh91**


## 🤝 Contributing

Contributions, issues and feature requests are welcome!<br />
Feel free to check [issues page](https://github.com/arh91/Gestion-Usuarios-Backend/issues). 


## Show your support

Give a ⭐️ if this project helped you!


## 📝 License

This project is [MIT ](https://opensource.org/licenses/MIT) licensed.

