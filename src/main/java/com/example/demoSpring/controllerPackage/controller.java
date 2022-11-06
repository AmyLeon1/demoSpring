package com.example.demoSpring.controllerPackage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

//allow requests from other domains
@CrossOrigin(origins="http://localhost:4200")
@RestController
public class controller {

    @RequestMapping
    public String helloWorld(){
        return "Hello World";
    }

    @RequestMapping(value = "/hello-bean", method = RequestMethod.GET)
    public HelloWorldBean helloWorldBean(){
        return new HelloWorldBean("Hello World Bean - Changed");
    }

    @RequestMapping(value = "/hello-person/path-variable/{name}", method = RequestMethod.GET)
    public HelloWorldBean helloWorldPathVariable(@PathVariable String name){
        //use the name argument
        return new HelloWorldBean(String.format("Hello World, %s", name));
    }


}
