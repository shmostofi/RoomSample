package com.example.shokooh.roomsampleapp.main.view;

import android.view.View;

import com.example.shokooh.roomsampleapp.main.data.ListItem;

import java.util.List;

/**
 * Created by smostofi on 18/09/2017.
 */

public interface viewInterface {

    void setDataList(List<ListItem> data);
    void startDetailActivity(String content, String date, int colorResource, View v);
    void deleteListItem(int position);
    void addNewItem(ListItem li);
    void showUndoSnackbar();
    void insertListItem(ListItem li, int position);
}
