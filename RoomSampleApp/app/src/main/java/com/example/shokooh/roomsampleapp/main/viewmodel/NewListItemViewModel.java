package com.example.shokooh.roomsampleapp.main.viewmodel;

import android.arch.lifecycle.ViewModel;

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

    public void AddNewItemToRepo(ListItem li)
    {
        lir.insertListItem(li);
    }
}
