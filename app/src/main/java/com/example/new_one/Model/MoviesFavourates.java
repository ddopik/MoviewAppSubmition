package com.example.new_one.Model;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

/**
 * Created by ddopik_pc on 01/12/2016.
 */

public class MoviesFavourates extends RealmObject {

    @PrimaryKey
    private int Movie_ID;
    @Required
    private Boolean Favourates_Movies;

    private RealmList<Movies> Movie;


    public int getMovie_ID() {
        return Movie_ID;
    }

    public void setMovie_ID(int movie_ID) {
        Movie_ID = movie_ID;
    }

    public Boolean getFavourates_Movies() {
        return Favourates_Movies;
    }

    public void setFavourates_Movies(Boolean favourates_Movies) {
        Favourates_Movies = favourates_Movies;
    }

    public RealmList<Movies> getMovie() {
        return Movie;
    }

    public void setMovie(Movies movie) {
        Movie.add(movie);
    }


}
