# JeepSalesWeek13
 YouTube link: https://youtu.be/3PMVY8J51Ls

Inside JeepSalesWeek13/src/main/java/com/promineotech/jeep/controller/

We have  code written in Java and is defining a Spring Boot controller that handles requests related to Jeep sales.
The first block of code defines the BasicJeepSalesController class, which implements the JeepSalesController interface. The @RestController annotation indicates that this class is a controller that will handle incoming HTTP requests. The @RequestMapping annotation specifies the base URI for all requests handled by this controller.
The class has an instance variable of type JeepSalesService, which is autowired by Spring. The fetchJeepList method handles GET requests to the base URI and takes two optional parameters, model and trim. This method returns a list of Jeep objects returned from the fetchJeeps method of the jeepSalesService instance variable. The @ResponseStatus annotation specifies that this method should return an HTTP status code of 200 OK.
The second block of code defines the JeepSalesController interface. It specifies the URI and the required and optional parameters for the GET request. It also uses Swagger annotations to provide metadata and documentation for the API.
The last block of code defines the log class, which includes empty stubs for the debug and info methods.

Inside JeepSalesWeek13/src/main/java/com/promineotech/jeep/entity

The Jeep.java is block is defining a Java class called Jeep that has six properties (modelPK, modelId, trimLevel, numDoors, wheelSize, basePrice) and is annotated with @Data, @Builder, @NoArgsConstructor, and @AllArgsConstructor.
@Data is a Lombok annotation that generates getter and setter methods for all fields, a toString method, and an equals and hashCode method.
@Builder is a Lombok annotation that generates a builder pattern implementation for the class.
@NoArgsConstructor is a Lombok annotation that generates a no-args constructor for the class.
@AllArgsConstructor is a Lombok annotation that generates a constructor that takes all arguments.
The JeepModel.java is code block is defining a Java enum called JeepModel that has seven constants: WRANGLER, GRAND_CHEROKEE, CHEROKEE, COMPASS, RENEGADE, GLADIATOR, and WRANGLER_4XE.
An enum is a special type of class that represents a group of constants. In this case, the JeepModel enum represents the different models of Jeep vehicles that can be sold. Each of the constants in the enum represents a specific model.

Inside JeepSalesWeek13/src/main/java/com/promineotech/jeep/service/

This code defines an interface JeepSalesService and a class DefaultJeepSalesService that implements the interface. The interface defines one method fetchJeeps that takes two String parameters model and trim and returns a list of Jeep objects.
The DefaultJeepSalesService class implements the JeepSalesService interface and provides an implementation for the fetchJeeps method. The implementation simply logs a message using the log variable defined with the @Slf4j annotation, indicating that the method was called with the specified parameters, and then returns null.
The @Service annotation indicates that this class is a Spring service component, which can be injected into other components as a dependency.

Inside JeepSalesWeek13/src/main/java/com/promineotech/jeep/JeepSales.java 
This code defines the main class for a Spring Boot application called "JeepSales".
@SpringBootApplication is an annotation that is used to enable a variety of Spring Boot features, including component scanning, auto-configuration, and property support. The scanBasePackageClasses attribute specifies the marker interface ComponentScanMarker which is used to indicate the base package for component scanning.
The main method is the entry point for the application. It uses SpringApplication.run method to start the application. This method takes two arguments: the main class and the command-line arguments. It sets up the Spring application context, starts the embedded web server, and runs the application.

Inside JeepSalesWeek13src/main/java/com/promineotech/ComponentScanMarker.java 

The ComponentScanMarker interface is an empty marker interface in the com.promineotech package. It serves as a marker for Spring Boot to scan for components (such as controllers, services, repositories) starting at the base package com.promineotech. This approach is useful when you want to separate your component classes from your main application class. By adding the @SpringBootApplication annotation to the main class and specifying the ComponentScanMarker interface as the base package for component scanning, Spring Boot will automatically scan all components within the specified package and its sub-packages, allowing them to be auto-wired and used within the application.

