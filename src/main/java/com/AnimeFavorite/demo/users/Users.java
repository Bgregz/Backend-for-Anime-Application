package com.AnimeFavorite.demo.users;

import com.AnimeFavorite.demo.anime.Anime;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity(name = "user_information")
public class Users {
    @Id
    @GeneratedValue
    private Integer id;
    private String username;
    private String password;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Anime> anime;


    public Users(){

    }
    public Users(String username, String password){
        this.username = username;
        this.password = password;
    }

    public String getUsername(){
        return username;
    }
    public String getPassword(){
        return password;
    }

    public List<Anime> getAnime() {
        return anime;
    }

    public void setAnime(List<Anime> anime) {
        this.anime = anime;
    }

    public void setPassword(String password){
        this.password = password;
    }
    public void setUsername(String username){
        this.username = username;
    }


    @Override
    public String toString() {
        return "Users{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
