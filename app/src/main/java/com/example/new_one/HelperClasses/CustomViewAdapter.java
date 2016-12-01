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
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.new_one.Model.Movies;
import com.example.new_one.Model.RealmContract;
import com.example.new_one.R;
import com.example.new_one.View.ViewHolder_ListItem;
import com.like.LikeButton;
import com.squareup.picasso.Picasso;

import io.realm.RealmList;
import io.realm.RealmResults;

///Create a Custom adapter which extends ""'BaseAdapter""" , 
///this is used for inflating each row items of the listfragment 
///with list_item.xml layout inside getView method.

public class CustomViewAdapter extends BaseAdapter  {
	
	    Context context;
	RealmResults<Movies>  rowItem;

	    public CustomViewAdapter(Context context,RealmResults<Movies> rowItem) {
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
				listViewHolder.movID=(TextView) convertView.findViewById(R.id.mainMovieId);
				listViewHolder.favBtn=(LikeButton) convertView.findViewById(R.id.star_button);
				                                     //// store the holder with the view.
				convertView.setTag(listViewHolder);////used to mark a view in its hierarchy and does not have to be unique within the hierarchy.
				                                  //// Tags can also be used to store data within a view without resorting to another data structure.
	        }
			else
			{
				listViewHolder=(ViewHolder_ListItem) convertView.getTag();
			}



	    /////////////////////Stage_2///////////////////////////////////////////////////////////////////////////////////////////////



			 /////Final Stage
	        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
			Movies single_row = rowItem.get(position);/// select object number n from the object_array
			int ids=single_row.getId();
			String mvID=Integer.toString(ids);
			Picasso.with(context).load(single_row.getMovie_Img()).into(listViewHolder.movImg);
			listViewHolder.movID.setText(mvID);
			if(single_row.isFavorate_Movie())
			{
				listViewHolder.favBtn.setLiked(true);
			}
			listViewHolder.favBtn.setOnClickListener(favListner);
			Log.e("Number_Of_Adapter_Items--->","---"+getCount()+"");



			// ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
	        return convertView;
	    }


	View.OnClickListener favListner=new View.OnClickListener(){
		@Override
		public void onClick(View v) {

			RelativeLayout singleItem=(RelativeLayout) v.getParent();
			LikeButton likeButton=(LikeButton) v.findViewById(R.id.star_button);
			TextView mvIdView=(TextView) singleItem.findViewById(R.id.mainMovieId);
			String SmvID=mvIdView.getText().toString();
			RealmContract myRealm=new RealmContract();
			String state=myRealm.setMoviewToFav(Integer.parseInt(SmvID));
			if (state.equals("Added to favorites"))
			{
				likeButton.setLiked(true);
			}
			else
			{
				likeButton.setLiked(false);
			}

			Toast.makeText(context,state,Toast.LENGTH_SHORT).show();

		}
	};


}
 
