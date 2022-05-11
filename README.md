# LandMapper
Spring Boot app that calculates the shortest land route between two given countries. The app is given a list of countries in JSON format
and calculates the route by utilizing individual countries border information.

### Task
Specifications:
* Spring Boot, Maven
* Data link: https://raw.githubusercontent.com/mledoze/countries/master/countries.json
* The application exposes REST endpoint `/routing/{origin}/{destination}` that
returns a list of border crossings to get from origin to destination
* Single route is returned if the journey is possible
* Algorithm needs to be efficient
* If there is no land crossing, the endpoint returns HTTP 400
* Countries are identified by cca3 field in country data
* HTTP request sample (land route from Czech Republic to Italy):
  * `GET /routing/CZE/ITA HTTP/1.0 :`
  ```
  {
  "route": ["CZE", "AUT", "ITA"]
  }
  ```
  
### How to Run App
1. Generate `.jar` executable by running the following command in project root directory `mvn clean install`. The executable
can be found in the `target` folder
2. Run the executable by executing the command: `mvn spring-boot:run`. The app will run on localhost port 8080.
   1. You access the app by making a `GET` request to this URL: `http://localhost:8080/routing/{origin}/{destination}`


