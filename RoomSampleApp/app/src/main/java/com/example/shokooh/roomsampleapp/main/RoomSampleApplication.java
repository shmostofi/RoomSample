package com.example.shokooh.roomsampleapp.main;

import android.app.Application;

import com.example.shokooh.roomsampleapp.main.dependencyinjection.ApplicationComponent;
import com.example.shokooh.roomsampleapp.main.dependencyinjection.DaggerApplicationComponent;

/**
 * Created by shokooh on 2017-10-09.
 */

public class RoomSampleApplication extends Application {
    public ApplicationComponent ac ;

    @Override
    public void onCreate() {
        super.onCreate();
//        ac = DaggerApplicationComponent
    }

    public ApplicationComponent getApplicationComponent(){
        return ac ;
    }
}
