package com.example.shokooh.roomsampleapp.main.viewmodel;

import android.arch.lifecycle.ViewModel;
import android.os.AsyncTask;

import com.example.shokooh.roomsampleapp.main.data.ListItem;
import com.example.shokooh.roomsampleapp.main.data.ListItemRepository;

/**
 * Created by smostofi on 12/10/2017.
 */

public class NewListItemViewModel extends ViewModel {
    private final ListItemRepository lir;

    public NewListItemViewModel(ListItemRepository lir) {
        this.lir = lir;
    }

    private class AddItemTask extends AsyncTask<ListItem,Void,Void>
    {
        @Override
        protected Void doInBackground(ListItem... params) {
            lir.insertListItem(params[0]);
            return null;
        }
    }
    public void AddNewItemToRepo(ListItem li)
    {
        new AddItemTask().execute(li);
    }
}
