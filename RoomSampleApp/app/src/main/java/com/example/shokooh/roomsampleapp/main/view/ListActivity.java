package com.example.shokooh.roomsampleapp.main.view;

import android.content.Intent;
import android.support.design.widget.BaseTransientBottomBar;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
import com.example.shokooh.roomsampleapp.main.data.FakeDataSource;
import com.example.shokooh.roomsampleapp.main.data.ListItem;
import com.example.shokooh.roomsampleapp.main.logic.Controller;

import java.util.List;

public class ListActivity extends AppCompatActivity implements viewInterface, View.OnClickListener{

    private final static String EXTRA_DATE = "EXTRA_DATE";
    private final static String EXTRA_CONTENT = "EXTRA_CONTENT";
    private final static String EXTRA_COLOR = "EXTRA_COLOR";

    private Controller ctrl ;
    private RecyclerView rv;
    private List<ListItem> dataList;
    private CustomAdapter adp;
    private LayoutInflater li ;
    private FloatingActionButton fabNewItem;
    private Toolbar tbMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        rv = (RecyclerView) findViewById(R.id.i_rvMain);
        li = getLayoutInflater();
        fabNewItem = (FloatingActionButton) findViewById(R.id.i_fabNewItem);
        fabNewItem.setOnClickListener(this);


        tbMain = (Toolbar) findViewById(R.id.i_tbMain);
        tbMain.setTitle("List Activity");
        ctrl = new Controller(this, new FakeDataSource());
    }

    @Override
    public void startDetailActivity(String content, String date, int colorResource, View v) {
        Intent i = new Intent(this, DetailActivity.class);
        i.putExtra(EXTRA_CONTENT, content);
        i.putExtra(EXTRA_DATE, date);
        i.putExtra(EXTRA_COLOR, colorResource);

//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            getWindow().setEnterTransition(new Fade(Fade.IN));
//            getWindow().setEnterTransition(new Fade(Fade.OUT));
//
//            ActivityOptions options = ActivityOptions
//                    .makeSceneTransitionAnimation(this,
//                            new Pair<View, String>(v.findViewById(R.id.i_tvContent),"content"),
//                            new Pair<View, String>(v.findViewById(R.id.i_tvDate),"date"));
//
//            startActivity(i, options.toBundle());
//
//
//        }
//        else {
            startActivity(i);
//        }
    }

    public void setDataList(List<ListItem> dataIn) {
        dataList = dataIn ;
        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);
        adp = new CustomAdapter();
        rv.setAdapter(adp);

        ItemTouchHelper ith = new ItemTouchHelper(createHelperCallback());
        ith.attachToRecyclerView(rv);
    }

    @Override
    public void deleteListItem(int position) {
        dataList.remove(position);
        adp.notifyItemRemoved(position);
    }

    private class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder>
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
                ctrl.onListItemClick(clickedItem, v);
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
        public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v = li.inflate(R.layout.item_data, parent, false);
            return new CustomViewHolder(v);
        }

        @Override
        public void onBindViewHolder(CustomViewHolder holder, int position) {
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
                ctrl.onListItemSwiped(
                        position,
                        dataList.get(position)
                );
            }
        };

        return simpleItemTouchCallback;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.i_fabNewItem)
            ctrl.onAddNewClicked(v);
    }

    @Override
    public void addNewItem(ListItem li) {
        dataList.add(li);
        adp.notifyItemInserted(adp.getItemCount());
        rv.smoothScrollToPosition(adp.getItemCount());

    }


    @Override
    public void showUndoSnackbar() {
        Snackbar.make(findViewById(R.id.i_layoutListItem),
                "Item Deleted",
                Snackbar.LENGTH_LONG).
                setAction("UNDO?", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ctrl.onUndoConfirmed();
            }
        })
                .addCallback(new BaseTransientBottomBar.BaseCallback<Snackbar>() {
                    @Override
                    public void onDismissed(Snackbar transientBottomBar, int event) {
                        super.onDismissed(transientBottomBar, event);

                        ctrl.onSnackbarTimeout();
                    }
                }).show();
    }

    @Override
    public void insertListItem(ListItem li, int position) {
        dataList.add(position, li);
        adp.notifyItemInserted(position);
        if(position==adp.getItemCount()-1)
            rv.smoothScrollToPosition(adp.getItemCount());  // does not work as expected
    }
}
