package com.example.new_one;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.app.Activity;
import android.widget.Toast;;import io.realm.Realm;

public class MainActivity extends AppCompatActivity {


	private static final int RESULT_SETTINGS = 1;
	/////


	/////
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Realm.init(this);  // Initialize Realm. Should only be done once when the application starts.

///// Adding fragment dynamiccly thats Really helped for Controlling fragment
		FragmentTransaction ft = getFragmentManager().beginTransaction();
		Fragment_main fg = getFrgInstance();
		ft.add(R.id.ContainerActivityID, fg);
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


	private void showUserSettings() {


		//SharedPreferences sharedPrefs = context.getSharedPreferences("setting",context.MODE_PRIVATE);
		SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(this);

		StringBuilder builder = new StringBuilder();

		builder.append("\n prefOrderbyPref: " + sharedPrefs.getString("prefOrderbyPref", "NULL"));
		builder.append("\n prefGenrePref: " + sharedPrefs.getString("prefGenrePref", "NULL"));
		builder.append("\n prefSetYear: " + sharedPrefs.getString("prefSetYear", "NULL"));
		builder.append("\n prefViewByFrequency: " + sharedPrefs.getString("prefViewByFrequency", "NULL"));



		FragmentTransaction ft = getFragmentManager().beginTransaction();
		Fragment_main fg =getFrgInstance();
		ft.replace(R.id.ContainerActivityID, fg);
		ft.commit();
		Toast.makeText(this, builder.toString(), Toast.LENGTH_LONG).show();

	}


	public Fragment_main getFrgInstance() {

		SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(this);
		String orderBy = sharedPrefs.getString("prefOrderbyPref", "NULL");
		String genere = sharedPrefs.getString("prefGenrePref", "NULL");
		String year = sharedPrefs.getString("prefSetYear", "NULL");
		String viewBy = sharedPrefs.getString("prefViewByFrequency", "NULL");
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



