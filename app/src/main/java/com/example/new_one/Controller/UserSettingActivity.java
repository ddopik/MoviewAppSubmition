package com.example.new_one.Controller;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;

import com.example.new_one.R;

/**
 * Created by ddopik on 10/24/2016.
 */

public class UserSettingActivity extends PreferenceActivity {


 @Override
    public void onCreate(Bundle savedInstanceState)
 {
     super.onCreate(savedInstanceState);
     addPreferencesFromResource(R.layout.preferences);

 }




}
