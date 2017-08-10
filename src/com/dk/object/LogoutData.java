package com.dk.object;

import android.app.Application;

public class LogoutData extends Application{
	private String myState;
    public String getState(){
        return myState;
    }
    public void setState(String s){
        myState = s;
    }

}
