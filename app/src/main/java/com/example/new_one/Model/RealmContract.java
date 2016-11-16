package com.example.new_one.Model;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.new_one.MainActivity;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmObject;
import io.realm.RealmResults;
import io.realm.Sort;
import io.realm.annotations.Ignore;
import io.realm.annotations.PrimaryKey;
import io.realm.internal.Context;
import io.realm.internal.IOException;

import static android.R.id.list;

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
// Obtain a Realm instance

         int movieId;
        Log.e("Realm --->", "Insert Realm object");
        try{
            movieId=getLastMovieId()+1;
        }
        catch(Exception e)
        {
            Log.e("Realm_State","No old Record found");
             movieId=0;
        }
        int i = 0;
        while (i < jasonItems.size()) {
            Map<String, String> single_row = jasonItems.get(i);
            Movies mv=new Movies();
            mv.setId(movieId);
            mv.setMovie_Name(single_row.get("Movie_Name"));
            mv.setMovie_Overview(single_row.get("Movie_Overview"));
            mv.setMovie_Img(single_row.get("Movie_Img"));
            mv.setMoview_Year(single_row.get("Moview_year"));
            String ratting=single_row.get("Moview_Rating");
            float rattingNumber=Integer.parseInt(ratting);
            mv.setMoview_Rating(rattingNumber);
            i++;
            movieId++;

            Realm realm = Realm.getDefaultInstance();
            realm.beginTransaction();
            Movies RealmMv=realm.copyToRealm(mv);
            realm.commitTransaction();


        }


//        User realmUser = realm.copyToRealm(user);

    }


    public int getLastMovieId() {


        List<Movies> AllMovies = realm.where(Movies.class).findAll().sort("id", Sort.DESCENDING);
        int latestId = AllMovies.get(0).getId();
        return latestId;
    }








    public List getQuery() {
        Log.e("Realm --->", "Get Realm query");
        List<Map<String,String>> jasonApiItems=new ArrayList<Map<String,String>>();
        int i = 0;
        RealmResults<Movies> mv = realm.where(Movies.class).findAll();
        for (i = 0; i < mv.size(); i++) {

            ////////////// if you wan't  to use map
            Map<String,String> mapData = new HashMap<String,String>();
            mapData.put("id",i+" ");
            mapData.put("Movie_Img",mv.get(i).getMovie_Img());
            mapData.put("Movie_Overview",mv.get(i).getMovie_Overview());
            mapData.put("Movie_Name",mv.get(i).getMovie_Name());
            mapData.put("Moview_Rating",mv.get(i).getMoview_Rating()+"");
            jasonApiItems.add(i,mapData);
            Log.e("Real VAlue --->", mv.get(i).getMovie_Img());
           // Toast.makeText(ac, +i + "--" + "values-->" + mv.get(i).getId(), Toast.LENGTH_SHORT).show();

        }

             return jasonApiItems;

    }

}
