package com.example.shokooh.roomsampleapp.main.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.shokooh.roomsampleapp.R;

public class DetailActivity extends AppCompatActivity {

    private final static String EXTRA_DATE = "EXTRA_DATE";
    private final static String EXTRA_CONTENT = "EXTRA_CONTENT";
    private final static String EXTRA_COLOR = "EXTRA_COLOR";

    private TextView tvContent;
    private TextView tvDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        tvContent = (TextView)findViewById(R.id.i_tvContentDetail);
        tvDate= (TextView)findViewById(R.id.i_tvDateDetail);

        Intent i = getIntent();
        tvContent.setText(i.getStringExtra(EXTRA_CONTENT));
        tvDate.setText(i.getStringExtra(EXTRA_DATE));
//        tvDate.setBackgroundResource(i.getIntExtra(EXTRA_COLOR, 0));
        tvDate.setBackgroundResource(i.getIntExtra(EXTRA_COLOR, 0));
    }
}
