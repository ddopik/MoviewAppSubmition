package com.example.new_one.Controller;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import com.example.new_one.HelperClasses.ReviewsAdapter;
import com.example.new_one.HelperClasses.SerializeObject;
import com.example.new_one.Model.MoviesReviews;
import com.example.new_one.R;

import java.util.List;
import java.util.Map;

import io.realm.RealmList;

/**
 * Created by ddopik_pc on 28/11/2016.
 */

public class ReviewsActivity extends ListActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reviews_dialog_activity_view);

        Intent intent = getIntent();

        SerializeObject myIntent = (SerializeObject) intent.getExtras().getSerializable("TrailersList");
        RealmList<MoviesReviews> listRevData = myIntent.getRevList();


        ListView RevList=(ListView) findViewById(R.id.reviewsList);
        ReviewsAdapter revAdapter=new ReviewsAdapter(getApplicationContext(),listRevData);
        RevList.setAdapter(revAdapter);

    }


}
