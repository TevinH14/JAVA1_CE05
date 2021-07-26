package com.example.hamiltontevin_ce05;

public class Person {
    private String  mFirstName = "";
    private String mLastName  = "";
    private String mDate = "";
    private Integer mUserImage;
    private String mID;
    private String mDescription;

    Person(String firstName, String lastName, String date, Integer userImage,String id,String description){
        mFirstName = firstName;
        mLastName = lastName;
        mDate = date;
        mUserImage = userImage;
        mID = id;
        mDescription = description;
    }

    public String getFirstName(){return mFirstName;}
    public String getLastName(){return mLastName;}
    public String getDate(){return mDate;}
    public Integer getUserImage(){ return mUserImage;}
    public String getId(){return mID;}
    public String getDescription(){return mDescription;}

}

