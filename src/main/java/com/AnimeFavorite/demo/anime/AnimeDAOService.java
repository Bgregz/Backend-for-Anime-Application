package com.AnimeFavorite.demo.anime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AnimeDAOService {
    Logger logger = LoggerFactory.getLogger(AnimeDAOService.class);
    private static List<Anime> animes = new ArrayList<>();

    static {
        animes.add(new Anime("Fullmetal Alchemist: Brotherhood", "www.hello.com", "Airing", "Two brothers adventure",
                24, 3, 2016, 9.08));
    }

    public List<Anime> findAll(){
        return animes;
    }

    public Anime save(Anime anime){
     animes.add(anime);
     return anime;
    };

    public boolean delete(String name){
        logger.info("In my delete method the string name is, {}",name);
        for (int i=0; i< animes.size(); i++){
            Anime currentAnime = animes.get(i);
            logger.info("Checking against anime title: '{}'", currentAnime.getTitle());
            if(currentAnime.getTitle().equals(name)){
                animes.remove(i);
                return true;
            }

        }
        return false;
    };

}
