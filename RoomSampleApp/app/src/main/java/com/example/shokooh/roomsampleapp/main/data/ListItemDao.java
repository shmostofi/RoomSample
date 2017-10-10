package com.example.shokooh.roomsampleapp.main.data;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

/**
 * Created by smostofi on 18/09/2017.
 */

@Dao
public interface ListItemDao {

    @Query("SELECT * FROM ListItem")
    LiveData<List<ListItem>> getData();

    @Query("SELECT * FROM ListItem WHERE date = :Id")
    LiveData<ListItem> getListItemById(String Id);

    @Delete
    void deleteListItem(ListItem li);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertListItem(ListItem li);
}
