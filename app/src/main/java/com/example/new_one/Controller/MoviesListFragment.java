package com.example.new_one.Controller;

import java.util.List;
import java.util.Map;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.new_one.Controller_interfacer.SingleMoviewFragmentListner;
import com.example.new_one.Controller_interfacer.VollyAdapter;
import com.example.new_one.HelperClasses.CustomViewAdapter;
import com.example.new_one.Model.Movies;
import com.example.new_one.Model.RealmContract;
import com.example.new_one.R;
import com.example.new_one.HelperClasses.SerializeObject;
import com.example.new_one.HelperClasses.VollyJasonParser;

import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmResults;

import static android.view.View.INVISIBLE;

@TargetApi(Build.VERSION_CODES.HONEYCOMB)

public class MoviesListFragment extends Fragment {


    private RealmResults<Movies> jasonApiItems;
    public SingleMoviewFragmentListner frgListner;
    String myUrl;
    String flagUrl;
    View fragmentView;
    GridView movieGridView;
    ListView movieListView;
    Button favButton;
    Activity mainActivity;
    CustomViewAdapter adapter;
    ProgressBar myProgressBar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);// retain this fragment so fragment won't lost instaned data
        setHasOptionsMenu(true);

        fragmentView = inflater.inflate(R.layout.fragment_activity, container, false);

        movieGridView = (GridView) fragmentView.findViewById(R.id.gridList);
        movieListView = (ListView) fragmentView.findViewById(R.id.movieList);

        fragmentStart();
        return fragmentView;
    }


    public void fragmentStart() {
        /////////////////AsynckTask using Volly

        try {
            if (getArguments().getString("orderBy").equals("top_rated")) {
                Log.e("MoviesListFragment", "top_rated Fragment Start");
                setMyUrl("top_rated");
                setFlagUrl("Tr");

            } else if (getArguments().getString("orderBy").equals("popular")) {
                Log.e("MoviesListFragment", "popular Fragment Start");
                setMyUrl("popular");
                setFlagUrl("P");
            } else if (getArguments().getString("orderBy").equals("Upcoming")) {
                Log.e("MoviesListFragment", "Upcoming Fragment Start");
                setMyUrl("upcoming");
                setFlagUrl("Tp");
            } else if (getArguments().getString("orderBy").equals("Favourates")) {
                Log.e("MoviesListFragment", "Favourates Fragment Start");
                setMyUrl("Favourates");
                setFlagUrl("Fav");
            } else {
                Log.e("MoviesListFragment", "top_rated Fragment Start");
                setMyUrl("top_rated");
                setFlagUrl("Tr");
            }
            ((MainActivity) getActivity()).setActionBarTitle(getArguments().getString("orderBy"));


            VollyJasonParser vollyParser = new VollyJasonParser(getActivity(), fragmentView, getArguments(), getMyUrl(), getFlagUrl());
            vollyParser.setVollyAdapter(new VollyAdapter() {
                @Override
                public void setMainAdapter(Activity mainActivity, RealmResults<Movies> jasonApiItems) {

                    setJasonApiItems(jasonApiItems);
                    setMainAdapter2(mainActivity, jasonApiItems);

                    myProgressBar = (ProgressBar) fragmentView.findViewById(R.id.pbFooterLoading);
                    myProgressBar.setVisibility(View.GONE);
                }
            });
            vollyParser.makeJsonObjectRequest();


            Log.e("Fragment JASON State --->", "JASON Resived");


        } catch (Exception e) {
            Log.e("MovieListFragment---->", "Volly Calling NetWork Error ---> ", e);
            Log.e("MovieListFragment---->", "Error_adapter fetching JASON error !!!!(*_-_*)!!!!! ");
            Log.e("MovieListFragment---->", "Starting App in Offline Mode");
            RealmContract moviesList = new RealmContract();


            myProgressBar = (ProgressBar) fragmentView.findViewById(R.id.pbFooterLoading);
            myProgressBar.setVisibility(View.GONE);
            RealmResults<Movies> offlineData = moviesList.getQuery(getFlagUrl());
            setMainAdapter2(mainActivity, offlineData);
            setJasonApiItems(offlineData);
        }
        ///////
        /////Notice that we have included data base opertation inside Volly class)
        ////Cause when we placed them here waiting for Volly Result
        ////the compiler intilzed them with <0>
        ////as the volly class worked as AsynckTask
        finally {


        }


    }

    ////Adapter for Activity Main
    public void setMainAdapter2(Activity mainActivity, RealmResults<Movies> jasonApiItems) {
        /////// what if want to contain (movieGridView and movieListView ) in Single variable ?????
        adapter = new CustomViewAdapter(mainActivity, jasonApiItems); /// send to custom adapter to render view
        if (getArguments().getString("viewBy").equals("Grid")) {

            movieGridView.setAdapter(adapter); //provide activity for Grid view
            adapter.notifyDataSetChanged();

//               movieView=movieGridView; //test
        } else {

            movieListView.setAdapter(adapter); //provide activity for list view
            adapter.notifyDataSetChanged();
        }


    }


    ///user selecting A single movie
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        ////Listner for List view
        movieListView.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {

                View parent_1 = parent;
                View secoundPArent = v; //selectedItem
                RelativeLayout mySingleItem = (RelativeLayout) v;
                TextView myTextView = (TextView) mySingleItem.findViewById(R.id.mainMovieId);
                int movieID = Integer.parseInt(myTextView.getText().toString());
                frgListner.createFrgListner(movieID);///after MainActivity intialize the frgListner we call it here

            }

        });
        ///listner for Grid view
        movieGridView.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {

                RelativeLayout mySingleItem = (RelativeLayout) v;
                TextView myTextView = (TextView) mySingleItem.findViewById(R.id.mainMovieId);
                int movieID = Integer.parseInt(myTextView.getText().toString());
                frgListner.createFrgListner(movieID);///after MainActivity intialize the frgListner we call it here
            }
        });

    }

    public void setFrgListner(SingleMoviewFragmentListner frgListner) {  ///Setter for Main Thread UI
        this.frgListner = frgListner;
    }

    public RealmResults<Movies> getJasonApiItems() {
        return jasonApiItems;
    }

    public void setJasonApiItems(RealmResults<Movies> realmResult) {
        this.jasonApiItems = realmResult;
    }

    public String getMyUrl() {
        return myUrl;
    }

    public void setMyUrl(String myUrl) {
        this.myUrl = myUrl;
    }

    public String getFlagUrl() {
        return flagUrl;
    }

    public void setFlagUrl(String flagUrl) {
        this.flagUrl = flagUrl;
    }


}

