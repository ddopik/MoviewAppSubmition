package com.example.new_one;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
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
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
 @TargetApi(Build.VERSION_CODES.HONEYCOMB)

 public class Fragment_main extends  ListFragment implements OnItemClickListener  {

        Context context;
	    //String[] menuTitles;   //(test)
	    //TypedArray menuIcons; //(test)
        private List weatherItems;
	    String myUrl="http://api.openweathermap.org/data/2.5/forecast/daily?q=94043&mode=json&units=metric&cnt=7";




	    CustomViewAdapter adapter;  ///my handler class
	    //private List<RowItem> rowItems; ///we are sending each row in the list as object(test)
	                                   /// so we will make array_list of type [our_object] and send it for adapter


	    @Override
	    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
			setHasOptionsMenu(true);
	        return inflater.inflate(R.layout.fragment_activity,container, false);

	    }  ///setting view fragment object for adapter
	    @Override
	    public void onActivityCreated(Bundle savedInstanceState) {


	        super.onActivityCreated(savedInstanceState);
			setHasOptionsMenu(true);
/////////////////////////////////////////
	        //menuTitles = getResources().getStringArray(R.array.titles); ///this contain all title as array(test)
	       // menuIcons = getResources().obtainTypedArray(R.array.icons); ///this contain all icon as array(test)
//			rowItems = new ArrayList<RowItem>();
//
//			for (int i = 0; i < menuTitles.length; i++) {
//				RowItem items = new RowItem(menuIcons.getResourceId(i,-1),menuTitles[i]);
//				rowItems.add(items); //(test)
//			}    ///here we are creating list of object
/////////////////////////////////////////






			FetchWeatherTask myTask=new FetchWeatherTask();
			myTask.delegate=new AsyncResponse1()
			{
				@Override
				public void processFinish(String output)
				{
					try{
						Log.e("set==--->",output);
						JasonParser jasonApi=new JasonParser();
						List<Map<Integer,String>> jasonApiItems=jasonApi.myJSONParser(output);
						for(int i=0;i<=jasonApiItems.length;i++)
						{

						}

					}
					catch(Exception e)
					{
						Log.e("Trace_2---->", "Error_adapter fetching JASON error !!!!(*_-_*)!!!!! ", e);
						Log.e("Error_here---->",e.getMessage());
					}


				}
			};

			adapter = new CustomViewAdapter(getActivity(),weatherItems); /// send to custom adapter to render view
			setListAdapter(adapter); //provide activity for list view
			myTask.execute(myUrl);


            try {
				getListView().setOnItemClickListener(this); ///// debug error Need fix
			}catch(Exception e) {
				Log.e("Error_refrsh","---->",e);
			}

	    }
	        @Override
	        public void onItemClick(AdapterView<?> parent, View view, int position,long id)
			{

				FetchWeatherTask myTask=new FetchWeatherTask();
						myTask.delegate=new AsyncResponse1()
						{
							@Override
							public void processFinish(String output)
							{
								try{
									TextView tt=(TextView) getActivity().findViewById(R.id.print);
 									String vv=tt.getText().toString();
									tt.setText(output);

									Log.e("set==--->",output);
									Log.e("set_22==--->",vv);
								}
								catch(Exception e)
								{
									Log.e("Trace_2---->", "Error ", e);
								}


							}
						};


				myTask.execute(myUrl);
	            Toast.makeText(getActivity(), menuTitles[position], Toast.LENGTH_SHORT).show();

	        }






	 }



