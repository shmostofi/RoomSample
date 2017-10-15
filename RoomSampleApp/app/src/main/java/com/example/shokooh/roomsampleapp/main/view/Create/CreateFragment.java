package com.example.shokooh.roomsampleapp.main.view.Create;

import android.arch.lifecycle.LifecycleFragment;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import java.text.SimpleDateFormat;
import java.util.Date;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.shokooh.roomsampleapp.R;
import com.example.shokooh.roomsampleapp.main.RoomSampleApplication;
import com.example.shokooh.roomsampleapp.main.data.ListItem;
import com.example.shokooh.roomsampleapp.main.view.List.ListActivity;
import com.example.shokooh.roomsampleapp.main.viewmodel.NewListItemViewModel;

import javax.inject.Inject;

/*
there should be save button - onClick : pass the created ListItem object into nlivm, it will take care of creating a new entry in repo then in db
there should be discard button - onClick : launch listAct
what to put in Observe
 */
public class CreateFragment extends LifecycleFragment {

    @Inject
    ViewModelProvider.Factory vmpf;

    private NewListItemViewModel nlivm ;

    private TextView tvDateCreate;
    private EditText etContentCreate;
    private Button btnSave;
    private Button btnDiscard;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((RoomSampleApplication)getActivity().getApplication()).getApplicationComponent().inject(this);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        nlivm = ViewModelProviders.of(this, vmpf).get(NewListItemViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_create, container, false);

        tvDateCreate = (TextView) v.findViewById(R.id.i_tvDateCreate);
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm dd/MM/yyyy");
        final String currentDate = sdf.format(new Date());
        tvDateCreate.setText(currentDate);

        etContentCreate = (EditText) v.findViewById(R.id.i_etContentCreate);
        btnDiscard = (Button) v.findViewById(R.id.i_btnDiscard);
        btnSave = (Button) v.findViewById(R.id.i_btnSave);

        btnDiscard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startListActivity();
            }
        });

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newContent = etContentCreate.getText().toString();
                if ( !newContent.isEmpty() )
                {
                    ListItem newLisItem = new ListItem(R.color.colorAccent, currentDate, newContent);
                    nlivm.AddNewItemToRepo(newLisItem);
                    startListActivity();
                }
            }
        });
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

    public void startListActivity()
    {
        startActivity(new Intent(getActivity(), ListActivity.class));
    }


}
