package com.example.new_one.Model;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.new_one.MainActivity;

import java.io.InputStream;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmObject;
import io.realm.RealmResults;
import io.realm.annotations.Ignore;
import io.realm.annotations.PrimaryKey;
import io.realm.internal.Context;
import io.realm.internal.IOException;

/**
 * Created by ddopik on 08/11/2016.
 */

public class RealmContract     {

    private Realm realm;
    private String jasonString;

public RealmContract(String myJasonStrin) {
    realm = Realm.getDefaultInstance();
    this.jasonString=myJasonStrin;

    setQuery();
}




    public void setQuery()
    {

        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {

                realm.createObjectFromJson(Movies.class,jasonString);
//                realm.createAllFromJson(Movies.class,jasonString);
//                realm.createOrUpdateObjectFromJson(Movies.class, jasonString);

            }
        });
    }


    public void getQuery(Activity ac)
    {
        Log.e("Get Realm query --->","Start");
        RealmResults<Movies> movies;

        int  i=0;
                RealmResults<Movies>  mv = realm.where(Movies.class).findAll();
                for (Movies movie : mv) {
                    Toast.makeText(ac,"here-->"+i,Toast.LENGTH_LONG).show();
                    //Toast.makeText(ac,+i+"--"+"values-->"+movie.getPoster_path(),Toast.LENGTH_LONG).show();
                    Log.e("Real VAlue --->",movie.getPoster_path());
                    i++;
                }


    }

}
