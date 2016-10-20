package com.example.new_one;
import java.util.List;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

///Create a Custom adapter which extends ""'BaseAdapter""" , 
///this is used for inflating each row items of the listfragment 
///with list_item.xml layout inside getView method.

public class CustomViewAdapter extends BaseAdapter  {
	
	    Context context;

	    List<RowItem> rowItem;
	    public CustomViewAdapter(Context context, List<RowItem> rowItem) {
	        this.context = context;
	        this.rowItem = rowItem;

	    }
	/////Stage 1 --->Helper class Adapter need it
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

	        if (convertView == null) {
	            LayoutInflater mInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
	            convertView = mInflater.inflate(R.layout.custom_list_item, null);
	        }	        
	        ImageView imgIcon = (ImageView) convertView.findViewById(R.id.icon);
	        TextView txtTitle = (TextView) convertView.findViewById(R.id.title);
	    /////////////////////Stage_2///////////////////////////////////////////////////////////////////////////////////////////////



			 /////Final Stage
	        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
			RowItem single_row = rowItem.get(position);/// select object number n from the object_array


			    ///that initialized earlier in the constructor
			  ///row_pos now holding one object at specific position
	        imgIcon.setImageResource(single_row.getIcon()); ///Sets a drawable as the content of this ImageView
			/// setting the image resource and title
	        txtTitle.setText(single_row.getTitle()); ///Sets the string value of the TextView
              ///note that Title and icon have been intialized and being seted during the Fragment_activity  loop ^_^
			// ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
	        return convertView;
	    }
	    
	    


}
 
