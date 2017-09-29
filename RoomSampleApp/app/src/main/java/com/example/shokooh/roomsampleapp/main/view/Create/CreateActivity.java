package com.example.shokooh.roomsampleapp.main.view.Create;

import android.support.v4.app.FragmentManager;
import android.os.Bundle;

import com.example.shokooh.roomsampleapp.R;
import com.example.shokooh.roomsampleapp.main.util.BaseActivity;
import com.example.shokooh.roomsampleapp.main.view.Detail.DetailFragment;

public class CreateActivity extends BaseActivity {

    private static final String TAG_FRAG_CREATE = "FRAG_CREATE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);

        FragmentManager fm = getSupportFragmentManager();
        CreateFragment cf = (CreateFragment) fm.findFragmentByTag(TAG_FRAG_CREATE);
        if (cf == null) {
            cf = new CreateFragment();
        }
        addFragmentToActivity(fm, cf, R.id.i_containerCreate, TAG_FRAG_CREATE);}
}
