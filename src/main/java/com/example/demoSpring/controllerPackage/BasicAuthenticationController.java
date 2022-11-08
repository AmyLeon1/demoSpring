package com.example.demoSpring.controllerPackage;

import org.springframework.web.bind.annotation.*;

//allow requests from other domains
@CrossOrigin(origins="http://localhost:4200")
@RestController
public class BasicAuthenticationController {



    @RequestMapping(value = "/basicauth", method = RequestMethod.GET)
    public AuthenticationBean helloWorldBean(){
        return new AuthenticationBean("You are authenticated");
    }
}
