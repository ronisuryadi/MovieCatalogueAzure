package com.ronisuryadi.moviecatalogue.data;

public class MovieEntity {
    private int id;
    private String name;
    private String description;
    private String genre;
    private String release;
    private int rating;
    private int photo;

    public MovieEntity(int id, String name, String description, String genre, String release, int rating, int photo) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.genre = genre;
        this.release = release;
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

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }
}
