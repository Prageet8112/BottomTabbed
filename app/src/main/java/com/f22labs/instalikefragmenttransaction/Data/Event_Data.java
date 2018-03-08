package com.f22labs.instalikefragmenttransaction.Data;

/**
 * Created by prage on 3/7/2018.
 */

public class Event_Data {
    private String name1 , name2;
    private int image1 , image2;

    public Event_Data(String name1,int image1 , String name2 , int image2)
    {
        this.name1 = name1;
        this.image1=image1;
        this.name2 = name2;
        this.image2 = image2;
    }

    public String getName1()
    {
        return name1;
    }
    public int getImage1()
    {
        return image1;
    }
    public String getName2()
    {
        return name2;
    }
    public int getImage2()
    {
        return image2;
    }


}
