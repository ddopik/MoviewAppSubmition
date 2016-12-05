package io.realm;


public interface MoviesRealmProxyInterface {
    public int realmGet$id();
    public void realmSet$id(int value);
    public String realmGet$Movie_Name();
    public void realmSet$Movie_Name(String value);
    public String realmGet$Movie_Overview();
    public void realmSet$Movie_Overview(String value);
    public String realmGet$Movie_Img();
    public void realmSet$Movie_Img(String value);
    public String realmGet$Moview_Year();
    public void realmSet$Moview_Year(String value);
    public boolean realmGet$Favorate_Movie();
    public void realmSet$Favorate_Movie(boolean value);
    public String realmGet$Movie_Type();
    public void realmSet$Movie_Type(String value);
    public float realmGet$Moview_Rating();
    public void realmSet$Moview_Rating(float value);
    public int realmGet$MovieDuration();
    public void realmSet$MovieDuration(int value);
    public RealmList<com.example.new_one.Model.MoviesTrailer> realmGet$moviesTrailer();
    public void realmSet$moviesTrailer(RealmList<com.example.new_one.Model.MoviesTrailer> value);
    public RealmList<com.example.new_one.Model.MoviesReviews> realmGet$moviesReviews();
    public void realmSet$moviesReviews(RealmList<com.example.new_one.Model.MoviesReviews> value);
}
