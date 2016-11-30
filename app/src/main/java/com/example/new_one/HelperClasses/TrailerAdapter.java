package com.example.new_one.HelperClasses;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.new_one.Model.MoviesReviews;
import com.example.new_one.Model.MoviesTrailer;
import com.example.new_one.R;
import com.example.new_one.View.ViewHolder_ReviewsDialog;

import io.realm.RealmList;

/**
 * Created by ddopik_pc on 28/11/2016.
 */

public class TrailerAdapter extends BaseAdapter {

    Context context;
    RealmList<MoviesTrailer> trailersList;

    public TrailerAdapter(Context context,RealmList<MoviesTrailer> TrailList)

    {

        this.trailersList =TrailList;
        this.context=context;


    }


    @Override
    public int getCount() {
        return trailersList.size();
    }

    @Override
    public Object getItem(int position) {
        return trailersList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return trailersList.indexOf(getItem(position));
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        MoviesTrailer single_row = trailersList.get(position);/// select object number n from the object_array
        ViewHolder_ReviewsDialog RevItemHolder;
        if(convertView==null)
        {
            LayoutInflater mInflater=(LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView=mInflater.inflate(R.layout.single_item_trailers_activity_dialog,null);
            RevItemHolder=new ViewHolder_ReviewsDialog();
            RevItemHolder.RevContent=(TextView) convertView.findViewById(R.id.TrailContentID);
            convertView.setTag(RevItemHolder);
        }
        else
        {
            RevItemHolder=(ViewHolder_ReviewsDialog) convertView.getTag();
        }
//        https://www.youtube.com/watch?v=jXi-ODqD4eQ
        RevItemHolder.RevContent.setText("https://www.youtube.com/watch?v="+single_row.getTrailKey());

        return convertView;
    }
}
