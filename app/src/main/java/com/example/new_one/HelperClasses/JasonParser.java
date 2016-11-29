package com.example.new_one.HelperClasses;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static android.R.attr.data;


public class JasonParser {

    String strJson;

    List<Map<String,String>> listMapData=new ArrayList<Map<String,String>>();

   // List<String> myListData=new ArrayList<String>();

    public List myJSONParser(String strJson) throws JSONException {
        this.strJson=strJson;

        JSONObject j_object = new JSONObject(strJson);

        //Get the instance of JSONArray that contains JSONObjects
        JSONArray jasonListArray=j_object.optJSONArray("results");
        String imgUrl;
        String poster_path;
        String overview;
        String original_title;
        String releasDate;
        int voteAverage;
        for(int i=0;i<jasonListArray.length();i++)
        {
             poster_path=jasonListArray.optJSONObject(i).getString("poster_path");
             imgUrl="http://image.tmdb.org/t/p/w185"+poster_path;
             overview=jasonListArray.optJSONObject(i).getString("overview");
             releasDate=jasonListArray.optJSONObject(i).getString("release_date");
             original_title=jasonListArray.optJSONObject(i).getString("original_title");
             voteAverage=jasonListArray.optJSONObject(i).getInt("vote_average");



            //String minTemp=jsonTemp.getString("min"); //#1

            ////////////// if you wan't  to use map
            Map<String,String> mapData = new HashMap<String,String>();
            String ii=Integer.toString(i);
            mapData.put("id",ii+" ");
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


     return listMapData;

    }





}

