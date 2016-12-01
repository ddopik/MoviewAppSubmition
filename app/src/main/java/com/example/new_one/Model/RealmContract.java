package com.example.new_one.Model;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.realm.Realm;
import io.realm.RealmCollection;
import io.realm.RealmList;
import io.realm.RealmResults;
import io.realm.Sort;
import io.realm.exceptions.RealmException;

import static android.R.id.list;
import static java.util.Collections.addAll;

/**
 * Created by ddopik on 08/11/2016.
 */

public class RealmContract {

    private Realm realm;


    public RealmContract() {

        realm = Realm.getDefaultInstance();
        Log.e("Realm --->", "RealmContract called");

    }


    public Movies getSingleMovie(int movieID) {
        return realm.where(Movies.class).equalTo("id", movieID).findFirst();
    }

    public String setMoviewToFav(int movieID) {

        MoviesFavourates movFav = realm.where(MoviesFavourates.class).equalTo("Movie_ID", movieID).findFirst();
        if (!movFav.getFavourates_Movies()) {
            realm.beginTransaction();
            movFav.setFavourates_Movies(true);
            realm.commitTransaction();
            return "Added to favorites";///Moview became in fav
        } else {
            realm.beginTransaction();
            movFav.setFavourates_Movies(false);
            realm.commitTransaction();
            return "Removed from favorites"; ///Moview removed from fav
        }

    }

    public void setQuery(List<Map<String, String>> jasonItems, String listType) {
        Realm realm = Realm.getDefaultInstance();
        int i = 0;
        while (i < jasonItems.size()) {
            Map<String, String> single_row = jasonItems.get(i);
            Movies mv = new Movies();

            int mdbId = Integer.parseInt(single_row.get("id"));
            mv.setId(mdbId);
            mv.setMovie_Name(single_row.get("Movie_Name"));
            mv.setMovie_Overview(single_row.get("Movie_Overview"));
            mv.setMovie_Img(single_row.get("Movie_Img"));
            mv.setMoview_Year(single_row.get("Moview_year"));
            mv.setMovie_Type(listType);
            String ratting = single_row.get("Moview_Rating");
            float rattingNumber = (float) Float.parseFloat(ratting);
            mv.setMoview_Rating(rattingNumber);


            i++;

            realm.beginTransaction();
            Movies RealmMv = realm.copyToRealmOrUpdate(mv);
            realm.commitTransaction();


            try {
                MoviesFavourates movFav = new MoviesFavourates();
                    movFav.setMovie_ID(mv.getId());
                    movFav.setMovie(mv);
                    realm.copyToRealm(movFav);

            } catch(Exception e) {
                Log.e("Realm --->", "this Movie Might be Exsists",e);
            }

            Log.e("Realm --->", "Insert Realm object");

        }

    }

    public int getMovieInfoQuery(int mvID) {
        Movies mv = realm.where(Movies.class).equalTo("id", mvID).findFirst();
        return mv.getMovieDuration();
    }


    public RealmList<Movies> getQuery(String ListType) {
        Log.e("Realm --->", "Get Realm query Start");
        List<Map<String, String>> jasonApiItems = new ArrayList<Map<String, String>>();
        if (ListType.equals("Fav")) {
              RealmResults<MoviesFavourates> favList = realm.where(MoviesFavourates.class).equalTo("Movie_ID", true).findAll();/////error
              RealmList<Movies> mvList2=new RealmList<Movies>();

            for(MoviesFavourates favMov:favList)
            {
                mvList2.add(favMov.getMovie().get(0));
            }
            return  mvList2;
        }
        else
        {
            RealmResults<Movies>mvRealmList = realm.where(Movies.class).equalTo("Movie_Type", ListType).findAll();
            RealmList<Movies> mvList=new RealmList<Movies>();
            for(Movies mv:mvRealmList)
            {
                mvList.add(mv);
            }
            return mvList;
        }





    }

    public void setMoviewReviewsQuery(List<Map<String, String>> revMovList, int movID) {


        try {
            int i = 0;
            List<MoviesReviews> revCashList = new ArrayList<MoviesReviews>();

            while (i < revMovList.size()) {
                Map<String, String> single_row = revMovList.get(i);
                MoviesReviews mvR = new MoviesReviews();

                mvR.setMovieID(movID);
                mvR.setMoveName(single_row.get("Movie_Name"));
                mvR.setRevId(single_row.get("id"));
                mvR.setAuthor(single_row.get("author"));
                mvR.setContent(single_row.get("content"));
                i++;
                revCashList.add(mvR);
            }

            Movies mv = realm.where(Movies.class).equalTo("id", movID).findFirst();
            Realm realm = Realm.getDefaultInstance();
            realm.beginTransaction();
            realm.copyToRealmOrUpdate(revCashList);
            mv.setMoviesReviews(revCashList);
            realm.commitTransaction();
            ///////
        } catch (RealmException e) {
            e.getMessage();
            Log.e("Error_RealmContract", "--->setMoviewReviewsQuery", e);
        }
    }

    public RealmList<MoviesReviews> getRevQuery(int movId) {

        Log.e("Realm_State", "getting RevFor Movie");
        Movies mv = realm.where(Movies.class).equalTo("id", movId).findFirst();

        return mv.getMoviesReviews();
    }

    public RealmList<MoviesTrailer> getTrailQuery(int movId) {

        Log.e("Realm_State", "getting Trailers For Movie");
        Movies mv = realm.where(Movies.class).equalTo("id", movId).findFirst();

        return mv.getMoviesTrailer();
    }

    public void setMoviewTrailerQuery(List<Map<String, String>> trailMvList, int movID) {


        List<MoviesTrailer> realmRevObjcts;
        try {
            int i = 0;
            List<MoviesTrailer> trailCashList = new ArrayList<MoviesTrailer>();

            while (i < trailMvList.size()) {
                Map<String, String> single_row = trailMvList.get(i);
                MoviesTrailer mvT = new MoviesTrailer();

                mvT.setMovieID(movID);
                mvT.setTrailID(single_row.get("id"));
                mvT.setTrailKey(single_row.get("key"));
                mvT.setTrailName(single_row.get("name"));

                i++;
                trailCashList.add(mvT);
            }

            Realm realm = Realm.getDefaultInstance();
            realm.beginTransaction();
            Movies mv = realm.where(Movies.class).equalTo("id", movID).findFirst();
            realmRevObjcts = realm.copyToRealmOrUpdate(trailCashList);
            //////
            mv.setMoviesTrailer(trailCashList);
            realm.commitTransaction();
            ///////
        } catch (RealmException e) {
            e.getMessage();
            Log.e("Error_RealmContract", "--->setMoviewReviewsQuery", e);
        }


    }


    public void setMoviewInfoQuery(List<Map<String, String>> getMovieInfoData, int mvID) {

        Map<String, String> singleRow = getMovieInfoData.get(0);
        final int runnTime = Integer.parseInt(singleRow.get("runtime"));
        final Movies mv = realm.where(Movies.class).equalTo("id", mvID).findFirst();
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                mv.setMovieDuration(runnTime);
            }
        });

    }


}
