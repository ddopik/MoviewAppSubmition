package com.example.new_one.TestClasses;

/**
 * Created by ddopik on 28/10/2016.
 */
public class MyShow {

    private int showID;
    private String showType;
    private String showOrigin;

    public MyShow(String showName, String showOrigin) {
        this.showType = showName;
        this.showOrigin = showOrigin;
    }

public MyShow(){}

    public MyShow(int showID, String showType, String showOrigin) {
        this.showID = showID;
        this.showType = showType;
        this.showOrigin = showOrigin;
    }

    public String getShowType() {
        return showType;
    }

    public void setShowType(String showType) {
        this.showType = showType;
    }


    public int getShowID() {
        return showID;
    }

    public void setShowID(int showID) {
        this.showID = showID;
    }




    public String getShowOrigin() {
        return showOrigin;
    }

    public void setShowOrigin(String showOrigin) {
        this.showOrigin = showOrigin;
    }
}
