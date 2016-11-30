package com.example.new_one.HelperClasses;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.GridView;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.new_one.Controller_interfacer.SingleMoviewReviewsDialogtListner;
import com.example.new_one.Controller_interfacer.SingleMoviewTrailerDialogListner;
import com.example.new_one.Controller_interfacer.VollyAdapter;
import com.example.new_one.Model.RealmContract;
import com.example.new_one.R;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class VollyJasonParser {

    GridView movieGridView;
    ListView movieListView;
    Bundle viewType;
    RequestQueue requestQueue;
    String JsonObjURL;
    Activity myActivity;
    String imgUrl;


    List<Map<String, String>> listMapData = new ArrayList<Map<String, String>>();
    List<Map<String, String>> listDialogData = new ArrayList<Map<String, String>>();
    List<Map<String, String>> listTrailData = new ArrayList<Map<String, String>>();
    private VollyAdapter vollyAdapter;
    private SingleMoviewReviewsDialogtListner reviewsDialogtListner;
    private SingleMoviewTrailerDialogListner trailerDialogtListner;

    public VollyJasonParser(Activity act) {
        requestQueue = Volley.newRequestQueue(act);
    }///constructor for ReviewList/TrailerRequest

    public VollyJasonParser(Activity act, View fragmentView, Bundle SharedPrefViewType, String url) {

        requestQueue = Volley.newRequestQueue(act);
        JsonObjURL = url;
        myActivity = act;
        viewType = SharedPrefViewType;
        movieGridView = (GridView) fragmentView.findViewById(R.id.gridList);
        movieListView = (ListView) fragmentView.findViewById(R.id.movieList);
    }///constructor for MainList


    /**
     * Method to make json object request where json response starts wtih {
     */
    public List makeJsonObjectRequest() {


        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.GET, JsonObjURL, null,
                new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject JSONObjectResponse) {
                        Log.e("Movielist_Request_srart", JSONObjectResponse.toString());
                        try {
                            JSONArray jasonListArray = JSONObjectResponse.optJSONArray("results");
                            for (int i = 0; i < jasonListArray.length(); i++) {
                                String id = jasonListArray.optJSONObject(i).getString("id");
                                String poster_path = jasonListArray.optJSONObject(i).getString("poster_path");
                                String imgUrl = "http://image.tmdb.org/t/p/w185" + poster_path;
                                String overview = jasonListArray.optJSONObject(i).getString("overview");
                                String releasDate = jasonListArray.optJSONObject(i).getString("release_date");
                                String original_title = jasonListArray.optJSONObject(i).getString("original_title");
                                double voteAverage = jasonListArray.optJSONObject(i).getDouble("vote_average");

                                ////////////// if you wan't  to use map
                                Map<String, String> mapData = new HashMap<String, String>();
                                //  String ii=Integer.toString(i);
                                mapData.put("id", id);
                                mapData.put("Movie_Img", imgUrl);
                                mapData.put("Movie_Overview", overview);
                                mapData.put("Movie_Name", original_title);
                                mapData.put("Moview_year", releasDate);
                                mapData.put("Moview_Rating", Double.toString(voteAverage));
                                listMapData.add(i, mapData);

                                ///how you get data..
                                ///->listMapData.get(0).get("name");
                                /////////////

                            }

                            ///////using Realm DB
                            //Realm  realm = Realm.getDefaultInstance();
                            RealmContract myRealm = new RealmContract();
                            myRealm.setQuery(listMapData);
//                    myRealm.getQuery();
                            ///////

                            vollyAdapter.setMainAdapter(myActivity, myRealm.getQuery());

                        } catch (JSONException e) {
//                        e.printStackTrace();
//                        Toast.makeText(myActivity, "Error: " + e.getMessage(),Toast.LENGTH_LONG).show();
                            Log.e("Volly_mainObject_State", "VollyParsing Url Error: ");
                            //Toast.makeText(myActivity,"App Error Starting OffLine Mode ",Toast.LENGTH_LONG).show();

                        }


                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("Volly Exception", "Error: " + error.getMessage());
                        //     Toast.makeText(myActivity, "NetWork Error Starting OffLine Mode ", Toast.LENGTH_LONG).show();

                    }
                });

        // Adding request to request queue

        requestQueue.add(jsonObjReq);
        return listMapData;

    }

    //////////////////////////////////////////////////////////
    public List makeJsonObjectReviewRequest(int movieID, String segment) {
        final int mvID = movieID;
        final String mySegment=segment;
        String reviewUrl = "http://api.themoviedb.org/3/movie/" + movieID + "/" + segment + "?api_key=61b43cea1b1dc0726b2c14fcce079ffe ";

        //List<Map<String, String>> listDialogData = new ArrayList<Map<String, String>>(); ??? shy should i declared this value as Aclass Variable
        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.GET, reviewUrl, null,
                new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject JSONObjectResponse) {


                        try {
                            if (mySegment.equals("reviews")) {
                                Log.e("--->State_Requsting_Movie_Reviews", JSONObjectResponse.toString());
                                jasonReviewToList(JSONObjectResponse.optJSONArray("results")); ///Set's Your Fetcher ###1
                                ///////
                                RealmContract myRealm = new RealmContract();
                                myRealm.setMoviewReviewsQuery(getListDialogData(), mvID);///sets Reviws According to it's moview ###2
                                ///////

                                reviewsDialogtListner.startReviewDialogFragment(myActivity, myRealm.getRevQuery(mvID));////ViewController ##3

                            }
                            else if(mySegment.equals("videos"))
                            {
                                Log.e("--->State_Requsting_Movie_Trailers", JSONObjectResponse.toString());
                                jasonTrailerToList(JSONObjectResponse.optJSONArray("results")); ///Set's Your Fetcher ###1
                                ///////
                                RealmContract myRealm = new RealmContract();

                                myRealm.setMoviewTrailerQuery(getListDialogData(), mvID);///sets Reviws According to it's moview ###2
                                ///////

                                trailerDialogtListner.startTrailersDialogFragment(myActivity, myRealm.getTrailQuery(mvID));////ViewController ##3--->

                            }
                        }


                         catch (Exception e) {
                            e.printStackTrace();
                            Log.e("--->Error_VollyJasonParser","--->makeJsonObjectDialogRequest--->JSONObjectResponse",e);
                        }


                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("--->Error_VollyJasonParser", "--->makeJsonObjectDialogRequest--->Response.ErrorListener"+ error.getMessage());
                    }
                });

        // Adding request to request queue

        requestQueue.add(jsonObjReq);
        //    vollyAdapter.setMainAdapter(myActivity,listMapData);  ///Controller Method
        return getListDialogData();

    }

    //////////////////////////////////////////////////////////



    public void jasonReviewToList(JSONArray jasonListArray) {

        for (int i = 0; i < jasonListArray.length(); i++) {
            try {
                String id = jasonListArray.optJSONObject(i).getString("id");
                String author = jasonListArray.optJSONObject(i).getString("author");
                String content = jasonListArray.optJSONObject(i).getString("content");


                ////////////// if you wan't  to use map
                Map<String, String> mapData = new HashMap<String, String>();
                mapData.put("id", id);
                mapData.put("author", author);
                mapData.put("content", content);
                getListDialogData().add(i, mapData);
            } catch (JSONException e) {
                e.printStackTrace();
                Log.e("VollyJasonParser","--->jasonReviewToList_function",e);
            }

        }
    }
    public void jasonTrailerToList(JSONArray jasonListArray) {

        for (int i = 0; i < jasonListArray.length(); i++) {
            try {
                String id = jasonListArray.optJSONObject(i).getString("id");
                String key = jasonListArray.optJSONObject(i).getString("key");
                String name = jasonListArray.optJSONObject(i).getString("name");


                ////////////// if you wan't  to use map
                Map<String, String> mapData = new HashMap<String, String>();
                mapData.put("id", id);
                mapData.put("key", key);
                mapData.put("name", name);
                getListDialogData().add(i, mapData);
            } catch (JSONException e) {
                e.printStackTrace();
                Log.e("VollyJasonParser","--->jasonTrailerToList_function",e);
            }

        }
    }



    public void setVollyAdapter(VollyAdapter vollyAdapter) {
        this.vollyAdapter = vollyAdapter;
    }

    public void setReviewsDialogtListner(SingleMoviewReviewsDialogtListner reviewsDialogtListner) {
        this.reviewsDialogtListner = reviewsDialogtListner;
    } public void setTrailerDialogtListner(SingleMoviewTrailerDialogListner dialogTrailerListner) {
        this.trailerDialogtListner = dialogTrailerListner;
    }


    public List<Map<String, String>> getListDialogData() {
        return listDialogData;
    }



}

