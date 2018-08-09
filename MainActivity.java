package com.example.firebasedemo;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;


public class MainActivity extends AppCompatActivity {
    private Movies movies;
    private ListView list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        movies = new Movies();

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addMovie();
            }
        });

        list = findViewById(R.id.listView);
        refreshMoviesList();
    }

    private void addMovie(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Dodaj film");

        View viewInflated = LayoutInflater.from(this).inflate(R.layout.movie_add, null);

        // Zapamietujemy nasze pola
        final EditText movieIDInput = (EditText) viewInflated.findViewById(R.id.movieID);
        final EditText movieTitleInput = (EditText) viewInflated.findViewById(R.id.movie_title);

        // Ustawiamy widok do buildera
        builder.setView(viewInflated);

        // Callback'i dla przycisków
        builder.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();

                int id = Integer.parseInt(movieIDInput.getText().toString());
                String title = movieTitleInput.getText().toString();

                movies.addMovie(new Movie(id, title));
                refreshMoviesList();
            }
        });
        builder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        builder.show();
    }

    private void refreshMoviesList(){
        MovieAdapter adapter = new MovieAdapter(movies.getMovies(),this);
        list.setAdapter(adapter);
    }


}
