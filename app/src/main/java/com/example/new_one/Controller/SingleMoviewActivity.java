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

    Intent intent;
    int myMovieID;
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
        myMovieID= intent.getExtras().getInt("MovieID");

        Bundle arg=new Bundle();
        arg.putInt("myMovieID",myMovieID);
        SingleMoviewFragment fgs = new SingleMoviewFragment();
        fgs.setArguments(arg);


        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.singleMovieContaiberActivity,fgs); ///we are Not Deleting the container we are Deleting it's content
        ft.commit();



    }








}


