package com.example.administrator.demohttpconnection.Screen.home;

public class UsersGitHub {
    private int mID;
    private String mName;
    private String mDescription;

    public UsersGitHub(int ID, String name, String description) {
        mID = ID;
        mName = name;
        mDescription = description;
    }

    public int getID() {
        return mID;
    }

    public void setID(int ID) {
        mID = ID;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        mDescription = description;
    }
}
