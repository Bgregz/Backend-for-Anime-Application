package com.AnimeFavorite.demo.users;


import com.AnimeFavorite.demo.anime.Anime;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import java.util.Optional;


@RestController

public class UserJPAResource {
    @Autowired
    private final UserRepository userrepository;

    private final Logger logger = LoggerFactory.getLogger(UserJPAResource.class);

    public UserJPAResource(UserRepository repository) {
        this.userrepository = repository;

    }


    @PostMapping(path = "/jpa/users")
    @Transactional
    public ResponseEntity<Users> retrieveUser(@RequestBody Users user) {
        String userName = user.getUsername();
        String password = user.getPassword();
        logger.info("we getting it");
        Optional<Users> foundUser = userrepository.findByUsername(userName);

        if (foundUser.isPresent() && foundUser.get().getPassword().equals(password)) {
            return ResponseEntity.ok(foundUser.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @PostMapping(path = "/jpa/users/signup")
    @Transactional
    public ResponseEntity<?> createUser(@RequestBody Users user) {
        String userName = user.getUsername();
        Optional<Users> userExists = userrepository.findByUsername(userName);
        if (userExists.isEmpty()) {
           Users savedUser = userrepository.save(user);
            return ResponseEntity.ok(savedUser);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Username already taken");
        }
    }

    @GetMapping(path = "/jpa/users/{username}/anime")
    @Transactional
    public ResponseEntity<List<Anime>> retrieveFavorites(@PathVariable String username) {
        Optional<Users> user = userrepository.findByUsername(username);
        if (user.isPresent()) {
            return ResponseEntity.ok(user.get().getAnime());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping(path = "/jpa/users/{username}/anime")
    @Transactional
    public ResponseEntity<String> createFavorites(@RequestBody Anime anime, @PathVariable String username) {
        logger.info("Trying to post anime = {}", anime);

        Optional<Users> userOptional = userrepository.findByUsername(username);
        if (userOptional.isPresent()) {
            logger.info("This user is present");
            Users user = userOptional.get();

            // Check if the anime already exists in the user's favorites
            boolean animeExists = user.getAnime().stream().anyMatch(a -> a.getTitle().equals(anime.getTitle()));
            if (animeExists) {
                return ResponseEntity.badRequest().body("Anime already added to favorites");
            }
logger.info("creating anime");
            // Associate the anime with the user
            anime.setUser(user);

            // Add the anime to the user's list of favorites
            user.getAnime().add(anime);


            return ResponseEntity.ok("Anime added to favorites successfully");
        }

        // If user not found, return 404 Not Found
        return ResponseEntity.notFound().build();
    }




}

