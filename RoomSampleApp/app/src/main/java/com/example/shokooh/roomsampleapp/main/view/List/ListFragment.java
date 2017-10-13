package com.example.shokooh.roomsampleapp.main.view.List;


import android.arch.lifecycle.LifecycleFragment;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.shokooh.roomsampleapp.R;
import com.example.shokooh.roomsampleapp.main.RoomSampleApplication;
import com.example.shokooh.roomsampleapp.main.data.ListItem;
import com.example.shokooh.roomsampleapp.main.view.Create.CreateActivity;
import com.example.shokooh.roomsampleapp.main.view.Detail.DetailActivity;
import com.example.shokooh.roomsampleapp.main.viewmodel.ListItemCollectionViewModel;

import java.util.List;

import javax.inject.Inject;

public class ListFragment extends LifecycleFragment {

    @Inject
    ViewModelProvider.Factory vmf;

    ListItemCollectionViewModel licvm;

    private final static String EXTRA_DATE = "EXTRA_DATE";

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
        ((RoomSampleApplication)getActivity().getApplication()).getApplicationComponent().inject(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v =  inflater.inflate(R.layout.fragment_list, container, false);
        rv = (RecyclerView) v.findViewById(R.id.i_rvMain);
        li = getActivity().getLayoutInflater();
        fabNewItem = (FloatingActionButton) v.findViewById(R.id.i_fabNewItem);
        fabNewItem.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                startCreateActivity();
            }
        });
        tbMain = (Toolbar) v.findViewById(R.id.i_tbMain);
        tbMain.setTitle("List Activity");
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        licvm = ViewModelProviders.of(this, vmf).get(ListItemCollectionViewModel.class);
        licvm.getListOfItems().observe(this, new Observer<List<ListItem>>() {
            @Override
            public void onChanged(@Nullable List<ListItem> listItems) {
                if (dataList==null)
                    setDataList(listItems);
            }
        });
    }

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
                startDetailActivity(clickedItem.getDate(), v);
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

    public void startDetailActivity(String dateID, View v) {
        Intent i = new Intent(getActivity(), DetailActivity.class);
        i.putExtra(EXTRA_DATE, dateID);

//
////        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
////            getWindow().setEnterTransition(new Fade(Fade.IN));
////            getWindow().setEnterTransition(new Fade(Fade.OUT));
////
////            ActivityOptions options = ActivityOptions
////                    .makeSceneTransitionAnimation(this,
////                            new Pair<View, String>(v.findViewById(R.id.i_tvContent),"content"),
////                            new Pair<View, String>(v.findViewById(R.id.i_tvDate),"date"));
////
////            startActivity(i, options.toBundle());
////
////
////        }
////        else {
        startActivity(i);
////        }
    }

    public void setDataList(List<ListItem> dataIn) {
        dataList = dataIn ;
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        rv.setLayoutManager(llm);
        adp = new CustomAdapter();
        rv.setAdapter(adp);

        ItemTouchHelper ith = new ItemTouchHelper(createHelperCallback());
        ith.attachToRecyclerView(rv);
    }

    private ItemTouchHelper.Callback createHelperCallback() {
        /*First Param is for Up/Down motion, second is for Left/Right.
        Note that we can supply 0, one constant (e.g. ItemTouchHelper.LEFT), or two constants (e.g.
        ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) to specify what directions are allowed.
        */
        ItemTouchHelper.SimpleCallback simpleItemTouchCallback = new ItemTouchHelper.SimpleCallback(
                0,
                ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {

            //not used, as the first parameter above is 0
            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder,
                                  RecyclerView.ViewHolder target) {
                return false;
            }


            @Override
            public void onSwiped(final RecyclerView.ViewHolder viewHolder, int swipeDir) {
                int position = viewHolder.getAdapterPosition();
                licvm.deleteListItem(dataList.get(position));
                dataList.remove(position);
                adp.notifyItemRemoved(position);
            }
        };

        return simpleItemTouchCallback;
    }

    public void startCreateActivity() {
        Intent i = new Intent(getActivity(), CreateActivity.class);
        startActivity(i);
    }


//    @Override
//    public void showUndoSnackbar() {
//        Snackbar.make(findViewById(R.id.i_layoutListItem),
//                "Item Deleted",
//                Snackbar.LENGTH_LONG).
//                setAction("UNDO?", new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        ctrl.onUndoConfirmed();
//                    }
//                })
//                .addCallback(new BaseTransientBottomBar.BaseCallback<Snackbar>() {
//                    @Override
//                    public void onDismissed(Snackbar transientBottomBar, int event) {
//                        super.onDismissed(transientBottomBar, event);
//
//                        ctrl.onSnackbarTimeout();
//                    }
//                }).show();
//    }
//
//    @Override
//    public void insertListItem(ListItem li, int position) {
//        dataList.add(position, li);
//        adp.notifyItemInserted(position);
//        if(position==adp.getItemCount()-1)
//            rv.smoothScrollToPosition(adp.getItemCount());  // does not work as expected
//    }
//
 }
