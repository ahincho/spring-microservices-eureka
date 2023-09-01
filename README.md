# Microservices Client with Load Balancing and Resilience

This repository contains a set of microservices that demonstrate the use of load balancing, circuit breaking, and resilience techniques in a microservices architecture. The project consists of several modules, each serving a specific purpose.

## Introduction

This project showcases a microservices architecture where different services collaborate to provide a distributed application. The architecture focuses on handling potential failures, distributing loads, and maintaining system stability even under adverse conditions.

## Modules

The project is divided into several modules:

- eureka-server: A Eureka server for service discovery.
- sales-backup: A backup service for sales information.
- sales-mongodb: A sales service using MongoDB as a backend.
- sales-mysql: A sales service using MySQL as a backend.
- client-ribbon-balanced: A client application that uses Ribbon for load balancing and Resilience4j for circuit breaking.
- client-eureka-balanced: Another client application that uses OpenFeign and Eureka for load balancing and service discovery.

## Technologies Used

- Spring Boot
- Spring Cloud
- Netflix Eureka
- Netflix Ribbon
- Resilience4j
- OpenFeign
- RestTemplate
- MongoDB
- MySQL
- PostgreSQL
- H2 Database

## Getting Started

1. Clone this repository:

https://github.com/ahincho/spring-microservices-sales-clients

2. Navigate to the desired module:

cd module-name

3. Build the module using Maven:

mvn clean install

4. Run the module:

mvn spring-boot:run

## Usage

- The Eureka Server provides service discovery and registration.
- The Sales Services (sales-backup, sales-mongodb, sales-mysql, sales-postgresql) offer sales-related data using different backend databases.
- The Client Applications (client-ribbon-balanced, client-eureka-balanced) demonstrate load balancing and resilience techniques.

## Contributing

Contributions are welcome! If you'd like to contribute, please fork the repository, create a new branch, make your changes, and submit a pull request.

## License

This project is licensed under the MIT License.
