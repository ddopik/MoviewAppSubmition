package com.example.new_one.Controller;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.example.new_one.Controller_interfacer.SingleMoviewFragmentListner;
import com.example.new_one.HelperClasses.AndroidDatabaseManager;
import com.example.new_one.HelperClasses.SerializeObject;
import com.example.new_one.R;
import com.facebook.stetho.Stetho;
import com.uphyca.stetho_realm.RealmInspectorModulesProvider;

import java.util.List;
import java.util.Map;

import io.realm.Realm;
import io.realm.RealmConfiguration;

import static android.view.View.INVISIBLE;


public class MainActivity extends AppCompatActivity {

    boolean twoPane=false;
    private static final int RESULT_SETTINGS = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Realm.init(this); // Initialize Realm. Should only be done once when the application starts.
        RealmConfiguration realmConfig = new RealmConfiguration.Builder().build();
        Realm.setDefaultConfiguration(realmConfig);

        Stetho.initialize(
                Stetho.newInitializerBuilder(this)
                        .enableDumpapp(Stetho.defaultDumperPluginsProvider(this))
                        .enableWebKitInspector(RealmInspectorModulesProvider.builder(this).build())
                        .build());

///// Adding fragment dynamiccly thats Really helped for Controlling fragment


            FragmentTransaction ft = getFragmentManager().beginTransaction();
            Fragment_main fg = getFrgInstance();
           //// ft.addToBackStack(null);///This means that the transaction will be remembered after it is committed, and will reverse its operation when later popped off the stack.
            ft.replace(R.id.ContainerActivityID,fg,"fragment_activity"); ///we are Not Deleting the container we are Deleting it's content
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
                Fragment_main fg = getFrgInstance();
                //// ft.addToBackStack(null);///This means that the transaction will be remembered after it is committed, and will reverse its operation when later popped off the stack.
                ft.replace(R.id.ContainerActivityID,fg,"fragment_activity"); ///we are Not Deleting the container we are Deleting it's content
                ft.commit();
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


                                               ///this Fragment created for Mobile View
    public Fragment_main getFrgInstance() {   ///creating object of my Main Fragment Required for SaredPreferance

        SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(this);
        String orderBy = sharedPrefs.getString("prefOrderbyPref", "NULL");
        String genere = sharedPrefs.getString("prefGenrePref", "NULL");
        String year = sharedPrefs.getString("prefSetYear", "NULL");
        String viewBy = sharedPrefs.getString("prefViewByFrequency", "NULL");

        Fragment_main fg = new Fragment_main();

        fg.setFrgListner(new SingleMoviewFragmentListner(){
            @Override
            public void createFrgListner(List<Map<String,String>> jasonItems,int position) {

                SerializeObject intentVar=new SerializeObject();
                intentVar.setList(jasonItems);
                Intent myIntent = new Intent(MainActivity.this, SingleMoviewActivity.class);

                myIntent.putExtra("singleMoview", intentVar);
                myIntent.putExtra("position", position);
                if(findViewById(R.id.SingleMoviewFragment2)==null) {

                    startActivity(myIntent);
                }
                else
                {
                    SingleMoviewFragment fgs = SingleMoviewFragment.newInstance(intentVar, position);
                    FragmentTransaction ft = getFragmentManager().beginTransaction();
//                    SingleMoviewFragment fgs=new SingleMoviewFragment ();
//                    SingleMoviewFragment fgs =SingleMoviewFragment.newInstance(intentVar, position);
                    // ft.addToBackStack(null);///This means that the transaction will be remembered after it is committed, and will reverse its operation when later popped off the stack.
                    ft.replace(R.id.SingleMoviewFragment2,fgs); ///we are Not Deleting the container we are Deleting it's content
                    ft.commit();
                }
            }
        }); ///intializing Fragment Interface


        Bundle arg = new Bundle();
        arg.putString("orderBy", orderBy);
        arg.putString("genere", genere);
        arg.putString("year", year);
        arg.putString("viewBy", viewBy);
        fg.setArguments(arg);
        return fg;
    }



}



