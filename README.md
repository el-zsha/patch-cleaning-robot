# patch-cleaning-robot
Use Swagger documentation to use this project. 
Just run the spring boot application and access the api via localhost:8080/swagger-ui.html
# How to get the output
Go to /clean on the documentation.
Add your input to instruction text box in json format.
You should expect 200 status code with the desierd output.
If the input is navigating outside the boundries you should get 400 error code with NavigationOutOfBoundException and the coordanation that caused this exception
