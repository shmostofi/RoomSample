package com.example.shokooh.roomsampleapp.main.view.Detail;

import android.arch.lifecycle.LifecycleFragment;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.shokooh.roomsampleapp.R;
import com.example.shokooh.roomsampleapp.main.RoomSampleApplication;
import com.example.shokooh.roomsampleapp.main.data.ListItem;
import com.example.shokooh.roomsampleapp.main.viewmodel.ListItemViewModel;

import java.nio.BufferUnderflowException;

import javax.inject.Inject;

public class DetailFragment extends LifecycleFragment {

    private static final String EXTRA_DATE_ID = "EXTRA_DATE_ID";
    private String itemID;

    private TextView tvDateDetail;
    private TextView tvContentDetail;

    @Inject
    ViewModelProvider.Factory vmpf ;

    private ListItemViewModel livm;

    public static DetailFragment newInstance(String itemID)
    {
        DetailFragment df = new DetailFragment();

        Bundle args = new Bundle();
        args.putString(EXTRA_DATE_ID, itemID);
        df.setArguments(args);
        return df;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((RoomSampleApplication)getActivity().getApplication()).getApplicationComponent().inject(this);

        Bundle args = getArguments();
        itemID = args.getString(EXTRA_DATE_ID);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        livm = ViewModelProviders.of(this, vmpf).get(ListItemViewModel.class);

        livm.getListItem(itemID).observe(this, new Observer<ListItem>() {
            @Override
            public void onChanged(@Nullable ListItem listItem) {
                tvContentDetail.setText(listItem.getContent());
                tvDateDetail.setText(listItem.getDate());
                // TODO: 13/10/2017 set image resource
            }
        });

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_detail, container, false);
        tvContentDetail = (TextView) v.findViewById(R.id.i_tvContentDetail);
        tvDateDetail = (TextView) v.findViewById(R.id.i_tvDateDetail);

        return v;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }


}
