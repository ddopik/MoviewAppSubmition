package com.example.new_one.Model;

import io.realm.Realm;
import io.realm.RealmObject;
import io.realm.annotations.Ignore;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

/**
 * Created by ddopik on 27/11/2016.
 */

public class MoviesReviews extends RealmObject{
    @PrimaryKey
    private String revId;
    @Required
    private String author;
    @Required
    private String content;
    private int movieID;
    @Ignore
    private String moveName;
    public String getRevId() {
        return revId;
    }



    public void setRevId(String revId) {
        this.revId = revId;
    }
    public int getMovieID() {
        return movieID;
    }

    public void setMovieID(int movieID) {
        this.movieID = movieID;
    }
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getMoveName() {
        return moveName;
    }

    public void setMoveName(String moveName) {
        this.moveName = moveName;
    }
}
