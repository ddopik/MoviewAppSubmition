package com.example.new_one;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Fragment;
import android.app.ListFragment;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

@TargetApi(Build.VERSION_CODES.HONEYCOMB)

public class Fragment_main extends Fragment {


    private List<Map<String, String>> jasonApiItems;
    String myUrl = "https://api.themoviedb.org/3/movie/top_rated?api_key=61b43cea1b1dc0726b2c14fcce079ffe";
    View fragmentView;
    CustomViewAdapter adapter;
    GridView gridView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        Log.e("FragmentMenu--->","onCreateView_FragmentMenu called");
        fragmentView = inflater.inflate(R.layout.fragment_activity, container, false);
        gridView = (GridView) fragmentView.findViewById(R.id.gridList);

        FetchWeatherTask myTask = new FetchWeatherTask();
        myTask.delegate = new AsyncResponse1() {
            @Override
            public void processFinish(String output) {
                try {
                    Log.e("--JASON Result is----->", output);
                    JasonParser jasonApi = new JasonParser();
                    jasonApiItems = jasonApi.myJSONParser(output);
                    ShowTypeHandler db=new ShowTypeHandler(getActivity());
                    db.addMovie(jasonApiItems);
                } catch (Exception e) {
                    Log.e("Trace_2---->", "Error_adapter fetching JASON error !!!!(*_-_*)!!!!! ", e);
                    Log.e("Error_here---->", e.getMessage());
                    ShowTypeHandler db=new ShowTypeHandler(getActivity());
                    jasonApiItems= db.getAllMovies();

                }






                adapter = new CustomViewAdapter(getActivity(), jasonApiItems); /// send to custom adapter to render view
                gridView.setAdapter(adapter); //provide activity for list view
                adapter.notifyDataSetChanged();
                ///gv.setOnScrollListener(new SampleScrollListener(this)); what is this

            }
        };
        myTask.execute(myUrl);
        return fragmentView;

    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        gridView.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,int position, long id) {

                SerializeObject intentVar=new SerializeObject();
                intentVar.setList(jasonApiItems);

                Intent myIntent = new Intent(getActivity().getApplicationContext(),SingleMoview.class);
                //myIntent.putParcelableArrayListExtra("singleMoview",(ArrayList<? extends Parcelable>) Fragment_main.this.jasonApiItems);
                myIntent.putExtra("singleMoview",intentVar);
                myIntent.putExtra("position",position);
                startActivity(myIntent);



            }

        });
    }


}



