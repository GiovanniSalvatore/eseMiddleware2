package co.develhope.interceptorsmiddleware2.controllers;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@Component
@RestController
@RequestMapping("")
public class BasicController {
    @GetMapping
    public String sayHello(){
        return "Hello!!";
    }
}