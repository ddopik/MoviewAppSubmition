package com.example.new_one;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;




public class JasonParser {

    String strJson;

    List<Map<Integer,String>> listMapData=new ArrayList<Map<Integer,String>>();
   // List<String> myListData=new ArrayList<String>();

    public List myJSONExtractor(String strJson) throws JSONException {
        this.strJson=strJson;
        JSONObject j_object = new JSONObject(strJson);

        //Get the instance of JSONArray that contains JSONObjects
        JSONArray jsonCityArray = j_object.optJSONArray("city");
        JSONArray jasonListArray=j_object.optJSONArray("list");  ///get array of list obj
        for(int i=0;i<jasonListArray.length();i++)
        {
            String[] myDay;
            JSONObject jsonItem=jasonListArray.getJSONObject(i); ///return first list object
            JSONObject jsonTemp=jsonItem.getJSONObject("temp");
            String minTemp=jsonTemp.getString("min"); //#1
            String maxTemp=jsonTemp.getString("max"); //#2


            JSONArray jsonWeatherArray=jsonItem.getJSONArray("weather");
            JSONObject weatherobj=jsonWeatherArray.getJSONObject(0);
            String weatherMainType=weatherobj.getString("main");  //#3
            String weatherDescription=weatherobj.getString("description");  //#4

//            myListData.add("minTemp",minTemp);
//            myListData.add("maxTemp",maxTemp);
//            myListData.add(i,weatherMainType);
//            myListData.add(i,weatherDescription);
           //mydata.get(0).get("name");

            ////////////// if you wan't  to use map
           Map<Integer, String> mapData = new HashMap<Integer, String>();
            mapData.put(i,minTemp);
            mapData.put(i,minTemp);
            mapData.put(i,weatherMainType);
            mapData.put(i,weatherMainType);
            listMapData.add(i,mapData);
            ///how you get data..
            ///->listMapData.get(0).get("name");
            /////////////

        }


     return listMapData;

    }





}
