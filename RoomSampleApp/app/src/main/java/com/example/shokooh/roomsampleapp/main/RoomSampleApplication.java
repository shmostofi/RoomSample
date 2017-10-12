package com.example.shokooh.roomsampleapp.main;

import android.app.Application;

import com.example.shokooh.roomsampleapp.main.dependencyinjection.ApplicationComponent;
import com.example.shokooh.roomsampleapp.main.dependencyinjection.ApplicationModule;
import com.example.shokooh.roomsampleapp.main.dependencyinjection.DaggerApplicationComponent;
import com.example.shokooh.roomsampleapp.main.dependencyinjection.RoomModule;

/**
 * Created by shokooh on 2017-10-09.
 */

public class RoomSampleApplication extends Application {
    public ApplicationComponent ac ;

    @Override
    public void onCreate() {
        super.onCreate();

        // initialize the ApplicationComponent
        ac = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .roomModule(new RoomModule(this))
                .build();
    }

    public ApplicationComponent getApplicationComponent(){
        return ac ;
    }
}
