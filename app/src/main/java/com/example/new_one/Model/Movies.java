package com.example.new_one.Model;
import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmObject;
import io.realm.annotations.Ignore;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class Movies  extends RealmObject  {


  @PrimaryKey
  private int id;
    @Required
    private String Movie_Name;
    @Required
    private String Movie_Overview;
    @Required
    private String Movie_Img;
    @Ignore
    private String Moview_Year;
    @Ignore
    private float Moview_Rating;
    @Ignore
    private float vote_average;
    @Ignore
    private int vote_count;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMovie_Name() {
        return Movie_Name;
    }

    public void setMovie_Name(String movie_Name) {
        Movie_Name = movie_Name;
    }

    public String getMovie_Overview() {
        return Movie_Overview;
    }

    public void setMovie_Overview(String movie_Overview) {
        Movie_Overview = movie_Overview;
    }

    public String getMovie_Img() {
        return Movie_Img;
    }

    public void setMovie_Img(String movie_Img) {
        Movie_Img = movie_Img;
    }

    public String getMoview_Year() {
        return Moview_Year;
    }

    public void setMoview_Year(String moview_Year) {
        Moview_Year = moview_Year;
    }

    public float getMoview_Rating() {
        return Moview_Rating;
    }

    public void setMoview_Rating(float moview_Rating) {
        Moview_Rating = moview_Rating;
    }

    public float getVote_average() {
        return vote_average;
    }

    public void setVote_average(float vote_average) {
        this.vote_average = vote_average;
    }

    public int getVote_count() {
        return vote_count;
    }

    public void setVote_count(int vote_count) {
        this.vote_count = vote_count;
    }
}
