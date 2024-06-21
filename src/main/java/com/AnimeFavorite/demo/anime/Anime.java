package com.AnimeFavorite.demo.anime;

public class Anime {
    private String title;
    private String img;
    private String status;
    private String summary;
    private Integer episodes;
    private Integer rank;
    private Integer released;
    private Double score;

    public Anime(String title, String img, String status, String summary, Integer episodes, Integer rank, Integer released, Double score) {
        this.title = title;
        this.img = img;
        this.status = status;
        this.summary = summary;
        this.episodes = episodes;
        this.rank = rank;
        this.released = released;
        this.score = score;
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

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
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

//    @Override
//    public String toString() {
//        return "Anime{" +
//                "title='" + title + '\'' +
//                ", img='" + img + '\'' +
//                ", status='" + status + '\'' +
//                ", summary='" + summary + '\'' +
//                ", episodes=" + episodes +
//                ", rank=" + rank +
//                ", released=" + released +
//                ", score=" + score +
//                '}';
//    }
}