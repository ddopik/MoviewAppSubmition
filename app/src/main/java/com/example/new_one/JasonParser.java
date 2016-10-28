package com.example.new_one;

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
        for(int i=0;i<jasonListArray.length();i++)
        {
             poster_path=jasonListArray.optJSONObject(i).getString("poster_path");
             imgUrl="http://image.tmdb.org/t/p/w185"+poster_path;
             overview=jasonListArray.optJSONObject(i).getString("overview");
            original_title=jasonListArray.optJSONObject(i).getString("original_title");



            //String minTemp=jsonTemp.getString("min"); //#1

            ////////////// if you wan't  to use map
            Map<String,String> mapData = new HashMap<String,String>();
            mapData.put("id",i+" ");
            mapData.put("poster_path",imgUrl);
            mapData.put("overview",overview);
            mapData.put("original_title",original_title);
            listMapData.add(i,mapData);
            ///how you get data..
            ///->listMapData.get(0).get("name");
            /////////////

        }


     return listMapData;

    }





}

