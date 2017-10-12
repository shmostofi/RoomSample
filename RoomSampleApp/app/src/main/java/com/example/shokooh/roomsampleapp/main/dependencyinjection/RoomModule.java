package com.example.shokooh.roomsampleapp.main.dependencyinjection;

import android.arch.persistence.room.Room;

import com.example.shokooh.roomsampleapp.main.RoomSampleApplication;
import com.example.shokooh.roomsampleapp.main.data.ListItemDatabase;

import dagger.Module;

/**
 * Created by shokooh on 2017-10-09.
 */

@Module
public class RoomModule {

    private final ListItemDatabase lid ;
    public RoomModule(RoomSampleApplication rsa_in)
    {
//        lid = Room.databaseBuilder(rsa_in, )

    }
}
