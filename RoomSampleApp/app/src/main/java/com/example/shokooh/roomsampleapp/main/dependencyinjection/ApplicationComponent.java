package com.example.shokooh.roomsampleapp.main.dependencyinjection;

import com.example.shokooh.roomsampleapp.main.view.Create.CreateFragment;
import com.example.shokooh.roomsampleapp.main.view.Detail.DetailFragment;
import com.example.shokooh.roomsampleapp.main.view.List.ListFragment;

import javax.inject.Singleton;

import dagger.Component;
import dagger.Module;

/**
 * Created by shokooh on 2017-10-09.
 */

@Singleton
@Component(modules = {ApplicationModule.class, RoomModule.class})
public interface ApplicationComponent {

    void inject(CreateFragment cf);
    void inject(DetailFragment df);
    void inject(ListFragment lf);

}
