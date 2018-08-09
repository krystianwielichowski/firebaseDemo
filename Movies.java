package com.example.firebasedemo;

import java.util.ArrayList;

public class Movies {
    private ArrayList<Movie> movies;

    public Movies() {
        this.movies = new ArrayList<>();
    }
    public Movies(ArrayList<Movie> movies) {
        this.movies = movies;
    }

    public void setMovies(ArrayList<Movie> movies) {
        this.movies = movies;
    }

    public ArrayList<Movie> getMovies() {
        return movies;
    }

    public Movie getMovie(int i){
        return movies.get(i);
    }

    public void addMovie(Movie movie){
        movies.add(movie);
    }

    public Movie getMovieByID(int id){
        for(Movie movie : movies){
            if(movie.getId() == id){
                return movie;
            }
        }
        return  null;
    }
}
