package com.example.new_one.HelperClasses;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.new_one.Model.MoviesReviews;
import com.example.new_one.R;
import com.example.new_one.View.ViewHolder_ReviewsDialog;

import io.realm.RealmList;

/**
 * Created by ddopik_pc on 28/11/2016.
 */

public class ReviewsAdapter extends BaseAdapter {

    Context context;
    RealmList<MoviesReviews> reviewsList ;

    public ReviewsAdapter(Context context,RealmList<MoviesReviews> RevList)

    {
        this.context=context;
        this.reviewsList=RevList;


    }


    @Override
    public int getCount() {
        return reviewsList.size();
    }

    @Override
    public Object getItem(int position) {
        return reviewsList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return reviewsList.indexOf(getItem(position));
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        MoviesReviews single_row = reviewsList.get(position);/// select object number n from the object_array
        ViewHolder_ReviewsDialog RevItemHolder;
        if(convertView==null)
        {
            LayoutInflater mInflater=(LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView=mInflater.inflate(R.layout.single_item_reviews_activity_dialog,null);
            RevItemHolder=new ViewHolder_ReviewsDialog();
            RevItemHolder.RevContent=(TextView) convertView.findViewById(R.id.RevContentID);
            convertView.setTag(RevItemHolder);
        }
        else
        {
            RevItemHolder=(ViewHolder_ReviewsDialog) convertView.getTag();
        }

        RevItemHolder.RevContent.setText(single_row.getContent());

        return convertView;
    }
}
