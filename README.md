# GreenBoneFirstR
SimpleCompany 

Computer Inventory System
This is a Java REST API for a computer inventory system that allows system administrators to keep track of the computers issued by a company. The computer details are stored in an arbitrary database and can be accessed via REST interface. The following elements are stored for each computer: MAC address, computer name, IP address, employee abbreviation, and description. The employee abbreviation is optional and consists of 3 letters.

#  Getting Started
These instructions will guide you on how to get a copy of the project up and running on your local machine for development and testing purposes.

#  Prerequisites
You need to have the following installed on your machine:

Java Development Kit (JDK) 1.8 or higher

Apache Maven 3.0 or higher

Docker 19.03 or higher

Installing

Clone the repository to your local machine:


git clone https://github.com/your-username/computer-inventory-system.git

Navigate to the project directory:
cd computer-inventory-system
Build the project using Maven: mvn clean install
This will compile the project and run the tests.

#  Start the messaging service using Docker:
docker run -d --name admin-notification -p 8080:8080 greenbone/exercise-admin-notification
This will download and run the messaging service in a Docker container.

# Start the application:


mvn spring-boot:run
This will start the application on port 8080.

You can access the API using any REST client, such as Postman. 
The following endpoints are available:

GET http://localhost:8080/computers

POST http://localhost:8080/computers

GET http://localhost:8080/computers/{id}

PUT http://localhost:8080/computers/{id}

DELETE http://localhost:8080/computers/{id}

POST http://localhost:8080/computers/notify


#  Running the Tests
You can run the tests using the following command:

mvn test 

Built With

Spring Boot - The web framework used

Maven - Dependency management

H2 Database Engine - In-memory database
JUnit - Testing framework

# Authors
Suraj Kumar Yadav


