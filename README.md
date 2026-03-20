🧠 Online Quiz System

An interactive Online Quiz System built using Spring Boot, Thymeleaf, and MySQL.
This application allows users to attempt quizzes with different question types, includes a timer, and automatically calculates and stores scores.



🚀 Features

- MCQ (Multiple Choice Questions)
- True/False Questions
- Short Answer Questions
- Timer 
- Automatic score calculation
- Result stored in MySQL database
- User name & email input



🛠️ Tech Stack

- Java
- Spring Boot
- Thymeleaf
- MySQL
- Spring Data JPA



⚙️ How to Run

1. Clone the repository:

git clone https://github.com/kashiiiissh/onlinequiz

2. Open project in VS Code / IntelliJ

3. Configure database in "application.properties":

spring.datasource.url=jdbc:mysql://localhost:3306/quizdb
spring.datasource.username=root
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update

4. Run the application

5. Open in browser:

http://localhost:8080/quizzes



🗄️ Database

Question Table

- id
- question
- optionA
- optionB
- optionC
- optionD
- correctAnswer
- type

Result Table

- id
- user
- attempted_at
- score






-Kashish Kashyap

