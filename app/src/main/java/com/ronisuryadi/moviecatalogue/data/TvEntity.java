package com.ronisuryadi.moviecatalogue.data;

public class TvEntity {
    private int id;
    private String name;
    private String description;
    private String genre;
    private String release;
    private String episode;
    private double rating;
    private int photo;

    public TvEntity(int id, String name, String description, String genre, String release, String episode, double rating, int photo) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.genre = genre;
        this.release = release;
        this.episode = episode;
        this.rating = rating;
        this.photo = photo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getRelease() {
        return release;
    }

    public void setRelease(String release) {
        this.release = release;
    }

    public String getEpisode() {
        return episode;
    }

    public void setEpisode(String episode) {
        this.episode = episode;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }
}
