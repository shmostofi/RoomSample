package com.example.shokooh.roomsampleapp.main.data;

import com.example.shokooh.roomsampleapp.R;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by smostofi on 18/09/2017.
 */

public class FakeDataSource implements dataInterface {

    public FakeDataSource() {
        random = new Random();
    }

    private static final int sizeOfCollection = 12 ;
    private Random random;

    private final String[] contents = {
            "here is message one",
            "here is message two",
            "here is message three",
            "here is message four",
    };

    private final String[] dates = {
            "6:30AM 06/01/2017",
            "9:26PM 04/22/2013",
            "2:01PM 12/02/2015",
            "2:43AM 09/7/2018"
    };

    private final int[] drawables = {
//            R.drawable.green_drawable,
//            R.drawable.red_drawable,
//            R.drawable.blue_drawable,
//            R.drawable.yellow_drawable,
            R.color.GREEN,
            R.color.BLUE,
            R.color.RED,
            R.color.YELLOW
    };
    @Override
    public List<ListItem> getData() {

        ArrayList<ListItem> outputList = new ArrayList<>();
        for(int i=0 ; i<sizeOfCollection ; i++)
        {
            ListItem li = new ListItem(drawables[random.nextInt(4)],dates[random.nextInt(4)], contents[random.nextInt(4)]);
            outputList.add(li);
        }
        return outputList;
    }

    @Override
    public void deleteListItem(ListItem li) {

    }

    @Override
    public ListItem createNewItem() {
        ListItem li = new ListItem(drawables[random.nextInt(4)],dates[random.nextInt(4)], contents[random.nextInt(4)]);
        return li;
    }

    @Override
    public void insertListItem(ListItem li, int position) {

    }
}
