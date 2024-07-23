# Spring Boot CI/CD Server

This repository contains the Spring Boot application for managing CI/CD jobs.

## Setup

1. **Clone the repository**:
   ```bash
   git clone https://github.com/ozlevy/cicd-server
   cd cicd-server
   ```

2. **Build the project**:
   ```bash
   ./mvnw clean install
   ```

3. **Run the application**:
   ```bash
   ./mvnw spring-boot:run
   ```

4. **Access the H2 database console**:
   - URL: `http://localhost:8080/h2-console`
   - JDBC URL: `jdbc:h2:mem:testdb`
   - User Name: `sa`
   - Password: `password`

## Endpoints

- `GET /jobs`: Retrieve all jobs.
- `POST /jobs`: Create a new job.
- `GET /jobs/{id}`: Retrieve a job by ID.
- `PUT /jobs/{id}`: Update a job.
- `DELETE /jobs/{id}`: Delete a job.
- `GET /jobs/status/{status}`: Retrieve jobs by status.
- `GET /jobs/jobType/{jobType}`: Retrieve jobs by job type.
- `GET /jobs/date-range?startDate={startDate}&endDate={endDate}`: Retrieve jobs by date range.
