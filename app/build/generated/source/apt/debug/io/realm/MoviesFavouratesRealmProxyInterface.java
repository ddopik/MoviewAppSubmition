package io.realm;


public interface MoviesFavouratesRealmProxyInterface {
    public int realmGet$Movie_ID();
    public void realmSet$Movie_ID(int value);
    public Boolean realmGet$Favourates_Movies();
    public void realmSet$Favourates_Movies(Boolean value);
    public RealmList<com.example.new_one.Model.Movies> realmGet$Movie();
    public void realmSet$Movie(RealmList<com.example.new_one.Model.Movies> value);
}
