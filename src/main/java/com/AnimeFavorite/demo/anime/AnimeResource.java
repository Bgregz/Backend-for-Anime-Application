package com.AnimeFavorite.demo.anime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AnimeResource {
    @Autowired
    private final AnimeDAOService service;
   private final Logger logger = LoggerFactory.getLogger(AnimeResource.class);


    public AnimeResource(AnimeDAOService service){
        this.service = service;
    }


@GetMapping(path = "/animeList")
    public List <Anime> retrieveAllAnime(){
     return service.findAll();
    };
@PostMapping(path = "/animeList")
    public ResponseEntity<Anime> createAnime(@RequestBody Anime anime){
   service.save(anime);

    return ResponseEntity.created(null).build();
}

@DeleteMapping(path = "/animeList")
 public ResponseEntity<String> deleteAnime(@RequestBody Anime animeName){
    String name = animeName.getTitle();
    logger.info("I am sending name variable = {}", name);
    boolean deleted = service.delete(name);
    if(deleted) {
        return ResponseEntity.ok("Anime deleted successfully");
    } else{
        return ResponseEntity.notFound().header("Error", "Anime" + name + "not found" ).build();
    }
}


}
