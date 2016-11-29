package com.example.new_one.Controller_interfacer;

import android.app.Activity;

import java.util.List;
import java.util.Map;

/**
 * Created by ddopik_pc on 28/11/2016.
 */

public interface SingleMoviewTrailerDialogListner {
    public void startTrailersDialogFragment(Activity mainActivity, List<Map<String, String>> jasonApiItems);
}
