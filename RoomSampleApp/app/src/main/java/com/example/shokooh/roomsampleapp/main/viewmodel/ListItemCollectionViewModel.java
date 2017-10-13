package com.example.shokooh.roomsampleapp.main.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.os.AsyncTask;

import com.example.shokooh.roomsampleapp.main.data.ListItem;
import com.example.shokooh.roomsampleapp.main.data.ListItemRepository;

import java.util.List;

/**
 * Created by smostofi on 12/10/2017.
 */

public class ListItemCollectionViewModel extends ViewModel {
    private final ListItemRepository lir;

    public ListItemCollectionViewModel(ListItemRepository lir) {
        this.lir = lir;
    }

    public LiveData<List<ListItem>> getListOfItems()
    {
        return lir.getListItems();
    }

    private class DeleteItemTask extends AsyncTask<ListItem, Void, Void>
    {
        @Override
        protected Void doInBackground(ListItem... params) {
            lir.deleteListItem(params[0]);
            return null;
        }
    }

    public void deleteListItem(ListItem li)
    {
        DeleteItemTask dit = new DeleteItemTask();
        dit.execute(li);
    }
}
