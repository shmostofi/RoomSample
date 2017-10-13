package com.example.shokooh.roomsampleapp.main.view.Create;

import android.arch.lifecycle.LifecycleFragment;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.shokooh.roomsampleapp.R;
import com.example.shokooh.roomsampleapp.main.RoomSampleApplication;
import com.example.shokooh.roomsampleapp.main.viewmodel.NewListItemViewModel;

import javax.inject.Inject;

public class CreateFragment extends LifecycleFragment {

    @Inject
    ViewModelProvider.Factory vmpf;

    private NewListItemViewModel nlivm ;

    // TODO: 13/10/2017 add the widget references

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((RoomSampleApplication)getActivity().getApplication()).getApplicationComponent().inject(this);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        // TODO: 13/10/2017 set up the viewModel connection 
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_create, container, false);

        // TODO: 13/10/2017 fill in widget references

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
