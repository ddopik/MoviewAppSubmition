package com.example.new_one.Controller;

import java.util.List;
import java.util.Map;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.new_one.R;
import com.example.new_one.HelperClasses.SerializeObject;
import com.squareup.picasso.Picasso;

public class SingleMoviewActivity extends AppCompatActivity {
    View fragmentView;
    Intent intent;
    List<Map<String, String>> listMapData;
    int myPosition;
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        menu.clear();
        inflater.inflate(R.menu.main, menu);
        Log.e("Test_menu--->", "onCreateOptionsMenu called");
        return true;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.single_moview_activity);

        Log.e("SingleMoview_Activity->", "startMoviewActivity called");
        intent = getIntent();
        myPosition = intent.getExtras().getInt("position");
        SerializeObject myIntent = (SerializeObject) intent.getExtras().getSerializable("singleMoview");
        listMapData = myIntent.getList();


        SingleMoviewFragment fgs = SingleMoviewFragment.newInstance(myIntent, myPosition);
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.singleMovieContaiberActivity,fgs); ///we are Not Deleting the container we are Deleting it's content
        ft.commit();



    }


    public List<Map<String, String>> getListMapData() {
        return listMapData;
    }

    public void setListMapData(List<Map<String, String>> listMapData) {
        this.listMapData = listMapData;
    }

//    public void startMoviewActivity() {  /////became Useless
//
//        intent = getIntent();
//        myPosition = intent.getExtras().getInt("position");
//        SerializeObject myIntent = (SerializeObject) intent.getExtras().getSerializable("singleMoview");
//        listMapData = myIntent.getList();
//
//        String myImgPath = listMapData.get(myPosition).get("Movie_Img");
//        String overview = listMapData.get(myPosition).get("Movie_Overview");
//        String original_title = listMapData.get(myPosition).get("Movie_Name");
//
////    textView4
//        ImageView mImage = (ImageView) findViewById(R.id.mv_img_id);
//        TextView Mtitle = (TextView) findViewById(R.id.mv_title_id);
//        TextView MoverView = (TextView) findViewById(R.id.textView4);
//
//        Mtitle.setText(original_title);
//        MoverView.setText(overview);
//        Picasso.with(this).load(myImgPath).into(mImage);
//    }




}


