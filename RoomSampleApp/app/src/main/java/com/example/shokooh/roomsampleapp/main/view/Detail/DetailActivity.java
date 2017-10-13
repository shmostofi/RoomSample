package com.example.shokooh.roomsampleapp.main.view.Detail;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shokooh.roomsampleapp.R;
import com.example.shokooh.roomsampleapp.main.util.BaseActivity;

public class DetailActivity extends BaseActivity {

    private static final String TAG_FRAG_DETAIL = "FRAG_DETAIL";
    private static final String EXTRA_DATE_ID = "EXTRA_DATE_ID";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent i = getIntent();

        if (i.hasExtra(EXTRA_DATE_ID))
        {
            FragmentManager fm = getSupportFragmentManager();
            DetailFragment df = (DetailFragment) fm.findFragmentByTag(TAG_FRAG_DETAIL);
            if (df == null) {
                df = DetailFragment.newInstance(i.getStringExtra(EXTRA_DATE_ID));
            }
            addFragmentToActivity(fm, df, R.id.i_containerDetail, TAG_FRAG_DETAIL);
        }
        else
        {
            Toast.makeText(this, "Error Retreiving Item Detail", Toast.LENGTH_LONG).show();
        }
    }
}
