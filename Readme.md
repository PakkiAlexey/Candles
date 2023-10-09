Build and Run Instructions

1. Clone the repository:
   git clone https://github.com/PakkiAlexey/Candles.git

2. Navigate to the project root directory:
   cd Candles

3. Build the Docker images and start the containers using Docker Compose:
   docker-compose up --build

This command will build the Docker image for the Spring Boot application, pull the MongoDB image,
and start the containers.
Wait for the containers to start up and initialize.
Once the containers are up and running, you can access the Spring Boot application at http://localhost:8082.