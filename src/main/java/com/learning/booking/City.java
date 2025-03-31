package com.learning.booking;

import java.util.ArrayList;
import java.util.List;

public class City {
    private String name;
    private List<CinemaComponent> cinemaComponentList;

    public City(String name) {
        this.name = name;
        this.cinemaComponentList = new ArrayList<>();
    }

    public boolean add(CinemaComponent cinemaComponent) {
        if (!cinemaComponentList.contains(cinemaComponent)) {
            cinemaComponentList.add(cinemaComponent);
            return true;
        }
        return false;
    }

    public boolean remove(CinemaComponent cinemaComponent) {
        return cinemaComponentList.remove(cinemaComponent);
    }

    public List<CinemaComponent> getCinemaComponentList() {
        return cinemaComponentList;
    }

    public String getName() {
        return name;
    }

    public void displayAllComponents() {
        System.out.println("City: " + name);
        System.out.println("Total Components: " + cinemaComponentList.size());
        System.out.println("\nComponents:");
        for (CinemaComponent component : cinemaComponentList) {
            component.displayInfo();
        }
    }

    public CinemaComponent getComponentById(String id) {
        for (CinemaComponent component : cinemaComponentList) {
            if (component.getId().equals(id)) {
                return component;
            }
        }
        return null;
    }
}
