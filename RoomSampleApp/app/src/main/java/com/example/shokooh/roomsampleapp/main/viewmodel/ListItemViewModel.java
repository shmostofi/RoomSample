package com.example.shokooh.roomsampleapp.main.viewmodel;

import android.arch.lifecycle.ViewModel;

import com.example.shokooh.roomsampleapp.main.data.ListItemRepository;

/**
 * Created by smostofi on 12/10/2017.
 */

public class ListItemViewModel extends ViewModel {
    private final ListItemRepository lir;

    public ListItemViewModel(ListItemRepository lir) {
        this.lir = lir;
    }
}
