package com.example.new_one;

import android.os.Bundle;
import android.preference.PreferenceActivity;

/**
 * Created by ddopik on 10/24/2016.
 */

public class UserSettingActivity extends PreferenceActivity {


 @Override
    public void onCreate(Bundle savedInstanceState)
 {
     super.onCreate(savedInstanceState);
     addPreferencesFromResource(R.layout.settings);


 }
}
