package com.example.new_one.Model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by ddopik on 09/11/2016.
 */

public class MoviePages extends RealmObject {
    @PrimaryKey
    private int page_id;
    private int PageNumber;

    public int getPage_id() {
        return page_id;
    }

    public void setPage_id(int page_id) {
        this.page_id = page_id;
    }

    public int getPageNumber() {
        return PageNumber;
    }

    public void setPageNumber(int pageNumber) {
        PageNumber = pageNumber;
    }
}
