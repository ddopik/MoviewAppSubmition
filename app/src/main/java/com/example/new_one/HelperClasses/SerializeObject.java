package com.example.new_one.HelperClasses;

import com.example.new_one.Model.MoviesReviews;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import io.realm.RealmList;

/**
 * Created by ddopik on 10/23/2016.
 */

public class SerializeObject  implements Serializable {


    private List<Map<String,String>> myList;
    private RealmList<MoviesReviews> realmRevList;


    public void setList(List<Map<String,String>> myList)
    {
        this.myList=myList;
    }   public void setRealmList(RealmList<MoviesReviews> myList)
    {
        this.realmRevList=myList;
    }

    public List getList()
    {
        return this.myList;
    }
    public RealmList<MoviesReviews> getRevList()
    {
        return this.realmRevList;
    }
}
