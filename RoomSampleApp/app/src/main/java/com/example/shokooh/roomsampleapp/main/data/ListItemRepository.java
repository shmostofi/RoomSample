package com.example.shokooh.roomsampleapp.main.data;

import android.arch.lifecycle.LiveData;

import java.util.List;

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

    public LiveData<List<ListItem>> getListItems() {
        return lid.getData();
    }

    public LiveData<ListItem> getListItemById(String Id) {

        return lid.getListItemById(Id);
    }

    public void deleteListItem(ListItem li) {

        lid.deleteListItem(li);
    }

    public void insertListItem(ListItem li) {

        lid.insertListItem(li);
    }
}
