# MAN FOTA

Here you can find the information about how to execute this application and details of configuration.

============================= EXECUTION ==============================

This application can be executed using maven command: mvn spring-boot:run

============================= PROPERTIES =============================

This application depends on configured properties. These properties are related to the functionality responsible for reading CSV files and persisting data.

The initial properties are:

Path to the folder where your CSV files are stored: FOLDER_PATH
Condition if a CSV file can be, or not, reprocessed: REPROCESS
Extension to be considered to files in the folder: .csv

You can call the service below to check the initial values:

Method: GET
URL: http://localhost:8080/fota/properties/

If you desire to change any of the values, a PUT method is also available:

Method: Put
URL: URL: http://localhost:8080/fota/properties/
Body: {"key":"REPROCESS" , "value":"<NEW_VALUE>"}


============================= SCHEDULER SERVICE =============================

The scheduler service runs according to a timer. It will consider the folder path, described above, and looks for CSV files. If these files exist, the application will execute and persist the information about VIN/FEATURE presented into the file.

ATTENTION: In the case of the file be already being processed, the application will ignore it, even if the file is yet present in the folder, except in the case where the REPROCESS property be established as true.

A cron expression was defined to be considered by this service. This expression can be found in the file main/resources/application.properties.

Initially, It is defined as "cron.expression = * */10 * * * *" which means that the operation will be executed in every 10 minutes.

============================== OTHERS SERVICES ==============================

Swagger documentation is available to support application use. The URL to Swagger is:

http://localhost:8080/fota/swagger-ui.html

There are 5 controllers available. 

Properties-controller - You can see which properties are configured and change values;
CSV-controller - You can force the execution of the operation to read CSV files, without need to wait for the scheduler service;
User-controller - You can set a user to be used on authentication by JWS. To this application, JWS is configured, but all services were released to be called without the necessity of authentication;
Features-controller - Services related to search operations to features;
Vehicles-Controller - Services related to search operations to vehicles;

On the project's directory, you can find a list of all service calls to the Postman. The file name is FOTA.postman_collection.json.

============================== DATABASE ==============================

This application uses an H2 Database. You can access the structure through the URL below: 

http://localhost:8080/fota/h2-console/

As the application is configured to use the Flyway, all structures and initial data will be inserted at the first execution.
