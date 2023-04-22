Library Management System
This is a simple Library Management System built using Spring MVC and Hibernate frameworks.

Features
Allows users to add, edit, and delete books
Allows users to add, edit, and delete people (users)
Allows users to assign books to people and view a person's assigned books
Technologies Used
Spring MVC
Hibernate
MySQL
Maven
How to Run
Clone the repository to your local machine.
Create a MySQL database and update the application.properties file with your database configuration.
CREATE TABLE Book (
id INT PRIMARY KEY AUTO_INCREMENT,
title VARCHAR(255),
author VARCHAR(255),
year INT,
person_id INT,
FOREIGN KEY (person_id) REFERENCES Person(id)
);

CREATE TABLE Person (
id INT PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(255),
year INT
);

Build the project using Maven: mvn clean install.
Deploy the WAR file to a Tomcat server.
Open a web browser and go to http://localhost:{tomcat-port}/persons. or /books
Credits
This project was created by [Aliaksandr Matsiushonak].# LibraryApp.!!
