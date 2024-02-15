# FH Burgenland - Software Engineering - Software Management II - 2AT Examination

This repository contains your starting point for your 2AT examination.

---
## Project Overview
This repository serves as the foundation for the SWM 2AT examination. It's based on Java Spring Boot and utilizes Gradle as a Build Tool. Designed with Gradle 8.6 and Java 21, the project aims to provide a robust framework for software management and engineering tasks.

## Getting Started
To get started with the project, follow these steps:
1.	Fork or download the repository to your local machine.
2.	Open the project using IntelliJ or your preferred IDE.
3.	Ensure that your Java Version is up to date (JDK 21) and Gradle 8.6.
4.	Navigate to: java/io/muehlbachler/fhburgenland/swm/examination/ExaminationApplication.java and compile/build it.


### Useful Commands

- `./gradlew bootRun`: start the application locally
- `./gradlew test`: run the unit tests
- `./gradlew check`: run all checks defined in Gradle (plugins)
- `./gradlew checkstyleMain checkstyleTest`: run Checkstyle on main and test files
- `./gradlew bootJar`: create the runnable Jar file

---


### How to Contribute

Contributions to the project are welcome! Follow these guidelines:
1.	Fork the repository and create your branch from main.
2.	Make changes adhering to existing coding standards.
3.	Test your changes using Unit/Implementation Tests to avoid introducing bugs.
4.	Submit a PR with a clear description of your changes and their benefits.
5.	Use the provided issue and pull request templates.

### Credits

This repository is a fork of the original work by muhlba91 and has been enhanced by https://github.com/Efnan99 with the following improvements:

### Branch Protection
•	Enabled branch protection for main.
•	Require PR before merging without approvals.
•	Require status checks to pass and branches to be up to date.
•	Enforce linear history.
### Javadoc
•	Added Javadoc for controllers, services, and repositories and more because of Checkstyle.
### Unit Tests
•	Implemented Unit Tests for PersonService, NoteService, and Controller.
### Checkstyle
•	Added the plugin Checkstyle with a configuration file under the package config/checkstyle.
### Container
•	Created and optimized Dockerfile for the pipeline.
•	Integrated containerization into the pipeline, pushing the container to GitHub Container Registry by using a Token

