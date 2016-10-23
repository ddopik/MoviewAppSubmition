package com.example.new_one;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by ddopik on 10/23/2016.
 */

public class SerializeObject  implements Serializable {


    private List<Map<String,String>> myList;


    public void setList(List<Map<String,String>> myList)
    {
        this.myList=myList;
    }

    public List getList()
    {
        return this.myList;
    }
}
