# LandMapper
Spring Boot app that calculates the shortest land route between two given countries. The app is given a list of countries in JSON format
and calculates the route by utilizing individual countries border information.

### Task
Specifications:
* Spring Boot, Maven
* Data link: https://raw.githubusercontent.com/mledoze/countries/master/countries.json
* The application exposes REST endpoint /routing/{origin}/{destination} that
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
  
### How to Build App (Unix)
1. Generate `.jar` executable by running the following command in project root directory `mvn clean package`. The executable
can be found in the `target` folder
2. Run the executable by executing the command: `java -jar target/<your-jar-name>.jar`
3. Access the app via Postman / Insomnia / Command line: `curl --request GET \
   --url http://localhost:8080/routing/{origin}/{destination}`


