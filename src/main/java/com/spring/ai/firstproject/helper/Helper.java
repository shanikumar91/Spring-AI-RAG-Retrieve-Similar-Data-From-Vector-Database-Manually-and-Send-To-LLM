package com.spring.ai.firstproject.helper;

import java.util.List;

public class Helper {
    public static List<String> getData(){
        return List.of("Java is a platform-independent, object-oriented programming language.",
                "JVM converts Java bytecode into machine code at runtime.",
                "JDK includes the compiler (Javac)and JVM tools.",
                "Java supports garbage collection to manage memory automatically.",
                "A class is a blueprint, While an object is an instance of that class.",
                "public static void main(String[] args) is the entry point of the java program.",
                "Java supports multi-threading using the Thread class or Runnable interface.",
                "synchronized keyword ensures thread safety.",
                "Spring Boot simplifies Java backend development with auto-configuration.",
                "Hibernate ORM maps Java objects to database tables.",
                "JPA is a specification; Hibernate is an implementation.",
                "Java 8 introduced Lambda expressions and Stream API.",
                "The Optional class avoids null pointer exceptions.",
                "The Spring, @Autowired injects dependencies automatically.",
                "Spring security handles authentication and authorization.",
                "Spring Data JPA provides repository interfaces for database queries.",
                "Microservices in Spring Boot often use eureka for service discovery.",
                "Spring cloud config provides centralized configuration.",
                "Spring Boot applications typically run on an embedded Tomcat server.",
                "Rest APIs in java use @RestController and @RequestMapping.");
    }
}
