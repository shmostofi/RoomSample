package com.example.shokooh.roomsampleapp.main.data;

import android.arch.lifecycle.LiveData;

import com.example.shokooh.roomsampleapp.R;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;

import javax.inject.Inject;

/**
 * Created by smostofi on 18/09/2017.
 */

public class ListItemRepository {

    private final ListItemDao lid ; // our repo is hooked with one & only one dao

    @Inject
    public ListItemRepository(ListItemDao lid_in) {
       lid = lid_in;
    }

    public LiveData<List<ListItem>> getItems() {
        return lid.getData();
    }

    public LiveData<ListItem> getItemById(String Id) {
        return lid.getItemById(Id);
    }

    public void deleteListItem(ListItem li) {
        lid.deleteListItem(li);
    }

    public void insertListItem(ListItem li) {
        lid.insertListItem(li);
    }
}
