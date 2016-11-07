package com.example.new_one;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class SingleMoviewActivity extends AppCompatActivity {

public void onCreate(Bundle savedInstanceState) {

    super.onCreate(savedInstanceState);
    setContentView(R.layout.single_movie);
    List<Map<String, String>> listMapData;
    Intent intent = getIntent();

    int myposition=intent.getExtras().getInt("position");
    SerializeObject myIntent=(SerializeObject) intent.getExtras().getSerializable("singleMoview");
     listMapData=myIntent.getList();

    String myImgPath = listMapData.get(myposition).get("Movie_Img");
    String overview = listMapData.get(myposition).get("Movie_Overview");
    String original_title = listMapData.get(myposition).get("Movie_Name");

//    textView4
    ImageView mImage=(ImageView)this.findViewById(R.id.imageView1);
    TextView  Mtitle=(TextView) this.findViewById(R.id.textView5);
    TextView  MoverView=(TextView) this.findViewById(R.id.textView4);

    Mtitle.setText(original_title);
    MoverView.setText(overview);
    Picasso.with(getApplicationContext()).load(myImgPath).into(mImage);

//    LayoutInflater mInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
//    convertView = mInflater.inflate(R.layout.custom_grid_item, null);
}

}
