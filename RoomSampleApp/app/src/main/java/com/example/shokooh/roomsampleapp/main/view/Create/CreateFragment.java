package com.example.shokooh.roomsampleapp.main.view.Create;

import android.arch.lifecycle.LifecycleFragment;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.shokooh.roomsampleapp.R;
import com.example.shokooh.roomsampleapp.main.RoomSampleApplication;
import com.example.shokooh.roomsampleapp.main.data.ListItem;
import com.example.shokooh.roomsampleapp.main.view.List.ListActivity;
import com.example.shokooh.roomsampleapp.main.viewmodel.NewListItemViewModel;

import javax.inject.Inject;

public class CreateFragment extends LifecycleFragment {

    @Inject
    ViewModelProvider.Factory vmpf;

    private NewListItemViewModel nlivm ;

    private EditText etContentCreate;
    private ImageButton btnSave;
    private ImageButton btnDiscard;
    private ViewPager vpColor;

    private PagerAdapter pa;

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
        View v = inflater.inflate(R.layout.fragment_create, container, false);

        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss a dd/MM/yyyy");
        final String currentDate = sdf.format(new Date());

        etContentCreate = (EditText) v.findViewById(R.id.i_etContentCreate);
        btnDiscard = (ImageButton) v.findViewById(R.id.i_btnDiscard);
        btnSave = (ImageButton) v.findViewById(R.id.i_btnSave);
        vpColor = (ViewPager) v.findViewById(R.id.i_vpColor);

        pa = new ColorPagerAdaptor();
        vpColor.setAdapter(pa);

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
                    ListItem newLisItem = new ListItem(getDrawableResource(vpColor.getCurrentItem()),
                            currentDate, newContent);

                    nlivm.AddNewItemToRepo(newLisItem);
                    startListActivity();
                }
            }
        });
        return v;
    }

    public int getDrawableResource (int pagerItemPosition){
        switch (pagerItemPosition){
            case 0:
                return R.drawable.red_drawable;
            case 1:
                return R.drawable.blue_drawable;
            case 2:
                return R.drawable.green_drawable;
            case 3:
                return R.drawable.yellow_drawable;
            default:
                return 0;
        }
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

    private class ColorPagerAdaptor extends PagerAdapter {

        @Override
        public void startUpdate(ViewGroup container) {
            super.startUpdate(container);
        }

        @Override
        public void finishUpdate(ViewGroup container) {
            super.finishUpdate(container);
        }

        @Override
        public Parcelable saveState() {
            return super.saveState();
        }

        @Override
        public int getItemPosition (Object object) { return POSITION_NONE; }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            LayoutInflater li = LayoutInflater.from(getActivity());
            ImageView iv = (ImageView) li.inflate(R.layout.item_pager, container, false);

            switch (position) {
                case 0:
                    iv.setImageResource(R.drawable.blue_drawable);
                case 1:
                    iv.setImageResource(R.drawable.red_drawable);
                case 2:
                    iv.setImageResource(R.drawable.green_drawable);
                case 3:
                    iv.setImageResource(R.drawable.yellow_drawable);
            }
            container.addView(iv);
            return iv ;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view==object;
        }

        @Override
        public int getCount() {
            return 4;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }
    }
}
