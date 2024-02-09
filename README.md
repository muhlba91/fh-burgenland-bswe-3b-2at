# SWM 2AT
This repository has been forked from https://github.com/muhlba91/fh-burgenland-bswe-3b-2at. 
It uses Java Spring Boot and Gradle as a Build Tool. It has been designed with Gradle 8.6 and Java 21.
You can find the Gradle Wrapper under `gradlew.bat`

![Deployment Status](https://github.com/mrtndwrk/fh-burgenland-bswe-3b-2at/actions/workflows/gradle.yml/badge.svg)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)







## Getting started - Windows & IntelliJ
1. Just fork or download the repo to your local machine
2. Open the Project using IntelliJ (or your IDE of choice)
3. Make sure that your Java Version is up to date. Project has been designed for and tested with JDK 21 and Gradle 8.6
4. Navigate to java/io/muehlbachler/fhburgenland/swm/examination/ExaminationApplication.java and compilte/build it

Important/Useful commands
- `./gradlew bootRun`: start the application locally
- `./gradlew test`: run the unit tests
- `./gradlew check`: run all checks defined in Gradle (plugins)
- `./gradlew checkstyleMain checkstyleTest`: run Checkstyle on main and test files
- `./gradlew bootJar`: create the runnable Jar file


## How to contribute
I welcome anyone to contribute to, improve and enhance this project. Please follow these guidelines, if you're interested:
1. Fork the repository and create your branch from main
2. Make your changes -  Please ensure that they adhere to the existing coding standards
3. Test your changes using Unit/Implementation Tests to avoid introducing bugs
4. Submit a PR including a clear description of your changes and why they would be beneficial

If you wanna create issues, please use the template `.github/ISSUE_TEMPLATE`.
Same goes for Pull Requests: `.github/pull_request_template.md`

## Credits
This repository has been forked from the GitHub User https://github.com/muhlba91
It has then been improved upon by https://github.com/mrtndwrk in the following points:
- Branch Protection
  - Branch protection for main has been enabled
  - Require PR before merging. without approvals
  - require status checks to pass and branches to be up to date. All status checks from the pipeline have been selected
  - require linear history
    
- Javadoc has been written for 
  - the controller
  - the service
  - the repository
 
- Unit Tests for
  - Person Service
  - Note Service
  - Controller

- Checkstyle has been added
  -  config file can be found under `config/checkstyle/checkstyle.xml`
    
- Containerization
  - Dockerfile has been created and optimized for the pipeline

- Pipeline includes
  - Unit Tests
  - Lint (Checkstyle and Hadolint)
  - Build (runnable jar file)
  - Container being pushed to GitHub Container Registry
 
## License
This project uses the MIT License which can be found under `LICENSE.md` in the project's root folder
