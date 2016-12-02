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
import android.widget.Toast;
import com.example.new_one.Controller_interfacer.SingleMoviewFragmentListner;
import com.example.new_one.HelperClasses.AndroidDatabaseManager;
import com.example.new_one.R;
import com.facebook.stetho.Stetho;
import com.uphyca.stetho_realm.RealmInspectorModulesProvider;

import io.realm.Realm;
import io.realm.RealmConfiguration;


public class MainActivity extends AppCompatActivity {

    boolean twoPane=false;
    private static final int RESULT_SETTINGS = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//        Realm.init(this); // Initialize Realm. Should only be done once when the application starts.
//        RealmConfiguration realmConfig = new RealmConfiguration.Builder().build();
//        Realm.setDefaultConfiguration(realmConfig);

        Stetho.initialize(
                Stetho.newInitializerBuilder(this)
                        .enableDumpapp(Stetho.defaultDumperPluginsProvider(this))
                        .enableWebKitInspector(RealmInspectorModulesProvider.builder(this).build())
                        .build());

///// Adding fragment dynamiccly thats Really helped for Controlling fragment


            FragmentTransaction ft = getFragmentManager().beginTransaction();
            MoviesListFragment fg = getFrgInstance();
            ft.replace(R.id.ContainerActivityID,fg,"fragment_activity"); ///we are Not Deleting the container we are Deleting it's content
//            ft.addToBackStack(null);///This means that the transaction will be remembered after it is committed, and will reverse its operation when later popped off the stack.
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
                MoviesListFragment fg = getFrgInstance();
                ft.replace(R.id.ContainerActivityID,fg,"fragment_activity"); ///we are Not Deleting the container we are Deleting it's content
                ft.addToBackStack(null);///This means that the transaction will be remembered after it is committed, and will reverse its operation when later popped off the stack.
                ft.commit();
                break;

            case R.id.menu_settings:////calling setting activity
                Intent i = new Intent(MainActivity.this, UserSettingActivity.class);
                startActivityForResult(i, RESULT_SETTINGS);
                break;
//            case R.id.ViewMyDataBase:////calling ViewMyDataBase
//                Intent dbmanager = new Intent(this, AndroidDatabaseManager.class);
//                startActivity(dbmanager);
//                break;


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


        SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(this);

        StringBuilder builder = new StringBuilder();

        builder.append("\n prefOrderbyPref: " + sharedPrefs.getString("prefOrderbyPref", "NULL"));




        FragmentTransaction ft = getFragmentManager().beginTransaction();
        MoviesListFragment fg = getFrgInstance();
        ft.replace(R.id.ContainerActivityID, fg);
        ft.addToBackStack(null);///This means that the transaction will be remembered after it is committed, and will reverse its operation when later popped off the stack.
        ft.commit();
        Toast.makeText(this, builder.toString(), Toast.LENGTH_LONG).show();

    }


                                               ///this Fragment created for Mobile View
    public MoviesListFragment getFrgInstance() {   ///creating object of my Main Fragment Required for SaredPreferance

        SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(this);
        String orderBy = sharedPrefs.getString("prefOrderbyPref", "Top Rated");
        String viewBy = sharedPrefs.getString("prefViewByFrequency", "List");


        MoviesListFragment fg = new MoviesListFragment();

        Bundle arg = new Bundle();
        arg.putString("orderBy", orderBy);
        arg.putString("viewBy", viewBy);
        fg.setArguments(arg);

        fg.setFrgListner(new SingleMoviewFragmentListner(){
            @Override
            public void createFrgListner(int movieID) {


                Intent myIntent = new Intent(MainActivity.this, SingleMoviewActivity.class);
                myIntent.putExtra("MovieID",movieID);
                if(findViewById(R.id.SingleMoviewFragment2)==null) {
                    startActivity(myIntent);
                }
                else
                {

                    SingleMoviewFragment fgs =new SingleMoviewFragment();
                    Bundle arg=new Bundle();
                    arg.putInt("myMovieID",movieID);
                    fgs.setArguments(arg);
                    FragmentTransaction ft = getFragmentManager().beginTransaction();
                    // ft.addToBackStack(null);///This means that the transaction will be remembered after it is committed, and will reverse its operation when later popped off the stack.
                    ft.replace(R.id.SingleMoviewFragment2,fgs); ///we are Not Deleting the container we are Deleting it's content
                    ft.commit();
                }
            }
        }); ///intializing Fragment Interface



        return fg;
    }
    public void setActionBarTitle(String title) {
        getSupportActionBar().setTitle(title);
    }


}



