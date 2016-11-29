package com.example.new_one.HelperClasses;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.new_one.R;
import com.example.new_one.View.ViewHolder_ListItem;
import com.squareup.picasso.Picasso;

///Create a Custom adapter which extends ""'BaseAdapter""" , 
///this is used for inflating each row items of the listfragment 
///with list_item.xml layout inside getView method.

public class CustomViewAdapter extends BaseAdapter  {
	
	    Context context;
	    List<Map<String,String>> rowItem;

	    public CustomViewAdapter(Context context,List<Map<String,String>> rowItem) {
	        this.context = context;
	        this.rowItem = rowItem;


	    }
	/////Stage 1 --->Helper class Sf
///////////////////////////////////////////////////////////////////////////////////////////////////////
	    @Override
                ///how many item are in the data set represented by this adapter
	    public int getCount() {

	        return rowItem.size();
	    }
	    @Override
              //Get the data item associated with the specified position in the data set
	    public Object getItem(int position) {

	        return rowItem.get(position);
	    }
	    @Override
	           ///Get the row id associated with the specified position in the list
	    public long getItemId(int position) {

	        return rowItem.indexOf(getItem(position));
		}
	/////////////////////////////Stage_1///////////////////////////////////////////////////////////////////////////////////


	    /////Stage 2  --->(Set)--->fragment (Get)--->fragment Element for intialization
	    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	    public View getView(int position, View convertView, ViewGroup parent) {

			ViewHolder_ListItem listViewHolder;
	        if (convertView == null) {
	            LayoutInflater mInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
	            convertView = mInflater.inflate(R.layout.custom_single_item, null);
				listViewHolder=new ViewHolder_ListItem();
				listViewHolder.movImg=(ImageView) convertView.findViewById(R.id.mv_img_id);
				listViewHolder.movTitle=(TextView) convertView.findViewById(R.id.imageTitle);
				                                     //// store the holder with the view.
				convertView.setTag(listViewHolder);////used to mark a view in its hierarchy and does not have to be unique within the hierarchy.
				                                  //// Tags can also be used to store data within a view without resorting to another data structure.
	        }
			else
			{
				listViewHolder=(ViewHolder_ListItem) convertView.getTag();
			}

//			ImageView gridImg=(ImageView) convertView.findViewById(R.id.imageView1);
//			TextView movTitle=(TextView) convertView.findViewById(R.id.imageTitle);

	    /////////////////////Stage_2///////////////////////////////////////////////////////////////////////////////////////////////



			 /////Final Stage
	        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
			Map<String, String> single_row = rowItem.get(position);/// select object number n from the object_array
			//listViewHolder.movTitle.setText(single_row.get("Movie_Name"));
			Picasso.with(context).load(single_row.get("Movie_Img")).into(listViewHolder.movImg);
			//movTitle.setText(single_row.get("Movie_Name")); ///Sets the string value of the TextView---->
			//Picasso.with(context).load(single_row.get("Movie_Img")).into(gridImg);
//			Log.e("---intialize value_1",single_row.get("Movie_Name"));
//			Log.e("---intialize value_2",single_row.get("Movie_Img"));
			Log.e("Number_Of_Adapter_Items--->","---"+getCount()+"");



			// ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
	        return convertView;
	    }
	    
	    


}
 
