package com.example.new_one.Controller_interfacer;

import android.app.Activity;

import com.example.new_one.Model.MoviesReviews;

import java.util.List;
import java.util.Map;

import io.realm.RealmList;
import io.realm.RealmObject;

/**
 * Created by ddopik_pc on 28/11/2016.
 */

public interface SingleMoviewDialogtListner {
    public void startReviewDialogFragment(Activity mainActivity, RealmList<MoviesReviews> jasonApiItems);
}
