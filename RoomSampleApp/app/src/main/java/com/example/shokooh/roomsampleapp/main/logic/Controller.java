package com.example.shokooh.roomsampleapp.main.logic;

import android.view.View;

import com.example.shokooh.roomsampleapp.main.data.ListItem;
import com.example.shokooh.roomsampleapp.main.data.dataInterface;
import com.example.shokooh.roomsampleapp.main.view.viewInterface;

/**
 * Created by smostofi on 18/09/2017.
 */

public class Controller {

    private viewInterface vi;
    private dataInterface di;
    private ListItem lastDeletedItem;
    private int lastDeletedPosition;

    public Controller(viewInterface view, dataInterface data) {
        vi = view ;
        di = data ;
        setData();
    }

    public void setData()
    {
        vi.setDataList(di.getData());
    }

    public void onListItemClick(ListItem li, View v)
    {
        vi.startDetailActivity(li.getContent(),
                li.getDate(),
                li.getColor(),
                v);
    }

    public void onListItemSwiped(int position, ListItem li)
    {
        vi.deleteListItem(position);
        di.deleteListItem(li);
        lastDeletedItem = li;
        lastDeletedPosition = position;
        vi.showUndoSnackbar();
    }

    public void onAddNewClicked(View v)
    {
        ListItem li = di.createNewItem();
        vi.addNewItem(li);
    }

    public void onUndoConfirmed()
    {
        if (lastDeletedItem!=null)
        {
            vi.insertListItem(lastDeletedItem, lastDeletedPosition);
            di.insertListItem(lastDeletedItem, lastDeletedPosition);
            lastDeletedItem = null;
            lastDeletedPosition = 0;
        }
    }

    public void onSnackbarTimeout()
    {
        lastDeletedItem = null;
        lastDeletedPosition = 0;
    }
}

