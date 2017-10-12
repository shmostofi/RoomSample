package com.example.shokooh.roomsampleapp.main.dependencyinjection;

import com.example.shokooh.roomsampleapp.main.RoomSampleApplication;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by shokooh on 2017-10-09.
 */

@Module
public class ApplicationModule {
    private final RoomSampleApplication rsa ;

    public ApplicationModule(RoomSampleApplication rsa_in)
    {
        rsa = rsa_in;
    }

    @Singleton
    @Provides
    public RoomSampleApplication provideApplication()
    {
        return rsa;
    }
}
