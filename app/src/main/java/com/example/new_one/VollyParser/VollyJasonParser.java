package com.example.new_one.VollyParser;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.new_one.CustomViewAdapter;
import com.example.new_one.Model.RealmContract;
import com.example.new_one.R;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.realm.Realm;

import static com.android.volley.VolleyLog.TAG;


public class VollyJasonParser {

    GridView movieGridView;
    ListView movieListView;
    Bundle viewType;
    RequestQueue requestQueue;
    String JsonObjURL;
    Activity myActivity;
    String imgUrl;
    String poster_path;
    String overview;
    String original_title;
    String releasDate;
    int voteAverage;
    List<Map<String,String>> listMapData=new ArrayList<Map<String,String>>();

    public VollyJasonParser(Activity act,View fragmentView, Bundle SharedPrefViewType, String url) {

        requestQueue = Volley.newRequestQueue(act);
        JsonObjURL=url;
        myActivity=act;
        viewType=SharedPrefViewType;
        movieGridView = (GridView) fragmentView.findViewById(R.id.gridList);
        movieListView = (ListView) fragmentView.findViewById(R.id.movieList);
    }
        /**
         * Method to make json object request where json response starts wtih {
         * */
        public List makeJsonObjectRequest() {


            JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.GET,JsonObjURL, null,
                    new Response.Listener<JSONObject>() {

                @Override
                public void onResponse(JSONObject JSONObjectResponse) {
                    Log.d(TAG, JSONObjectResponse.toString());

                    try {
                        JSONArray jasonListArray=JSONObjectResponse.optJSONArray("results");
                        for(int i=0;i<jasonListArray.length();i++)
                        {
                            poster_path=jasonListArray.optJSONObject(i).getString("poster_path");
                            imgUrl="http://image.tmdb.org/t/p/w185"+poster_path;
                            overview=jasonListArray.optJSONObject(i).getString("overview");
                            releasDate=jasonListArray.optJSONObject(i).getString("release_date");
                            original_title=jasonListArray.optJSONObject(i).getString("original_title");
                            voteAverage=jasonListArray.optJSONObject(i).getInt("vote_average");

                            ////////////// if you wan't  to use map
                            Map<String,String> mapData = new HashMap<String,String>();
                            mapData.put("id",i+" ");
                            mapData.put("Movie_Img",imgUrl);
                            mapData.put("Movie_Overview",overview);
                            mapData.put("Movie_Name",original_title);
                            mapData.put("Moview_year",releasDate);
                            mapData.put("Moview_Rating",voteAverage+"");
                            listMapData.add(i,mapData);
                            ///how you get data..
                            ///->listMapData.get(0).get("name");
                            /////////////

                        }


                        ///////using Realm DB
                    Realm  realm = Realm.getDefaultInstance();
                    RealmContract myRealm=new RealmContract();
                    myRealm.setQuery(listMapData);
                    myRealm.getQuery();
                        ///////

                        /////// what if want to contain (movieGridView and movieListView ) in Single variable ?????
                        CustomViewAdapter  adapter = new CustomViewAdapter(myActivity,listMapData); /// send to custom adapter to render view
                        if(viewType.getString("viewBy").equals("Grid")) {
                            movieGridView.setAdapter(adapter); //provide activity for Grid view
                            //  movieView=movieGridView; //test
                        }else{
                            movieListView.setAdapter(adapter); //provide activity for list view
                            //movieView=movieListView;//test
                        }

                        adapter.notifyDataSetChanged();
                    }


                    catch (JSONException e)
                    {
                        e.printStackTrace();
                        Toast.makeText(myActivity, "Error: " + e.getMessage(),
                                Toast.LENGTH_LONG).show();
                    }

                }
            },
                    new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error)
                {
                    VolleyLog.d(TAG, "Error: " + error.getMessage());
                    Toast.makeText(myActivity,error.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });

            // Adding request to request queue
            requestQueue.add(jsonObjReq);
            return listMapData;

    }
}

