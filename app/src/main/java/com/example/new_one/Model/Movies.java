package com.example.new_one.Model;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.Ignore;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class Movies extends RealmObject {


    @PrimaryKey
    private int id;
    @Required
    private String Movie_Name;
    @Required
    private String Movie_Overview;
    @Required
    private String Movie_Img;

    private String Moview_Year;

    private float Moview_Rating;
    @Ignore
    private float vote_average;
    @Ignore
    private int vote_count;

    private RealmList<MoviesTrailer> moviesTrailer;
    private RealmList<MoviesReviews> moviesReviews;


    public void setMoviesReviews(List<MoviesReviews> obj) {


        if (moviesReviews.size() == 0) {
            Log.e("Movies_obj-->setMoviesReviews", "Update  ReviewsList current =" + moviesReviews.size());
            for (int i = 0; i < obj.size(); i++)
                moviesReviews.add(obj.get(i));
            Log.e("Movies_obj-->setMoviesReviews", "Insert ReviewObj for firstTime Now size =" + this.moviesReviews.size());

        }
        boolean setFlag=false;
        for (int i = 0; i < obj.size(); i++) {

            for (int y = 0; y < moviesReviews.size(); y++) {
                if (moviesReviews.get(y).getRevId().equals(obj.get(i).getRevId())) {
                    Log.e("Movies_obj-->setMoviesReviews", "RevAlreadyExsist num=" + moviesReviews.size());
                    setFlag=false;
                    break;
                }
                if (setFlag==true) {
                    moviesReviews.add(obj.get(i));
                    setFlag=false;
                    Log.e("Movies_obj-->setMoviesReviews", "Insert ReviewObj Now size =" + this.moviesReviews.size());
                }
            }
        }

    }





    public void setMoviesTrailer(List<MoviesTrailer> obj) {
        if (moviesTrailer.size() == 0) {
            Log.e("Movies_obj-->setMoviesTrailers", "Update  TrailersList current =" + moviesTrailer.size());
            for (int i = 0; i < obj.size(); i++)
                moviesTrailer.add(obj.get(i));
            Log.e("Movies_obj-->setMoviesTrailers", "Insert TrailerObj for firstTime Now size =" + this.moviesTrailer.size());

        }
        boolean setFlag=false;
        for (int i = 0; i < obj.size(); i++) {

            for (int y = 0; y < moviesTrailer.size(); y++) {
                if (moviesTrailer.get(y).getTrailID().equals(obj.get(i).getTrailID())) {
                    Log.e("Movies_obj-->setMoviesReviews", "RevAlreadyExsist num=" + moviesTrailer.size());
                    setFlag=false;
                    break;
                }
                if (setFlag==true) {
                    moviesTrailer.add(obj.get(i));
                    setFlag=false;
                    Log.e("Movies_obj-->setMoviesTrailers", "Insert TrailerObj Now size =" + this.moviesTrailer.size());
                }
            }
        }

    }

    public RealmList<MoviesReviews> getMoviesReviews() {
        return moviesReviews;
    }

    public RealmList<MoviesTrailer>  getMoviesTrailer() {
        return moviesTrailer;
    }


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


//        List<MoviesReviews> myLocalList = getMoviesReviews();
//        Log.e("Movies_Realm_numebOfLocalReviewsBefore --->", Integer.toString(getMoviesReviews().size()));
//        if (myLocalList.size() == 0) {
//            getMoviesReviews().add(obj);
//            Log.e("Realm_state@2--->", "Insert Realm Revobject");
//        } else {
//
//            for (int i = 0; i < myLocalList.size(); i++) {
//                Log.e("Realm --->", "OldReviewsFound-->ReviewLoopStart");
//                if (!myLocalList.get(i).getRevId().equals(obj.getRevId())) {
//                    getMoviesReviews().add(obj);
//                    Log.e("(if)Realm --->", "Insert Realm Revobject");
//                } else {
//                    Log.e("Movies_Realm_ReviewObj --->", "AlreadyExsists");
//                }
//
//                Log.e("Movies_Realm_numebof ReviewsAfter  --->", Integer.toString(getMoviesReviews().size()));
//            }
//        }