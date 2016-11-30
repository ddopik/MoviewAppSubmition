package com.example.new_one.Model;

import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.realm.Realm;
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
    private String jasonString;

    public RealmContract() {

        realm = Realm.getDefaultInstance();

        Log.e("Realm --->", "RealmContract called");

    }


    public void setQuery(List<Map<String, String>> jasonItems) {
        Realm realm = Realm.getDefaultInstance();
        int i = 0;
        while (i < jasonItems.size()) {
            Map<String, String> single_row = jasonItems.get(i);
            Movies mv=new Movies();
            int mdbId=Integer.parseInt(single_row.get("id"));
            mv.setId(mdbId);
            mv.setMovie_Name(single_row.get("Movie_Name"));
            mv.setMovie_Overview(single_row.get("Movie_Overview"));
            mv.setMovie_Img(single_row.get("Movie_Img"));
            mv.setMoview_Year(single_row.get("Moview_year"));
            String ratting=single_row.get("Moview_Rating");
            float rattingNumber=(float) Float.parseFloat(ratting);
            mv.setMoview_Rating(rattingNumber);
            i++;

            realm.beginTransaction();

            Movies RealmMv=realm.copyToRealmOrUpdate(mv);
            realm.commitTransaction();
            Log.e("Realm --->", "Insert Realm object");

        }
    }
    public void setMoviewReviewsQuery(List <Map<String,String>> revMovList,int movID)
    {

        List<MoviesReviews> realmRevObjcts;
        try {
            int i = 0;
            List<MoviesReviews> revCashList=new ArrayList<MoviesReviews>();

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

            Realm realm = Realm.getDefaultInstance();
                realm.beginTransaction();
                Movies mv = realm.where(Movies.class).equalTo("id", movID).findFirst();
                realmRevObjcts = realm.copyToRealmOrUpdate(revCashList);
            //////
                mv.setMoviesReviews(revCashList);
                realm.commitTransaction();
            ///////
        }
        catch (RealmException e)
        {
            e.getMessage();
            Log.e("Error_RealmContract","--->setMoviewReviewsQuery",e);
        }
    }

    public RealmList<MoviesReviews> getRevQuery(int movId)
    {

        Log.e("Realm_State","getting RevFor Movie");
        Movies mv=realm.where(Movies.class).equalTo("id",movId).findFirst();

        return  mv.getMoviesReviews();
    }
    public RealmList<MoviesTrailer> getTrailQuery(int movId)
    {

        Log.e("Realm_State","getting Trailers For Movie");
        Movies mv=realm.where(Movies.class).equalTo("id",movId).findFirst();

        return  mv.getMoviesTrailer();
    }

    public void setMoviewTrailerQuery(List <Map<String,String>> trailMvList,int movID)
    {


        List<MoviesTrailer> realmRevObjcts;
        try {
            int i = 0;
            List<MoviesTrailer> trailCashList=new ArrayList<MoviesTrailer>();

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
        }
        catch (RealmException e)
        {
            e.getMessage();
            Log.e("Error_RealmContract","--->setMoviewReviewsQuery",e);
        }


    }

    public List getQuery() {
        Log.e("Realm --->", "Get Realm query Start");
        List<Map<String,String>> jasonApiItems=new ArrayList<Map<String,String>>();
        int i = 0;
        RealmResults<Movies> mv = realm.where(Movies.class).findAll();
        for (i = 0; i < mv.size(); i++) {

            ////////////// if you wan't  to use map
            Map<String,String> mapData = new HashMap<String,String>();
            mapData.put("id",Integer.toString(mv.get(i).getId()));
            mapData.put("Movie_Img",mv.get(i).getMovie_Img());
            mapData.put("Movie_Overview",mv.get(i).getMovie_Overview());
            mapData.put("Movie_Name",mv.get(i).getMovie_Name());
            mapData.put("Moview_Rating",Float.toString(mv.get(i).getMoview_Rating()));
            mapData.put("Moview_year",mv.get(i).getMoview_Year());
            jasonApiItems.add(i,mapData);
            //Log.e("Real VAlue --->", mv.get(i).getMovie_Img());
           // Toast.makeText(ac, +i + "--" + "values-->" + mv.get(i).getId(), Toast.LENGTH_SHORT).show();
        }

             return jasonApiItems;

    }



}
