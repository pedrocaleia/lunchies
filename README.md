# Lunchies
A calorie count APP for employee's lunches.

The application consists of 4 services:
- Product Service;
- Order Service;
- User Service;
- GUI Service;

The Product service provides the data management for Products.
The Order service provides the means to register new lunch Orders and to calculate the respective calories.
The User service provides Authentication with a Username and Password and Authorization using OAuth2.
The GUI service provides a simple user interface using Vaadin.

The services can be booted up using the Maven Wrapper provided. It can be accomplished by executing `mvnw spring-boot:run` inside each service folder.

The User service relies on a DNS name in order to function, given that when it is run locally if it used the localhost it would interfere with the cookies. The DNS name in use is `lunchies-auth-server`.
