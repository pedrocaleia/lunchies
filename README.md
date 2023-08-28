# Lunchies
A calorie count APP for employee's lunches.

The application consists of 4 services:
- Product Service;
- Order Service;
- User Service;
- GUI Service;

The Product service provides the data management for Products.
The Order service provides the means to register new lunch Orders and to calculate the respective calories.
The User service provides Authentication with a Username / Password and Authorization using OAuth2.
The GUI service provides a simple user interface using Vaadin.

The services can be booted up using the Maven Wrapper provided. It can be accomplished by executing `mvnw spring-boot:run` inside each service folder.

The User service relies on a DNS name in order to function, given that when it is run locally if it used the localhost it would interfere with the cookies. The DNS name in use is `lunchies-auth-server`.

GitHub actions have been set to compile and test the services. No deployment has been configured.

The GUI is served through HTTPS using a self generated certificate, so browser warnings are to be expected.

If necessary a new PKCS12 can generated using the following commands:
- `openssl req -x509 -sha256 -nodes -days 365 -newkey rsa:2048 -keyout lunchies.key -out lunchies.crt`
- `openssl pkcs12 -export -inkey lunchies.key -in lunchies.crt -out lunchies.pfx -name lunchies`

When all services are up the application can be reached at: [localhost:9090](https://localhost:9090)
