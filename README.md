# Helsinki city bike
Helsinki city bike is a Spring boot application that uses a backend service to fetch data. Data comes from CSV files which
are validated before importing it to a MySQL database. The application has three views: journey list view, station list view, 
and a single station view.

### Journey list view
http://localhost:8082/
Lists journeys with pagination. 
The journeys can be ordered by clicking on any of the table header cells.
The amount of journeys shown on one page can be changed by changing the number on the number input and clicking "load journeys" button.

### Station list view
http://localhost:8082/stations.html
Lists stations with pagination.
The stations can be ordered by clicking on any of the table header cells.
The amount of stations shown on one page can be changed by changing the number on the number input and clicking "Reload stations" button.
By clicking on a row on the station table, the single station view opens on that station.

### Single station view
http://localhost:8082/single_station.html?id=1
Shows the station id, name, total number of journeys starting from the station, and total number of journeys ending at the station.

## Technology choices
* Java version 17 or newer
* MySQL (8.0.31)
* Spring boot
* Maven
* JavaScript
* html
* css

## Configurations
Create a local MySQL database called "city_bike_db" with a username "citybikeuser" and password "ThePassword" or change 
the following settings from application.properties to match your configurations.
* spring.datasource.url=jdbc:mysql://localhost:3306/city_bike_db
* spring.datasource.username=citybikeuser
* spring.datasource.password=ThePassword

## How to run the program.
`.\mvnw spring-boot:run`

## How to run the tests
`.\mvnw test`

## TODO
* Add searching for journeys and stations
* Add test to CSV data import
* Add logger



