package com.example.new_one.Controller;

import java.security.spec.ECField;
import java.util.ArrayList;
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
import android.widget.Toast;

import com.example.new_one.Controller_interfacer.SingleMovieInfoListner;
import com.example.new_one.Controller_interfacer.SingleMoviewReviewsDialogtListner;
import com.example.new_one.Controller_interfacer.SingleMoviewTrailerDialogListner;
import com.example.new_one.HelperClasses.VollyJasonParser;
import com.example.new_one.Model.Movies;
import com.example.new_one.Model.MoviesReviews;
import com.example.new_one.Model.MoviesTrailer;
import com.example.new_one.Model.RealmContract;
import com.example.new_one.R;
import com.example.new_one.HelperClasses.SerializeObject;
import com.like.LikeButton;
import com.squareup.picasso.Picasso;

import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmResults;

public class SingleMoviewFragment extends Fragment {
    View fragmentView;
    TextView movieDurationView;


    RealmResults<Movies> MoviewListData;
    Movies mv;
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
        Realm.init(getActivity());
        setRetainInstance(true);// retain this fragment so fragment won't lost instaned data
        setHasOptionsMenu(true);
        Log.e("FragmentMenu--->", "onCreateView_SingleMoview called");
//        fragmentView = inflater.inflate(R.layout.single_movie_fragment, container, false);
//        movieDurationView = (TextView) fragmentView.findViewById(R.id.mv_duration_id);


        try {
            readBundle(getData());
            fragmentView = inflater.inflate(R.layout.single_movie_fragment, container, false);
            movieDurationView = (TextView) fragmentView.findViewById(R.id.mv_duration_id);
            startMoviewFragment();
        }
        catch(Exception e)
        {
            e.printStackTrace();
            Log.e("SingleMovieFragment_Class","SingleMovieFragment UI Crash",e);
        }
        VollyJasonParser reviewVolly = new VollyJasonParser(getMoviewId(), getActivity(), "reviews");
        reviewVolly.setReviewsDialogtListner(new SingleMoviewReviewsDialogtListner() {
            @Override
            public void startReviewDialogFragment(Activity mainActivity, RealmList<MoviesReviews> RealmRevList) {
                setListRevData(RealmRevList);
            }
        });
        reviewVolly.makeJsonObjectReviewRequest("reviews");

        VollyJasonParser TrailerVolly = new VollyJasonParser(getMoviewId(), getActivity(), "videos");
        TrailerVolly.setTrailerDialogtListner(new SingleMoviewTrailerDialogListner() {
            @Override
            public void startTrailersDialogFragment(Activity mainActivity, RealmList<MoviesTrailer> RealTrailList) {
                setListTrailData(RealTrailList);
            }
        });
        TrailerVolly.makeJsonObjectReviewRequest("videos");


        VollyJasonParser movieInfoVolly = new VollyJasonParser(getMoviewId(), getActivity(), "");
        movieInfoVolly.setSingleMovieInfoListner(new SingleMovieInfoListner() {
            @Override
            public void startMovieInfo(Activity mainActivity, int movieDuration) {
                setMovieDurationView(movieDuration);
            }
        });
        movieInfoVolly.makeJsonObjectReviewRequest("MovieInfo");///MovieInfo


        return fragmentView;
    }


    private void readBundle(Bundle bundle) {

        RealmContract myRealm=new RealmContract(getActivity());

        if (bundle != null) {
            setMovieID(bundle.getInt("myMovieID"));
        } else if (getData().getString("orderBy") == "top_rated") {
            int defaultListID=myRealm.getDefaultMovie("Tr");
            setMovieID(defaultListID);

        } else if (getData().getString("orderBy") == "popular") {
            int defaultListID=myRealm.getDefaultMovie("P");
            setMovieID(defaultListID);
        } else if (getData().getString("orderBy") == "Upcoming") {
            int defaultListID=myRealm.getDefaultMovie("Tp");
            setMovieID(defaultListID);

        } else if (getData().getString("orderBy") == "Favourates") {
            int defaultListID=myRealm.getDefaultMovie("Favourates");
            setMovieID(defaultListID);

        } else {
            Log.e("SingleMoveFragment___", "fragment_Must_Be_In_Error--->No Movie_ID assigned");
        }
    }

    private Bundle getData() {
        Bundle b = getArguments();
        if(b==null){
            b = getActivity().getIntent().getExtras();
        }
        if(b == null){
            b = new Bundle();
        }
        return b;
    }

    public void startMoviewFragment() {

        Button RevBtn = (Button) fragmentView.findViewById(R.id.RevBtnId);
        Button TrailBtn = (Button) fragmentView.findViewById(R.id.TrailBtnId);
        LikeButton FavBtn = (LikeButton) fragmentView.findViewById(R.id.FavBtnId);


        RevBtn.setOnClickListener(startReviewFragment);
        TrailBtn.setOnClickListener(startTrailerFragment);
        FavBtn.setOnClickListener(startFavAction);


        mv = getSingleMovie(getMoviewId());
        int id = mv.getId();
        setMovieID(id);
        String myImgPath = mv.getMovie_Img();
        String overview = mv.getMovie_Overview();
        String original_title = mv.getMovie_Name();
        Float mvRating = mv.getMoview_Rating();
        String year = mv.getMoview_Year();
        int duration = mv.getMovieDuration();


        ImageView mImage = (ImageView) fragmentView.findViewById(R.id.mv_img_id);
        TextView Mtitle = (TextView) fragmentView.findViewById(R.id.mv_title_id);
        TextView MoverView = (TextView) fragmentView.findViewById(R.id.DescriptionViewId);
        TextView RatingView = (TextView) fragmentView.findViewById(R.id.mv_rating_id);
        TextView DurationView = (TextView) fragmentView.findViewById(R.id.mv_duration_id);
        TextView yearView = (TextView) fragmentView.findViewById(R.id.mv_year_id);

        Mtitle.setText(original_title);
        MoverView.setText(overview);
        RatingView.setText(mvRating + "/10");
        yearView.setText(year);
        Picasso.with(getActivity()).load(myImgPath).into(mImage);
        if (duration > 0) {
//                DurationView.setText(duration);
            setMovieDurationView(duration);
        }

        if (mv.isFavorate_Movie()) {
            FavBtn.setLiked(true);
        }


    }


    public void setMovieDurationView(int movieDuration) {
        this.movieDurationView.setText(movieDuration + " Min");
    }


    View.OnClickListener startReviewFragment = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            Bundle arg = new Bundle();
            arg.putInt("MovieId", getMoviewId());

            FragmentActivity activity = (FragmentActivity) (getActivity());
            FragmentManager fm = activity.getSupportFragmentManager();
            ReviewsFragment rf = new ReviewsFragment();
            rf.setArguments(arg);
            rf.setStyle(DialogFragment.STYLE_NORMAL, R.style.CustomDialog);
            rf.show(fm, "ReviewFragment");

        }
    };

    View.OnClickListener startTrailerFragment = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Bundle arg = new Bundle();
            arg.putInt("MovieId", getMoviewId());

            FragmentActivity activity = (FragmentActivity) (getActivity());
            FragmentManager fm = activity.getSupportFragmentManager();
            TrailerFragment tf = new TrailerFragment();
            tf.setArguments(arg);
            tf.setStyle(DialogFragment.STYLE_NORMAL, R.style.CustomDialog);
            tf.show(fm, "TrailerFragment");
        }
    };

    View.OnClickListener startFavAction = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            RealmContract myRealm = new RealmContract(getActivity());
            String state = myRealm.setMoviewToFav(getMoviewId());
            Toast.makeText(getActivity(), state, Toast.LENGTH_SHORT).show();
        }
    };


    public Movies getSingleMovie(int movieID) {
        RealmContract myRealm = new RealmContract(getActivity());
        return myRealm.getSingleMovie(movieID);
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


    public void setFrgListner() {

    }

    public void setMovieID(int id) {
        this.movieID = id;
    }

    public int getMoviewId() {
        return this.movieID;
    }


}


