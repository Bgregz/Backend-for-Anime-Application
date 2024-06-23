package com.AnimeFavorite.demo.anime;

import com.AnimeFavorite.demo.users.Users;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.apache.catalina.User;
@Entity
public class Anime {
    @Id
    @GeneratedValue
    private Integer id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private Users user;
    private String title;
    @Column (length = 2000)
    private String img;
    private String status;
    @Column(length = 7000)
    private String synopsis;
    private Integer episodes;
    private Integer rank;
    private Integer released;
    private Double score;

    public Anime(String title, String img, String status, String synopsis, Integer episodes, Integer rank, Integer released, Double score) {
        this.title = title;
        this.img = img;
        this.status = status;
        this.synopsis = synopsis;
        this.episodes = episodes;
        this.rank = rank;
        this.released = released;
        this.score = score;
    }
    public Anime(){

    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getEpisodes() {
        return episodes;
    }

    public void setEpisodes(Integer episodes) {
        this.episodes = episodes;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public Integer getReleased() {
        return released;
    }

    public void setReleased(Integer released) {
        this.released = released;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Anime{" +
                "id=" + id +
                ", user=" + user +
                ", title='" + title + '\'' +
                ", img='" + img + '\'' +
                ", status='" + status + '\'' +
                ", synopsis='" + synopsis + '\'' +
                ", episodes=" + episodes +
                ", rank=" + rank +
                ", released=" + released +
                ", score=" + score +
                '}';
    }
}
