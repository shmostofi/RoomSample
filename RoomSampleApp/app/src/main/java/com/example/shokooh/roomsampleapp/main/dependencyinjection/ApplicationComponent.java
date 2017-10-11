package com.example.shokooh.roomsampleapp.main.dependencyinjection;

import javax.inject.Singleton;

import dagger.Component;
import dagger.Module;

/**
 * Created by shokooh on 2017-10-09.
 */

@Singleton
@Component(modules = {ApplicationModule.class, RoomModule.class})
public interface ApplicationComponent {
}
