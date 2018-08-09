package com.example.firebasedemo;

public class Movie {
    private int id;
    public String title;

    public Movie(int id, String title) {

        this.id = id;
        this.title = title;
    }

    public Movie() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


}
