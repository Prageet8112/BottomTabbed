package com.f22labs.instalikefragmenttransaction.Data;

/**
 * Created by prage on 10/21/2017.
 */

public class Contact_Data {
   private String name,number , desig;
    private int image1,image2;

    public Contact_Data(String desig , String name, String number , int image1 , int image2)
    {
        this.desig = desig;
        this.name = name;
        this.number=number;
        this.image1=image1;
        this.image2=image2;
    }

    public String getDesig() {return desig;}
    public String getName() {return name;}
    public int getImage1()
    {
        return image1;
    }
    public String getNumber()
    {
        return number;
    }
    public int getImage2()
    {
        return image2;
    }

}
