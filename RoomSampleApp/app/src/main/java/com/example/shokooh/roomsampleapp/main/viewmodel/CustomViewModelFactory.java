package com.example.shokooh.roomsampleapp.main.viewmodel;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import com.example.shokooh.roomsampleapp.main.data.ListItemRepository;

import javax.inject.Inject;

/**
 * Created by smostofi on 12/10/2017.
 */

public class CustomViewModelFactory implements ViewModelProvider.Factory {
    private final ListItemRepository lir ;

    @Inject
    public CustomViewModelFactory(ListItemRepository lir) {
        this.lir = lir;
    }

    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {
        if (modelClass.isAssignableFrom(ListItemCollectionViewModel.class))
            return (T) new ListItemCollectionViewModel(lir);
        else if (modelClass.isAssignableFrom(ListItemViewModel.class))
            return (T) new ListItemViewModel(lir);
         else if (modelClass.isAssignableFrom(NewListItemViewModel.class))
            return (T) new NewListItemViewModel(lir);
        else
            throw new IllegalArgumentException("ViewModel Not Found");
    }
}
