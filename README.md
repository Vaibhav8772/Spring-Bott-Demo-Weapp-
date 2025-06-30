# Spring-Bott-Demo-Weapp-
A Spring Boot web app with user registration, login, logout, and a secure dashboard. Built using Spring Security, Spring Data JPA, Hibernate Validator, Thymeleaf, Bootstrap, HTML, CSS, JS, and PostgreSQL. Features form validation, encrypted passwords, and access control.

To Run The Project :
Create Database itsmdb on Postgresql
Enter your Database URL,Name and Password

📌 Sample Web App: User Management Dashboard
✅ Overview
This is a demo Spring Boot web application that provides:

User registration

User login/logout

A basic dashboard after login

Access control using Spring Security

Data persistence with Spring Data JPA and PostgreSQL

Form validation using Hibernate Validator (JSR-380)

UI built with Thymeleaf + Bootstrap

Client-side interactions with HTML, CSS, JavaScript

🏗 Tech Stack
Layer	Technology
Framework	Spring Boot 3.x
Security	Spring Security
ORM / Validation	Spring Data JPA, Hibernate Validator
Database	PostgreSQL
Template Engine	Thymeleaf
Frontend	Bootstrap 5, HTML5, CSS3, JavaScript
Build Tool	Maven / Gradle (your choice)
Java	Java 17+


⚙ Features
1️⃣ Register
Users can sign up with:

username (unique)

email (unique, valid format)

password (min 6 chars)

Uses Hibernate validation annotations like @NotBlank, @Email, @Size

Saves user to PostgreSQL via Spring Data JPA

2️⃣ Login / Logout
Secure login form using Spring Security

Password stored encrypted (e.g., BCrypt)

Logout invalidates session and redirects to login page

3️⃣ Dashboard
Accessible only to authenticated users

Displays welcome message and sample stats or links

Role-based access (if you want: USER / ADMIN)

💻 Frontend
Bootstrap 5 for responsive UI

Thymeleaf for dynamic templates

Custom CSS and JS for basic interactivity

🔒 Spring Security
Custom UserDetailsService loads users from database

Password encoded with BCryptPasswordEncoder


🌟 Flow
1️⃣ User visits /register → fills form → validated → saved → redirected to /login
2️⃣ User logs in at /login → Spring Security authenticates → goes to /dashboard
3️⃣ Logout invalidates session → redirects to /login?logout

✨ Possible Enhancements
Add roles (USER / ADMIN)

Email verification during registration

Reset password feature

User profile page


Snapshots: 

![Screenshot 2025-06-30 233953](https://github.com/user-attachments/assets/7252c974-efb8-46f5-9885-c7cb5e19587c)
![Screenshot 2025-06-30 233830](https://github.com/user-attachments/assets/197a9b89-b43e-42ec-9e0b-d4a88d9fb12c)
![Screenshot (58)](https://github.com/user-attachments/assets/ffcdea77-dbc7-4ec1-9f4b-298f02e22ff1)


