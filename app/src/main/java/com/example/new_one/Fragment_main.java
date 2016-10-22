package com.example.new_one;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Fragment;
import android.app.ListFragment;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Bundle;
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


    CustomViewAdapter adapter;
    GridView gridView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        setHasOptionsMenu(true);

        View fragmentView = inflater.inflate(R.layout.fragment_activity, container, false);
        gridView = (GridView) fragmentView.findViewById(R.id.gridList);

        FetchWeatherTask myTask = new FetchWeatherTask();
        myTask.delegate = new AsyncResponse1() {
            @Override
            public void processFinish(String output) {
                try {
                    Log.e("--JASON Result is----->", output);
                    JasonParser jasonApi = new JasonParser();
                    jasonApiItems = jasonApi.myJSONParser(output);


                } catch (Exception e) {
                    Log.e("Trace_2---->", "Error_adapter fetching JASON error !!!!(*_-_*)!!!!! ", e);
                    Log.e("Error_here---->", e.getMessage());
                }

//					adapter = new CustomViewAdapter(getActivity(),jasonApiItems); /// send to custom adapter to render view
//					setListAdapter(adapter); //provide activity for list view


                adapter = new CustomViewAdapter(getActivity(), jasonApiItems); /// send to custom adapter to render view
                gridView.setAdapter(adapter); //provide activity for list view
                adapter.notifyDataSetChanged();
                ///gv.setOnScrollListener(new SampleScrollListener(this)); what is this

            }
        };


        myTask.execute(myUrl);
        return fragmentView;

    }  ///setting view fragment object for adapter




//            try {                                          ////setting--->Refresh_btn
//				getListView().setOnItemClickListener(this); ///// debug error Need fix
//			}catch(Exception e) {
//				Log.e("Error_refrsh","---->",e);
//			}

//	        @Override  ///click section
//	        public void onItemClick(AdapterView<?> parent, View view, int position,long id)
//			{
//
//				FetchWeatherTask myTask=new FetchWeatherTask();
//						myTask.delegate=new AsyncResponse1()
//						{
//							@Override
//							public void processFinish(String output)
//							{
//								try{
//									TextView tt=(TextView) getActivity().findViewById(R.id.print);
// 									String vv=tt.getText().toString();
//									tt.setText(output);
//
//									Log.e("set==--->",output);
//									Log.e("set_22==--->",vv);
//								}
//								catch(Exception e)
//								{
//									Log.e("Trace_2---->", "Error ", e);
//								}
//
//
//							}
//						};
//
//
//				myTask.execute(myUrl);
//	           // Toast.makeText(getActivity(),menuTitles[position], Toast.LENGTH_SHORT).show();
//
//	        }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {


        super.onActivityCreated(savedInstanceState);
    }


}



