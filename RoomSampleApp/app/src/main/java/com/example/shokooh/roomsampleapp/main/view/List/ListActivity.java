package com.example.shokooh.roomsampleapp.main.view.List;

import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import com.example.shokooh.roomsampleapp.R;
import com.example.shokooh.roomsampleapp.main.util.BaseActivity;

public class ListActivity extends BaseActivity {

    private final static String TAG_FRAG_LIST = "FRAG_LIST";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        FragmentManager fm = getSupportFragmentManager();
        ListFragment lf =  (ListFragment) fm.findFragmentByTag(TAG_FRAG_LIST);
        if (lf == null){
            lf = new ListFragment();
        }
        addFragmentToActivity(fm, lf, R.id.i_containerList, TAG_FRAG_LIST);
    }
}
