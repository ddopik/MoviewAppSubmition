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
import android.widget.TextView;



import android.app.Activity;
import android.widget.Toast;;

public class MainActivity extends AppCompatActivity {


	private static final int RESULT_SETTINGS = 1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);


	}


	public boolean onCreateOptionsMenu(Menu menu) {

		MenuInflater inflater = getMenuInflater();
		menu.clear();
		inflater.inflate(R.menu.main,menu);
		Log.e("Test_menu--->","onCreateOptionsMenu called");
		return true;
	}


	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle item selection

		switch (item.getItemId()) {
			case R.id.Refresh:
				Fragment frg = null;
				frg = getFragmentManager().findFragmentById(R.id.fragment1);
				final FragmentTransaction ft = getFragmentManager().beginTransaction();
				ft.detach(frg);
				ft.attach(frg);
				ft.commit();
				Toast.makeText(getBaseContext(),"Data updated", Toast.LENGTH_LONG).show();


			case R.id.menu_settings:////calling setting activity
				Intent i = new Intent(MainActivity.this,UserSettingActivity.class);
				startActivityForResult(i,RESULT_SETTINGS);
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


//			SharedPreferences.Editor editor = sharedpreferences.edit();
			SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(this);

			StringBuilder builder = new StringBuilder();

			builder.append("\n Username: "+ sharedPrefs.getString("prefUsername", "NULL"));

			builder.append("\n Send report:"+ sharedPrefs.getBoolean("prefSendReport", false));

			builder.append("\n Sync Frequency: "+ sharedPrefs.getString("prefSyncFrequency", "NULL"));

			//TextView settingsTextView = (TextView) findViewById(R.id.textUserSettings);
			//settingsTextView.setText(builder.toString());
                Toast.makeText(this,builder.toString(),Toast.LENGTH_LONG).show();

		}



	}



