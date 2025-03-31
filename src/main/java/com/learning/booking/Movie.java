package com.learning.booking;

import java.util.Date;

public class Movie {
    private String title;
    private String genre;
    private Date releaseDate;
    private String language;
    private int duration;

    public Movie(String title, String genre, Date releaseDate, String language, int duration) {
        this.title = title;
        this.genre = genre;
        this.releaseDate = releaseDate;
        this.language = language;
        this.duration = duration;
    }

    public String getTitle() { return title; }
    public String getGenre() { return genre; }
    public Date getReleaseDate() { return releaseDate; }
    public String getLanguage() { return language; }
    public int getDuration() { return duration; }

    @Override
    public String toString() {
        return "Movie: " + title + " (" + genre + ", " + language + ")";
    }
}
