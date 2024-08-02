package com.ctw.workstation.team.entity;

import com.ctw.workstation.Location;

public class TeamDTO {
    private String name;
    private String product;
    private Location location;

    public TeamDTO(String name, String product, Location location) {
        this.name = name;
        this.product = product;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }
}
