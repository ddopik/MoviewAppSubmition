package com.example.new_one.Controller;

import android.app.Fragment;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;

import com.example.new_one.HelperClasses.ReviewsAdapter;
import com.example.new_one.Model.MoviesReviews;
import com.example.new_one.Model.RealmContract;
import com.example.new_one.R;

import io.realm.RealmList;

/**
 * Created by ddopik_pc on 28/11/2016.
 */

public class ReviewsFragment extends DialogFragment {



    int movieId;
    RealmList<MoviesReviews> listRevData;
    View fragmentView;
    ListView revListView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);// retain this fragment so fragment won't lost instaned data
        setHasOptionsMenu(true);
        Log.e("TrailerFragmentMenu--->", "onCreateTrailerFragmentCalled");
        getDialog().setTitle("Reviews");
        fragmentView = inflater.inflate(R.layout.reviews_dialog_activity_view, container, false);
        revListView = (ListView) fragmentView.findViewById(R.id.reviesList);



        setMovieId(getArguments().getInt("MovieId"));
        RealmContract myRealm = new RealmContract();
        setListRevData(myRealm.getRevQuery(getMovieId()));

        ReviewsAdapter revAdapter=new ReviewsAdapter(getActivity(),getListRevData());
        revListView.setAdapter(revAdapter);



        return fragmentView;
    }








    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public RealmList<MoviesReviews> getListRevData() {
        return listRevData;
    }

    public void setListRevData(RealmList<MoviesReviews> listRevData) {
        this.listRevData = listRevData;
    }

}
