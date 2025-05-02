<h1 align="center">Welcome to Kafka-Demo-Backend 👋</h1>
<p>
  <a href="https://opensource.org/licenses/MIT" target="_blank">
    <img alt="License: MIT " src="https://img.shields.io/badge/License-MIT -yellow.svg" />
  </a>
</p>

## Description

This backend is a simple messaging application built with Spring Boot and integrated with Apache Kafka for asynchronous message processing. It enables users to send and receive messages through a Kafka topic, with all messages being stored in a relational database (e.g., MySQL).

The application works in three parts:

- Sending Messages (Producer): When a user sends a message from the frontend, the backend receives it via a REST endpoint (/api/mensajes/enviar). This message is forwarded to a Kafka topic (spring-kafka) using a   Kafka producer service.

- Receiving Messages (Consumer): A Kafka listener (@KafkaListener) automatically listens to the same topic. Every time a new message arrives, the listener processes it and saves it to the database using JPA.

- Retrieving Messages: A separate REST endpoint (/api/mensajes/listar) allows the frontend to fetch all saved messages directly from the database.

This service uses a local MySQL database to store user data.


## Project Structure

The project is organized into the following folders:

- Controller: Handles HTTP requests and responses.
- Model: Defines data models and entities.
- Service: Contains business logic and processing.
- Repository: Interfaces with the database using Spring Data JPA.


## Technologies Used

- Java 17 (or higher)
- Spring Boot (latest version): Main framework for building the REST API.
- Spring Kafka: For producing and consuming Kafka messages.
- Apache Kafka: Message broker used for asynchronous communication.
- Spring Data JPA: For object-relational mapping and database persistence.
- MySQL: Database for storing message data.
- Maven: Dependency and build management tool.
  

## Clone the Repository

```sh
git clone https://github.com/arh91/Kafka-Demo-Backend.git
```


## Kafka Installation & Setup

### How to Install Kafka

1. Download Kafka: Go to the official Apache Kafka downloads page and download the latest binary release (e.g., kafka_2.13-3.6.0).

2. Extract and Move the Folder: It's recommended to place Kafka in a permanent location on your system. For example:

  - On Windows: C:\Kafka

  - On Linux/macOS: /usr/local/kafka or inside your home directory ~/kafka

3. Set Environment Variables (Optional but Recommended): Add the bin directory to your system’s PATH:

  - Windows:

  ```makefile
  C:\Kafka\bin\windows
  ```
  
  - Linux/macOS:
  
  ```ruby
  export PATH=$PATH:/usr/local/kafka/bin
  ```

### How to Run Kafka

Kafka requires ZooKeeper to run, so you must start it before launching the Kafka broker.

If you're using Kafka 3.x+, note that future versions may remove ZooKeeper entirely, but it's still required for now unless you're using KRaft mode.

1. Start ZooKeeper:

  - Windows:
  
  ```sh
  zookeeper-server-start.bat config\zookeeper.properties
  ```
  
  - Linux/macOS:
  
  ```sh
  bin/zookeeper-server-start.sh config/zookeeper.properties
  ```

2. Start Kafka Broker:

  - Windows:
  
  ```sh
  kafka-server-start.bat config\server.properties
  ```
  
  - Linux/macOS:
  
  ```sh
  bin/kafka-server-start.sh config/server.properties
  ```

⚠️ Make sure port 2181 (ZooKeeper) and 9092 (Kafka) are not blocked by firewalls or in use by other processes.


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

