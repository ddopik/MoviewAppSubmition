package com.example.new_one.Model;
import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmObject;
import io.realm.annotations.Ignore;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class Movies  extends RealmObject  {


@PrimaryKey
    private int id;
    @Required
    private String original_title;
    @Required
    private String overview;
    @Required
    private String poster_path;
    @Ignore
    private String release_date;
    @Ignore
    private float popularity;
    @Ignore
    private float vote_average;
    @Ignore
    private int vote_count;


}
