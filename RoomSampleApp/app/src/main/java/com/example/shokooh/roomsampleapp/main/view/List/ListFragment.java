package com.example.shokooh.roomsampleapp.main.view.List;


import android.arch.lifecycle.LifecycleFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.shokooh.roomsampleapp.R;
import com.example.shokooh.roomsampleapp.main.data.FakeDataSource;
import com.example.shokooh.roomsampleapp.main.data.ListItem;
import com.example.shokooh.roomsampleapp.main.viewmodel.Controller;

import java.util.List;

public class ListFragment extends LifecycleFragment implements View.OnClickListener{

    private final static String EXTRA_DATE = "EXTRA_DATE";
    private final static String EXTRA_CONTENT = "EXTRA_CONTENT";
    private final static String EXTRA_COLOR = "EXTRA_COLOR";

    private RecyclerView rv;
    private List<ListItem> dataList;
    private ListFragment.CustomAdapter adp;
    private LayoutInflater li ;
    private FloatingActionButton fabNewItem;
    private Toolbar tbMain;

    public ListFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v =  inflater.inflate(R.layout.fragment_list, container, false);
        rv = (RecyclerView) v.findViewById(R.id.i_rvMain);
        li = getActivity().getLayoutInflater();
        fabNewItem = (FloatingActionButton) v.findViewById(R.id.i_fabNewItem);
        fabNewItem.setOnClickListener(this);


        tbMain = (Toolbar) v.findViewById(R.id.i_tbMain);
        tbMain.setTitle("List Activity");
//        ctrl = new Controller(this, new FakeDataSource());// TODO: 2017-09-28 add proper replace

        return v;
    }

    // TODO: 2017-09-28  main tasks here: 0- deploy the recyclerView, Adaptor and ViewHolder 1- get click event on fab, run CreateAct 2- get click event on VH, run the DetailAct 3- swipe for deletion

    private class CustomAdapter extends RecyclerView.Adapter<ListFragment.CustomAdapter.CustomViewHolder>
    {
        class CustomViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
        {
            private TextView tvDate;
            private TextView tvContent;
            private ImageView ivLogo;
            private ViewGroup container;

            @Override
            public void onClick(View v) {
                ListItem clickedItem = dataList.get(getAdapterPosition());
//                ctrl.onListItemClick(clickedItem, v); // TODO: 2017-09-28 add proper replace
            }

            public CustomViewHolder(View itemView) {
                super(itemView);
                tvDate = (TextView) itemView.findViewById(R.id.i_tvDate);
                tvContent = (TextView) itemView.findViewById(R.id.i_tvContent);
                ivLogo = (ImageView) itemView.findViewById(R.id.i_ivLogo);
                container = (ViewGroup) itemView.findViewById(R.id.i_layoutListItem);

                container.setOnClickListener(this);
            }
        }

        @Override
        public ListFragment.CustomAdapter.CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v = li.inflate(R.layout.item_data, parent, false);
            return new ListFragment.CustomAdapter.CustomViewHolder(v);
        }

        @Override
        public void onBindViewHolder(ListFragment.CustomAdapter.CustomViewHolder holder, int position) {
            ListItem currentItem = dataList.get(position);
            holder.tvDate.setText(currentItem.getDate());
            holder.tvContent.setText(currentItem.getContent());
            holder.ivLogo.setImageResource(currentItem.getColor());
        }

        @Override
        public int getItemCount() {
            return dataList.size();
        }
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.i_fabNewItem)
        {//            ctrl.onAddNewClicked(v);// TODO: 2017-09-28 add proper replace
        }
    }
}
