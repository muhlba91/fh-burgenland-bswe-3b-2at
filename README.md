# FH Burgenland - Software Engineering - Software Management II - 2AT Examination

This repository contains your starting point for your 2AT examination.

---

## Getting Started

- Fork this repository to a public repository in your own account.
- Copy the issue #1 in this repository into a new issue in your forked repository.
- Checkout your forked repository.

### Environment

This Java Spring Boot application uses Gradle and requires Java 21.
A Gradle Wrapper is present (`gradlew(.bat)`).

### Useful Commands

- `./gradlew bootRun`: start the application locally
- `./gradlew test`: run the unit tests
- `./gradlew check`: run all checks defined in Gradle (plugins)
- `./gradlew checkstyleMain checkstyleTest`: run Checkstyle on main and test files
- `./gradlew bootJar`: create the runnable Jar file

---

## Assignment

### Commit Hygiene

- Every commit message must follow the [Conventional Commits](https://www.conventionalcommits.org/en/v1.0.0/) specification.
- "Merge commits" must not be created. (You can also disable them for pull requests in your repository settings.)
- 1 "issue/task" ~ 1 commit ~ 1 pull request
  - Exceptions for pull requests need to be explained but are permitted, e.g. for fixing code style errors when enabling Checkstyle.
  - Keep the commit size (number of files/lines changed) small and easily reviewable (exception: unit tests).
  - Use squashing before merging a pull request.

Please note that I have provided a file `.conform.yaml` which you can use together with [conform](https://github.com/siderolabs/conform) to check commits.

### Issues

You can use the provided issue template for any issue you need to create.
If you do not want to use it, please delete the directory `.github/ISSUE_TEMPLATE`.
If you do use it, please make sure to put your GitHub handle as an assignee.

Issues are expected to be detailed enough to be understood by an external developer, and your technical product owner (a.k.a. the product owner responsible for the product in this repository).
In fact, they do not need to be exhaustively explained; focus on the core points, the why/use case, and potentially an additional useful context.

If you find bugs in the code, please create an issue, work on it, and close the issue with a commit/pull request.

You are required to create an issue for each task of this assignment. (Yes, there will not be many issues!)
They will not be "feature encapsulated" but rather focus on each topic, like "unit tests for service X", "Checkstyle", "pipeline", ...

### Pull Requests

- Enable branch protection for `main`.
- Require pull requests before merging.
- Require status checks to pass and branches to be up to date.
- Require linear history.
- See the pipeline section for additional actions.

### Javadoc Issue

In the "Getting Started" section you copied over an already existing issue.
You are expected to implement and close it (in your forked repository).

### Unit Tests

- Create common unit tests (success and fail path) for
  - the person service, and
  - the note service.
- Think about 1 edge case per service, if there is one. (You do not need to implement a test case for it!)
- Fix bugs you encounter (hint: think about other sections applying here).

### Code Style

- Add Checkstyle as a syntax checker.
- Use the configuration file located in `config/checkstyle/checkstyle.xml`.
- Fix any errors the tool finds (hint: think about other sections applying here).

### Pipeline

- Create a pipeline containing the following jobs:
  - Test
  - Lint
  - Build (Jar File) - assumption: build lasts 1 hour
- Set the correct job dependencies.
- Make sure your pipeline runs through at least 3 commits (on `main`) without any errors.
- Enable branch protection required checks to include all jobs (hint: pipeline must have run on `main` before checks can be enabled).

Please note that you can also integrate `conform` into your pipeline, but it is not required to do so!

### (Bonus) OpenAPI Specification

Create an OpenAPI specification for the following endpoints:

- `/person/`
- `/person/query`

You do not need to write long descriptions; keep it short and crisp but clear for every developer looking at it.

Attention: this task is optional! You can also work on it between the submission deadline and your oral examination!

---

## Submission

Please submit your GitHub repository by e-mail until 3 days before your examination, at the latest.
Afterward, no changes are permited anymore! The only exception is the bonus task (see above).

## Oral Examination

We will go through your submission and talk about your work, and follow-up deep dive questions (practical about your work, and theoretical about concepts).
It is important you understand the concepts, links between each topic, what you are/would be doing to achieve certain goals, and can refer to those in theoretical examples given.

I encourage you to review all slide decks, and additionally linked information to understand the concepts (e.g. 12-factor app).
Please note that I expect you to understand the overall concepts about the topic "Kubernetes" but we will not dive very deep here.

---

## Questions

If you have any questions about the assignment, please feel free to get in touch.
