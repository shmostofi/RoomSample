package com.example.shokooh.roomsampleapp.main.view.Detail;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.widget.TextView;
import com.example.shokooh.roomsampleapp.R;
import com.example.shokooh.roomsampleapp.main.util.BaseActivity;

public class DetailActivity extends BaseActivity {
//
//    private final static String EXTRA_DATE = "EXTRA_DATE";
//    private final static String EXTRA_CONTENT = "EXTRA_CONTENT";
//    private final static String EXTRA_COLOR = "EXTRA_COLOR";
//    private TextView tvContent;
//    private TextView tvDate;

    private static final String TAG_FRAG_DETAIL = "FRAG_DETAIL";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

//        tvContent = (TextView)findViewById(R.id.i_tvContentDetail);
//        tvDate= (TextView)findViewById(R.id.i_tvDateDetail);
//        Intent i = getIntent();
//        tvContent.setText(i.getStringExtra(EXTRA_CONTENT));
//        tvDate.setText(i.getStringExtra(EXTRA_DATE));
//        tvDate.setBackgroundResource(i.getIntExtra(EXTRA_COLOR, 0));
//        tvDate.setBackgroundResource(i.getIntExtra(EXTRA_COLOR, 0));


        FragmentManager fm = getSupportFragmentManager();
        DetailFragment df = (DetailFragment) fm.findFragmentByTag(TAG_FRAG_DETAIL);
        if (df == null) {
            df = new DetailFragment();
        }
        addFragmentToActivity(fm, df, R.id.i_containerDetail, TAG_FRAG_DETAIL);
    }
}
