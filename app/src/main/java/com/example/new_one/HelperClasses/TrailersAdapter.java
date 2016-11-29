package com.example.new_one.HelperClasses;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.new_one.R;
import com.example.new_one.View.ViewHolder_ReviewsDialog;

import java.util.List;
import java.util.Map;

/**
 * Created by ddopik_pc on 28/11/2016.
 */

public class TrailersAdapter extends BaseAdapter {

    Context context;
    List<Map<String,String>> trailListl;

    public TrailersAdapter(Context context,List<Map<String,String>> trailListl)
    {
        this.trailListl=trailListl;
        this.context=context;

    }
    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder_ReviewsDialog revHolder=new ViewHolder_ReviewsDialog();

        if(convertView==null)
        {
            LayoutInflater mInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.custom_single_item, null);
        }

        return null;
    }
}
