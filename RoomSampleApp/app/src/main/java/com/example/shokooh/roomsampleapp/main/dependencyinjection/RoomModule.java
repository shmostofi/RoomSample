package com.example.shokooh.roomsampleapp.main.dependencyinjection;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.persistence.room.Room;

import com.example.shokooh.roomsampleapp.main.RoomSampleApplication;
import com.example.shokooh.roomsampleapp.main.data.ListItemDao;
import com.example.shokooh.roomsampleapp.main.data.ListItemDatabase;
import com.example.shokooh.roomsampleapp.main.data.ListItemRepository;
import com.example.shokooh.roomsampleapp.main.viewmodel.CustomViewModelFactory;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by shokooh on 2017-10-09.
 */

@Module
public class RoomModule {

    private final ListItemDatabase lid ;
    public RoomModule(RoomSampleApplication rsa_in)
    {
        lid = Room.databaseBuilder(rsa_in, ListItemDatabase.class, "ListItemDatabse.db").build();
    }

    @Singleton
    @Provides
    ListItemDatabase provideListItemDatabase()
    {
        return lid;
    }

    @Singleton
    @Provides
    ListItemDao provideListItemDao(ListItemDatabase lid_in)
    {
        return lid_in.listItemDao();
    }

    @Singleton
    @Provides
    ListItemRepository provideListItemRepository(ListItemDao lida_in)
    {
        return new ListItemRepository(lida_in);
    }

    @Singleton
    @Provides
    ViewModelProvider.Factory provideViewModelFactory(ListItemRepository lir)
    {
        return new CustomViewModelFactory(lir);
    }

}
