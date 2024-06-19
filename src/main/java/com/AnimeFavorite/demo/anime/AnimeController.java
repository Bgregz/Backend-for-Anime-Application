package com.AnimeFavorite.demo.anime;

import com.AnimeFavorite.demo.HelloWorldBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AnimeController {
    @GetMapping(path = "/anime")
    public String helloWorld(){
        return "Hello World";
    }



    @GetMapping(path = "/anime/bean")
    public HelloWorldBean helloWorldBean(){
        return new HelloWorldBean("Hello World");
    }


}
