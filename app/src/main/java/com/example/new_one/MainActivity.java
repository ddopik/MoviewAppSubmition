package com.example.new_one;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;;import com.example.new_one.VollyParser.Fragment_main;
import com.facebook.stetho.Stetho;
import com.uphyca.stetho_realm.RealmInspectorModulesProvider;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.exceptions.RealmMigrationNeededException;


public class MainActivity extends AppCompatActivity {


    private static final int RESULT_SETTINGS = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Realm.init(this); // Initialize Realm. Should only be done once when the application starts.
        RealmConfiguration realmConfig = new RealmConfiguration.Builder().build();
//        Realm.deleteRealm(realmConfig); // Delete Realm between app restarts.
        Realm.setDefaultConfiguration(realmConfig);

        Stetho.initialize(
                Stetho.newInitializerBuilder(this)
                        .enableDumpapp(Stetho.defaultDumperPluginsProvider(this))
                        .enableWebKitInspector(RealmInspectorModulesProvider.builder(this).build())
                        .build());

///// Adding fragment dynamiccly thats Really helped for Controlling fragment
        ////getSupportFragmentManager() vs getFragmentManager() ??????######

            FragmentTransaction ft = getFragmentManager().beginTransaction();
            Fragment_main fg = getFrgInstance();
            ft.replace(R.id.ContainerActivityID,fg,"fragment_activity");
            ft.commit();

/////




    }


    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        menu.clear();
        inflater.inflate(R.menu.main, menu);
        Log.e("Test_menu--->", "onCreateOptionsMenu called");
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection

        switch (item.getItemId()) {
            case R.id.Refresh:

                FragmentTransaction ft = getFragmentManager().beginTransaction();
//                Fragment_main_deprecated fg = getFrgInstance();
                Fragment_main fg = getFrgInstance();
                ft.replace(R.id.ContainerActivityID, fg);
                ft.commit();
                Toast.makeText(this, "Refreash", Toast.LENGTH_LONG).show();
                break;

            case R.id.menu_settings:////calling setting activity
                Intent i = new Intent(MainActivity.this, UserSettingActivity.class);
                startActivityForResult(i, RESULT_SETTINGS);
                break;
            case R.id.ViewMyDataBase:////calling ViewMyDataBase
                Intent dbmanager = new Intent(this, AndroidDatabaseManager.class);
                startActivity(dbmanager);

                break;


            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }


    @Override  //////recives  result back from your setting fragment
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case RESULT_SETTINGS:
                showUserSettings();
                break;

        }


    }


    private void showUserSettings() {  ///Call back fncttion called after shared preferance Updated


        //SharedPreferences sharedPrefs = context.getSharedPreferences("setting",context.MODE_PRIVATE);
        SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(this);

        StringBuilder builder = new StringBuilder();

        builder.append("\n prefOrderbyPref: " + sharedPrefs.getString("prefOrderbyPref", "NULL"));
        builder.append("\n prefGenrePref: " + sharedPrefs.getString("prefGenrePref", "NULL"));
        builder.append("\n prefSetYear: " + sharedPrefs.getString("prefSetYear", "NULL"));
        builder.append("\n prefViewByFrequency: " + sharedPrefs.getString("prefViewByFrequency", "NULL"));


        FragmentTransaction ft = getFragmentManager().beginTransaction();
//        Fragment_main_deprecated fg = getFrgInstance();
        Fragment_main fg = getFrgInstance();
        ft.replace(R.id.ContainerActivityID, fg);
        ft.commit();
        Toast.makeText(this, builder.toString(), Toast.LENGTH_LONG).show();

    }


    //public Fragment_main_deprecated getFrgInstance() {   ///creating object of my Main Fragment
    public Fragment_main getFrgInstance() {   ///creating object of my Main Fragment

        SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(this);
        String orderBy = sharedPrefs.getString("prefOrderbyPref", "NULL");
        String genere = sharedPrefs.getString("prefGenrePref", "NULL");
        String year = sharedPrefs.getString("prefSetYear", "NULL");
        String viewBy = sharedPrefs.getString("prefViewByFrequency", "NULL");
//        Fragment_main_deprecated fg = new Fragment_main_deprecated();
        Fragment_main fg = new Fragment_main();
        Bundle arg = new Bundle();

        arg.putString("orderBy", orderBy);
        arg.putString("genere", genere);
        arg.putString("year", year);
        arg.putString("viewBy", viewBy);
        fg.setArguments(arg);
        return fg;
    }


}



