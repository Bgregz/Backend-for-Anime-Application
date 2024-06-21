package com.AnimeFavorite.demo.users;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;


@RestController

public class UserResource {
    @Autowired
    private final UserDAOService service;
    private final Logger logger = LoggerFactory.getLogger(UserResource.class);

    public UserResource(UserDAOService service) {
        this.service = service;
    }

    @GetMapping(path = "/users")
    public ResponseEntity<Users> retrieveUser(@RequestBody Users user) {
        Optional<Users> foundUser = service.findUser(user);
        if (foundUser.isPresent()) {
            return ResponseEntity.ok(foundUser.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @PostMapping(path = "/users")
    public ResponseEntity<String> inputUser(@RequestBody Users user) {
        logger.info("This user sent ={} ", user);
        Boolean userCreated = service.newUser(user);
        if (userCreated) {
           return  ResponseEntity.ok("User Created");
        } else {
           return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Username taken");
        }
    }
}

