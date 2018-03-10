package com.f22labs.instalikefragmenttransaction.Data;

/**
 * Created by prage on 3/9/2018.
 */

public class SubActData {
    private String SubActName ;
    private int SubActImage ;

    public SubActData(String SubActName,int SubActImage)
    {
        this.SubActName = SubActName;
        this.SubActImage=SubActImage;
    }

    public String getName1()
    {
        return SubActName;
    }
    public int getImage1()
    {
        return SubActImage;
    }
  }
