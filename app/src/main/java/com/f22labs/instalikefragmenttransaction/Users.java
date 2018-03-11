package com.f22labs.instalikefragmenttransaction;

/**
 * Created by Zonoid on 3/8/2018.
 */

public class Users {
    String name,roll,branch,sem,mobile,email,password;
    public Users(String n,String r,String b,String s,String m,String e,String p){
        name=n;
        roll=r;
        branch=b;
        sem=s;
        mobile=m;
        email=e;
        password=p;
    }

    public String getName() {
        return name;
    }

    public String getRoll() {
        return roll;
    }

    public String getBranch() {
        return branch;
    }

    public String getSem() {
        return sem;
    }

    public String getMobile() {
        return mobile;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

}
