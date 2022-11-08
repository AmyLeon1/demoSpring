package com.example.demoSpring.controllerPackage;

import org.springframework.web.bind.annotation.*;

//allow requests from other domains
@CrossOrigin(origins="http://localhost:4200")
@RestController
public class HelloWorldController {

    @RequestMapping
    public String helloWorld(){
        return "Hello World";
    }

    @RequestMapping(value = "/hello-bean", method = RequestMethod.GET)
    public AuthenticationBean helloWorldBean(){

        return new AuthenticationBean("You have been authenticated");
    }

    @RequestMapping(value = "/hello-person/path-variable/{name}", method = RequestMethod.GET)
    public AuthenticationBean helloWorldPathVariable(@PathVariable String name){
        //use the name argument
        return new AuthenticationBean(String.format("Hello World, %s", name));
    }


}
