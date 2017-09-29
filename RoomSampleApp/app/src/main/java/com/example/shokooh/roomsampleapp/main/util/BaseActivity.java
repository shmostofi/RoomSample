package com.example.shokooh.roomsampleapp.main.util;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by shokooh on 2017-09-28.
 */

public class BaseActivity extends AppCompatActivity {

    public static void addFragmentToActivity(FragmentManager fm, Fragment f, int containerID, String fragTag)
    {
        fm.beginTransaction().replace(containerID, f, fragTag).commit();
    }
}
