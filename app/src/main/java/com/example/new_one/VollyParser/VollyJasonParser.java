package com.example.new_one.VollyParser;

import android.app.Activity;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.android.volley.VolleyLog.TAG;


public class VollyJasonParser {

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

    public VollyJasonParser(Activity act,String url) {

        requestQueue = Volley.newRequestQueue(act);
        JsonObjURL=url;
        myActivity=act;
    }
        /**
         * Method to make json object request where json response starts wtih {
         * */
        private List makeJsonObjectRequest() {


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

