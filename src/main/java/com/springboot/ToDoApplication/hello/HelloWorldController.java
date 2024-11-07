package com.springboot.ToDoApplication.hello;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/hello-world")
    public String helloWorld() {
        return "Hello World v2";
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/basicauth")
    public String basicAuthentication() {
        return "Success";
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/hello-world-bean")
    public HelloWorldBean helloWorldBean() {
        return new HelloWorldBean("Hello World!");
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/hello-world/path-variable/{name}" )
    public HelloWorldBean helloWorldBeanPathVariable(@PathVariable String name) {
        return new HelloWorldBean(String.format("Hello world, %s", name));
    }
}
