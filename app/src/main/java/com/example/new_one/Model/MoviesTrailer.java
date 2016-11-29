package com.example.new_one.Model;

import io.realm.Realm;
import io.realm.RealmObject;
import io.realm.annotations.Ignore;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

/**
 * Created by ddopik on 27/11/2016.
 */

public class MoviesTrailer extends RealmObject{
    @PrimaryKey
    private String trailID;
    @Required
    private String trailKey;
    @Required
    private String trailName ;
    private int movieID;
    @Ignore
    private String moveName;

    public String getTrailID() {
        return trailID;
    }

    public void setTrailID(String trailID) {
        this.trailID = trailID;
    }

    public String getTrailKey() {
        return trailKey;
    }

    public void setTrailKey(String trailKey) {
        this.trailKey = trailKey;
    }

    public String getTrailName() {
        return trailName;
    }

    public void setTrailName(String trailName) {
        this.trailName = trailName;
    }

    public String getMoveName() {
        return moveName;
    }

    public void setMoveName(String moveName) {
        this.moveName = moveName;
    }
    public int getMovieID() {
        return movieID;
    }

    public void setMovieID(int movieID) {
        this.movieID = movieID;
    }
}
