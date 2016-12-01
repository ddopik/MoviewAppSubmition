package com.example.new_one.Controller_interfacer;

import android.app.Activity;

import com.example.new_one.Model.Movies;

import java.util.List;
import java.util.Map;

import io.realm.RealmList;
import io.realm.RealmResults;

/**
 * Created by ddopik on 22/11/2016.
 */

public interface VollyAdapter {

    public  void setMainAdapter(Activity mainActivity,RealmResults<Movies> jasonApiItems);
}
