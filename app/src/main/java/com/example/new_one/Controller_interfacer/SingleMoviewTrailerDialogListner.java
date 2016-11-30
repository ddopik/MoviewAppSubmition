package com.example.new_one.Controller_interfacer;

import android.app.Activity;

import com.example.new_one.Model.MoviesReviews;
import com.example.new_one.Model.MoviesTrailer;

import java.util.List;
import java.util.Map;

import io.realm.RealmList;

/**
 * Created by ddopik_pc on 28/11/2016.
 */

public interface SingleMoviewTrailerDialogListner {
    public void startTrailersDialogFragment(Activity mainActivity, RealmList<MoviesTrailer> jasonApiItems);
}
