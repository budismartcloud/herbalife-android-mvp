package com.example.user.herbalifemvp.datasource.models;

/**
 * Created by User on 5/20/2018.
 */

public class Disease {
    String name;
    String bahan;
    String tutorial;

    public String getBahan() {
        return bahan;
    }

    public String getName() {
        return name;
    }

    public String getTutorial() {
        return tutorial;
    }

    public void setBahan(String bahan) {
        this.bahan = bahan;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTutorial(String tutorial) {
        this.tutorial = tutorial;
    }
}
