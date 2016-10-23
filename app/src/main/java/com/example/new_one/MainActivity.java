package com.example.new_one;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;



import android.app.Activity;
import android.widget.Toast;;

public class MainActivity extends AppCompatActivity {

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
		Context context=getBaseContext();
		switch (item.getItemId()) {
			case R.id.Refresh:
				Fragment frg = null;
				frg = getFragmentManager().findFragmentById(R.id.fragment1);
				final FragmentTransaction ft = getFragmentManager().beginTransaction();
				ft.detach(frg);
				ft.attach(frg);
				ft.commit();

				TextView tt=(TextView) findViewById(R.id.print);
				String vv=tt.getText().toString(); ///debug

				Toast.makeText(getBaseContext(),"Data updated", Toast.LENGTH_LONG).show();
				Toast.makeText(this,vv, Toast.LENGTH_LONG).show();///debug
				return true;

			default:
				return super.onOptionsItemSelected(item);
		}
	}


}



