package com.example.new_one.Model;
import android.app.Activity;
import android.os.Bundle;

import java.io.InputStream;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmObject;
import io.realm.annotations.Ignore;
import io.realm.annotations.PrimaryKey;
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



//    private void loadJsonFromStream() throws IOException {
//        // Use streams if you are worried about the size of the JSON whether it was persisted on disk
//        // or received from the network.
//        InputStream stream = getAssets().open("cities.json");
//
//        // Open a transaction to store items into the realm
//        realm.beginTransaction();
//        try {
//            realm.createAllFromJson(City.class, stream);
//            realm.commitTransaction();
//        } catch (IOException e) {
//            // Remember to cancel the transaction if anything goes wrong.
//            realm.cancelTransaction();
//        } finally {
//            if (stream != null) {
//                stream.close();
//            }
//        }
//    }

    public void setQuery()
    {
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {

                realm.createAllFromJson(Movies.class, jasonString);
            }
        });
    }

}
