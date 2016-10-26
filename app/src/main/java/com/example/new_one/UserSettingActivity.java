package com.example.new_one;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;

/**
 * Created by ddopik on 10/24/2016.
 */

public class UserSettingActivity extends PreferenceActivity {


 @Override
    public void onCreate(Bundle savedInstanceState)
 {
     super.onCreate(savedInstanceState);
     addPreferencesFromResource(R.layout.preferences);


//     Context context = getBaseContext();
//     SharedPreferences prefs = context.getSharedPreferences("setting",context.MODE_PRIVATE);
//     SharedPreferences.OnSharedPreferenceChangeListener spChanged = new
//             SharedPreferences.OnSharedPreferenceChangeListener() {
//                 @Override
  //               public void onSharedPreferenceChanged(SharedPreferences sharedPreferences,String key) {
//                     if (key.equals("prefViewByFrequency")) {
//                         Context context = getBaseContext();
//                         SharedPreferences prefs = context.getSharedPreferences("setting",context.MODE_PRIVATE);
//                         SharedPreferences.Editor editor = prefs.edit();
//                         editor.putString("viewByValue", "value");
//                         editor.commit();
//                     }
               //  }
             //};
//     prefs.registerOnSharedPreferenceChangeListener(spChanged);


 }




}
