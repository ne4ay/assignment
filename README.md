# My Todo

This project is dedicated to the following assginment: 


We need an application to sort students by their performance.
System UI can be written using any framework you are familiar with, but It must allow user to select a text
file with student data, sorting algorithm and display result in table with an option to save it to a file.
As we are not sure how many students will have to be sorted, we would like you to implement Bubble,
Heap and Merge sorting algorithms, but enable system design to be easily extendable in future.
To simplify benchmarking we would like to see a number of records and sorting time.
Input file example:
...
Student1,8.5
Student2,6.5
Student3,5.0
....

## Running the application
The project is a standard Maven project. To run it from the command line,
type 
    for Linux - 'mvn clean install && mvn spring-boot::run -pl frontend'
    for Windows Powershell - '(mvn clean install) -and (mvn spring-boot::run -pl frontend)'
to build and run the project, then open
http://localhost:8080 in your browser.

You can also import the project to your IDE of choice as you would with any
Maven project.

## Deploying to Production

To create a production build, call `mvnw clean package -Pproduction` (Windows),
or `./mvnw clean package -Pproduction` (Mac & Linux).
This will build a JAR file with all the dependencies and front-end resources,
ready to be deployed. The file can be found in the `target` folder after the build completes.

Once the JAR file is built, you can run it using
`java -jar target/mytodo-1.0-SNAPSHOT.jar`