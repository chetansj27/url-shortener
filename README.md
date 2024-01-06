# Url Shortener
A simple URL shortener implemented in SpringBoot, 
ingngoDB for storage, Redis for caching, and Base62 encoding. Easily shorten and manage your URLs with this fast and scalable service.

Prerequisites
* Java JDK 8 or higher
* Apache Maven
* MongoDB
* Redis
* Docker

## Usage
* Clone the repository:
`
git clone https://github.com/chetansj27/url-shortener.git
`
* Build the project:
`
cd url-shortener
`
`
mvn clean install
`
* Start Docker Compose
`
docker-compose up -d
`
* Access the URL shortener service at http://localhost:8080
