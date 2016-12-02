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
import io.realm.RealmConfiguration;
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

static {

}
    public RealmContract(Context context) {
        Realm.init(context);
        RealmConfiguration realmConfig = new RealmConfiguration.Builder().build();
        Realm.setDefaultConfiguration(realmConfig);

        realm = Realm.getDefaultInstance();
        Log.e("Realm --->", "RealmContract called");

    }


    public Movies getSingleMovie(int movieID) {
        return realm.where(Movies.class).equalTo("id", movieID).findFirst();
    }

    public String setMoviewToFav(int movieID) {

        Movies movFav = realm.where(Movies.class).equalTo("id", movieID).findFirst();
        if (!movFav.isFavorate_Movie()) {
            realm.beginTransaction();
            movFav.setFavorate_Movie(true);
            realm.commitTransaction();
            return "Added to favorites";///Moview became in fav
        } else {
            realm.beginTransaction();
            movFav.setFavorate_Movie(false);
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
            try {
                Movies mvOld=realm.where(Movies.class).equalTo("id",mdbId).findFirst();
                mv.setFavorate_Movie(mvOld.isFavorate_Movie());
            }
            catch(Exception e)
            {
                Log.e("RealmContract--->SetQuery","Movies have't yet Added");
            }



            i++;

            realm.beginTransaction();
            Movies RealmMv = realm.copyToRealmOrUpdate(mv);
            realm.commitTransaction();




        }
    }

    public int getMovieInfoQuery(int mvID) {
        Movies mv = realm.where(Movies.class).equalTo("id", mvID).findFirst();
        return mv.getMovieDuration();
    }


    public RealmResults<Movies> getQuery(String ListType) {
        Log.e("Realm --->", "Get Realm query Start");
        List<Map<String, String>> jasonApiItems = new ArrayList<Map<String, String>>();
        RealmResults<Movies> mv;

        if (ListType.equals("Fav")) {
            mv = realm.where(Movies.class).equalTo("Favorate_Movie",true).findAll();
        }
         else {
            mv = realm.where(Movies.class).equalTo("Movie_Type",ListType).findAll();
        }

        return mv;

    }
    public int getDefaultMovie(String listType)
    {
        if(listType.equals("Favourates"))
        {
            Movies mv=realm.where(Movies.class).equalTo("Favorate_Movie",true).findFirst();
            return mv.getId();
        }else {
            Movies mv = realm.where(Movies.class).equalTo("Movie_Type", listType).findFirst();
            return mv.getId();
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
