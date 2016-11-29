package com.example.new_one.Controller_interfacer;

import android.app.Activity;

import java.util.List;
import java.util.Map;

/**
 * Created by ddopik on 22/11/2016.
 */

public interface VollyAdapter {

    public  void setMainAdapter(Activity mainActivity, List<Map<String, String>> jasonApiItems);
}
