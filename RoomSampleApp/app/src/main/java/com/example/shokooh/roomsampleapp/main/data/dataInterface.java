package com.example.shokooh.roomsampleapp.main.data;

import java.util.List;

/**
 * Created by smostofi on 18/09/2017.
 */

public interface dataInterface {

    List<ListItem> getData();

    void deleteListItem(ListItem li);

    ListItem createNewItem();

    void insertListItem(ListItem li, int position);
}
