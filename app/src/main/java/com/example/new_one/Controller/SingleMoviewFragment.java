package com.example.new_one.Controller;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.new_one.Controller_interfacer.SingleMoviewReviewsDialogtListner;
import com.example.new_one.Controller_interfacer.SingleMoviewTrailerDialogListner;
import com.example.new_one.HelperClasses.VollyJasonParser;
import com.example.new_one.Model.MoviesReviews;
import com.example.new_one.Model.MoviesTrailer;
import com.example.new_one.R;
import com.example.new_one.HelperClasses.SerializeObject;
import com.squareup.picasso.Picasso;

import io.realm.RealmList;

public class SingleMoviewFragment extends Fragment {
    View fragmentView;
    Intent intent;



    List<Map<String, String>> listMapData;
    RealmList<MoviesReviews> RealmRevList;
    RealmList<MoviesTrailer> listTrailData;
    int myPosition;
    int movieID;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setRetainInstance(true);// retain this fragment so fragment won't lost instaned data
        setHasOptionsMenu(true);
        Log.e("FragmentMenu--->", "onCreateView_SingleMoview called");
         fragmentView = inflater.inflate(R.layout.single_movie_fragment, container, false);

        readBundle(getArguments());
        startMoviewFragment();

        VollyJasonParser reviewVolly=new VollyJasonParser(getActivity());
        reviewVolly.setReviewsDialogtListner(new SingleMoviewReviewsDialogtListner(){
            @Override
            public void startReviewDialogFragment(Activity mainActivity,RealmList<MoviesReviews> RealmRevList)
            {
                setListRevData(RealmRevList);
            }
        });
        reviewVolly.makeJsonObjectReviewRequest(getMoviewId(),"reviews");



        VollyJasonParser TrailerVolly=new VollyJasonParser(getActivity());
        TrailerVolly.setTrailerDialogtListner(new SingleMoviewTrailerDialogListner(){
            @Override
            public void startTrailersDialogFragment(Activity mainActivity, RealmList<MoviesTrailer> RealTrailList)
            {
                        setListTrailData(RealTrailList);
            }



        });
        TrailerVolly.makeJsonObjectReviewRequest(getMoviewId(),"videos");


        Button RevBtn=(Button) fragmentView.findViewById(R.id.RevBtnId);
        Button TrailBtn=(Button) fragmentView.findViewById(R.id.TrailBtnId);


        RevBtn.setOnClickListener(startReviewFragment);
        TrailBtn.setOnClickListener(startTrailerFragment);


        return fragmentView;
    }


    public static SingleMoviewFragment newInstance(SerializeObject arg, int position) {

        Bundle args = new Bundle();
        args.putSerializable("singleMoview", arg);
        args.putInt("position", position);

        SingleMoviewFragment fragment = new SingleMoviewFragment();
        fragment.setArguments(args);

        return fragment;
    }

    private void readBundle(Bundle bundle) {
        if (bundle != null) {
            SerializeObject myIntent =(SerializeObject) bundle.getSerializable("singleMoview");
            setListMapData(myIntent.getList());
            myPosition = bundle.getInt("position");
        }
    }

    public void startMoviewFragment()
        {

            String id = getListMapData().get(myPosition).get("id");
            setMovieID(Integer.parseInt(id));
            String myImgPath = getListMapData().get(myPosition).get("Movie_Img");
            String overview = getListMapData().get(myPosition).get("Movie_Overview");
            String original_title = getListMapData().get(myPosition).get("Movie_Name");
            String mvRating = getListMapData().get(myPosition).get("Moview_Rating");
            String year = getListMapData().get(myPosition).get("Moview_year");


            ImageView mImage=(ImageView)fragmentView.findViewById(R.id.mv_img_id);
            TextView  Mtitle=(TextView) fragmentView.findViewById(R.id.mv_title_id);
            TextView  MoverView=(TextView) fragmentView.findViewById(R.id.DescriptionViewId);
            TextView  RatingView=(TextView) fragmentView.findViewById(R.id.mv_rating_id);
            TextView  DurationView=(TextView) fragmentView.findViewById(R.id.mv_duration_id);
            TextView  yearView=(TextView) fragmentView.findViewById(R.id.mv_year_id);

            Mtitle.setText(original_title);
            MoverView.setText(overview);
            RatingView.setText(mvRating+"/10");
            yearView.setText(year);
            Picasso.with(getActivity()).load(myImgPath).into(mImage);
        }





    View.OnClickListener startReviewFragment =new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            Bundle arg=new Bundle();
            arg.putInt("MovieId",getMoviewId());

            FragmentActivity activity = (FragmentActivity)(getActivity());
            FragmentManager fm = activity.getSupportFragmentManager();
            ReviewsFragment rf=new ReviewsFragment();
            rf.setArguments(arg);
            rf.setStyle(DialogFragment.STYLE_NORMAL, R.style.CustomDialog);
            rf.show(fm,"ReviewFragment");

        }
    };

    View.OnClickListener startTrailerFragment =new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Bundle arg=new Bundle();
            arg.putInt("MovieId",getMoviewId());

            FragmentActivity activity = (FragmentActivity)(getActivity());
            FragmentManager fm = activity.getSupportFragmentManager();
            TrailerFragment  tf=new TrailerFragment();
            tf.setArguments(arg);
            tf.setStyle(DialogFragment.STYLE_NORMAL, R.style.CustomDialog);
            tf.show(fm,"TrailerFragment");
        }
    };



    public List<Map<String, String>> getListMapData() {
        return listMapData;
    }

    public void setListMapData(List<Map<String, String>> listMapData) {
        this.listMapData = listMapData;
    }


    public RealmList<MoviesReviews> getListRevData() {
        return RealmRevList;
    }

    public void setListRevData(RealmList<MoviesReviews> listRevData) {
        this.RealmRevList = listRevData;
    }



    public RealmList<MoviesTrailer> getListTrailData() {
        return listTrailData;
    }

    public void setListTrailData(RealmList<MoviesTrailer> listTrailData) {
        this.listTrailData = listTrailData;
    }




    public void setMovieID(int id)
    {
        this.movieID=id;
    }
    public int getMoviewId()
    {
        return this.movieID;
    }


}


