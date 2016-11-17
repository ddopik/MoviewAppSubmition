package com.example.new_one.VollyParser;

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
import android.widget.EditText;
import android.widget.GridView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.example.new_one.AsyncTaskResponse;
import com.example.new_one.AsyncTaskResponseFetcher;
import com.example.new_one.CustomViewAdapter;
import com.example.new_one.JasonParser;
import com.example.new_one.Model.RealmContract;
import com.example.new_one.MyDataBaseContract;
import com.example.new_one.R;
import com.example.new_one.SerializeObject;
import com.example.new_one.SingleMoviewActivity;
import com.example.new_one.VollyParser.VollyJasonParser;
import io.realm.Realm;
import io.realm.RealmConfiguration;

import static android.view.View.INVISIBLE;
import static android.view.View.VISIBLE;

@TargetApi(Build.VERSION_CODES.HONEYCOMB)

public class Fragment_main extends Fragment {


    private List<Map<String, String>> jasonApiItems;
    String myUrl = "https://api.themoviedb.org/3/movie/top_rated?api_key=61b43cea1b1dc0726b2c14fcce079ffe";
    View fragmentView;
    CustomViewAdapter adapter;
    GridView movieGridView;
    ListView movieListView;
    View movieView;
    Realm realm;
    Activity mainActivity;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // retain this fragment
        setRetainInstance(true);
        setHasOptionsMenu(true);
        Log.e("FragmentMenu--->", "onCreateView_FragmentMenu called");
        fragmentView = inflater.inflate(R.layout.fragment_activity, container, false);

        movieGridView = (GridView) fragmentView.findViewById(R.id.gridList);
        movieListView = (ListView) fragmentView.findViewById(R.id.movieList);

        processFinish();
        return fragmentView;
    }



        public void processFinish() {
            /////////////////AsynckTask using Volly
        try {
            VollyJasonParser vollyParser=new VollyJasonParser(getActivity(),fragmentView,getArguments(),myUrl);
            Log.e("--JASON State ----->", "JASON Resived");

            jasonApiItems=vollyParser.makeJsonObjectRequest();
            setMainAdapter(getActivity(),jasonApiItems);


            //offline Sqlite DataBase
//                    MyDataBaseContract db=new MyDataBaseContract(getActivity());
//                    db.addMovie(jasonApiItems);
            ////
            ///////using Realm DB   (
//                    realm = Realm.getDefaultInstance();
//                    RealmContract myRealm=new RealmContract();
//                    myRealm.setQuery(jasonApiItems);
//                    myRealm.getQuery(getActivity());

            ///////
           /////Notice that we have included data base opertation inside Volly class)
          ////Cause when we placed them here waiting for Volly Result
        ////the compiler intilzed them with <0>
       ////as the volly class worked as AsynckTask


        } catch (Exception e) {
            Log.e("Trace_2---->", "Error_adapter fetching JASON error !!!!(*_-_*)!!!!! ", e);
            Log.e("Error_here---->", e.getMessage());


            RealmContract realmObj=new RealmContract();
            setMainAdapter(getActivity(),realmObj.getQuery());
        }
        finally {
            ProgressBar    myProgressBar  = (ProgressBar)getActivity().findViewById(R.id.progressbar_Horizontal);
            myProgressBar.setVisibility(INVISIBLE);
        }





    }


    public  void setMainAdapter(Activity mainActivity, List<Map<String, String>> jasonApiItems)
    {
        /////// what if want to contain (movieGridView and movieListView ) in Single variable ?????
        adapter = new CustomViewAdapter(mainActivity,jasonApiItems); /// send to custom adapter to render view
        if(getArguments().getString("viewBy").equals("Grid")) {
            movieGridView.setAdapter(adapter); //provide activity for Grid view
            //  movieView=movieGridView; //test
        }else{
            movieListView.setAdapter(adapter); //provide activity for list view
            //movieView=movieListView;//test
        }

        adapter.notifyDataSetChanged();
}









    ///the user selecting A single movie
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ////Listner for List view

        movieListView.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,int position, long id) {

                SerializeObject intentVar=new SerializeObject();
                intentVar.setList(jasonApiItems);

                Intent myIntent = new Intent(getActivity().getApplicationContext(),SingleMoviewActivity.class);
                //myIntent.putParcelableArrayListExtra("singleMoview",(ArrayList<? extends Parcelable>) Fragment_main_deprecated.this.jasonApiItems);
                myIntent.putExtra("singleMoview",intentVar);
                myIntent.putExtra("position",position);
                startActivity(myIntent);



            }
        });

        ///listner for List view
        movieGridView.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,int position, long id) {

                SerializeObject intentVar=new SerializeObject();
                intentVar.setList(jasonApiItems);

                Intent myIntent = new Intent(getActivity().getApplicationContext(),SingleMoviewActivity.class);
                //myIntent.putParcelableArrayListExtra("singleMoview",(ArrayList<? extends Parcelable>) Fragment_main_deprecated.this.jasonApiItems);
                myIntent.putExtra("singleMoview",intentVar);
                myIntent.putExtra("position",position);
                startActivity(myIntent);



            }
        });
    }


}


