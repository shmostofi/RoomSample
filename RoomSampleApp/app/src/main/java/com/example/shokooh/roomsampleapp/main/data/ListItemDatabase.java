package com.example.shokooh.roomsampleapp.main.data;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

/**
 * Created by shokooh on 2017-10-07.
 */

@Database(entities = {ListItem.class}, version = 1)
public abstract class ListItemDatabase extends RoomDatabase{

    public abstract ListItemDao listItemDao();  // HOW? android new the func!

}
