package com.learning.booking;

public abstract class CinemaComponent {
    private String name;
    private String location;
    private String id;

    public CinemaComponent(String name, String location, String id) {
        this.name = name;
        this.location = location;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public String getId() {
        return id;
    }

    public abstract void displayInfo();
}
