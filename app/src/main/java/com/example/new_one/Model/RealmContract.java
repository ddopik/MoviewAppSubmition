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
    public int getLastMovieId() {


        List<Movies> AllMovies = realm.where(Movies.class).findAll().sort("id", Sort.DESCENDING);
        int latestId = AllMovies.get(0).getId();
        return latestId;
    }

    public void setQuery(List<Map<String, String>> jasonItems) {
// Obtain a Realm instance

         int movieId;


        Realm realm = Realm.getDefaultInstance();
//        realm.executeTransaction(new Realm.Transaction() {
//            @Override
//            public void execute(Realm realm) {
//                try {
//
//                    realm.delete(Movies.class);
//                    Log.e("Realm_State","Realm Movies Obj's Deleted");
//                    //Realm file has been deleted.
//                } catch (Exception ex){
//                    Log.e("Realm_State","Realm Movies Obj Deleting crash or no exsiting obj",ex);
//                    //No Realm file to remove.
//                }
//            }
//        });
//
//        try{
//            Log.e("Realm_State --->", "Check for Old Record");
//            movieId=getLastMovieId()+1;
//        }
//        catch(Exception e)
//        {
//            Log.e("Realm_State","No old Record found");
//            movieId=0;
//        }


        int i = 0;
        while (i < jasonItems.size()) {
            Map<String, String> single_row = jasonItems.get(i);
            Movies mv=new Movies();
//            mv.setId(movieId);
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
//            movieId++;





            realm.beginTransaction();
//            Movies RealmMv=realm.copyToRealm(mv);
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
    public void setMoviewTrailerQuery(List <Map<String,String>> trailMovList,int movID)
    {

        try {
            int i = 0;
            while (i < trailMovList.size()) {
                Map<String, String> single_row = trailMovList.get(i);
                MoviesTrailer mvTr = new MoviesTrailer();

                mvTr.setTrailID(single_row.get("id"));
                mvTr.setMovieID(movID);
                mvTr.setMoveName(single_row.get("Movie_Name"));
                mvTr.setTrailKey(single_row.get("key"));
                mvTr.setTrailName(single_row.get("name"));
                i++;

                Realm realm = Realm.getDefaultInstance();
                realm.beginTransaction();
                MoviesTrailer RealmMv = realm.copyToRealmOrUpdate(mvTr);
                Movies mv = realm.where(Movies.class).equalTo("id", movID).findFirst();
                mv.setMoviesTrailer(RealmMv);
                realm.commitTransaction();
                Log.e("Realm --->", "Insert Realm Trailobject");
            }
        }
        catch (RealmException e)
        {
            e.getMessage();
            Log.e("Error_RealmContract","--->setMoviewTRailsQuery",e);
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

    public List<Map<String,String>> getTrailerQuery(int movId)
    {
        Log.e("Realm_State","getting Trailers For Movie");
        Movies mv=realm.where(Movies.class).equalTo("id",movId).findFirst();
        return  mv.getMoviesTrailer();
    }

}
