package com.example.uts_recyclerview.model;

public class Logo {
    private  String logo;
    private  String name;

    public Logo(String logo, String name) {
        this.logo = logo;
        this.name = name;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
