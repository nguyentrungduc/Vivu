package com.example.duc.vivu.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.duc.vivu.DbContext;
import com.example.duc.vivu.MainActivity;
import com.example.duc.vivu.R;
import com.example.duc.vivu.adapters.FeedAdapter;
import com.example.duc.vivu.loaddata.LoadDetailCategory;
import com.example.duc.vivu.models.items.FeedItem;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * A simple {@link Fragment} subclass.
 */
public class CategoryFragment extends Fragment {

    int id;

    @BindView(R.id.rcview)
    RecyclerView recyclerView;

    public static FeedAdapter feedAdapter;

    public static final String TAG = MainActivity.class.toString();

    public CategoryFragment(int id) {
        this.id = id;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_category, container, false);
        ButterKnife.bind(this,view);
        LoadDetailCategory loadDetailCategory =new LoadDetailCategory(
                DbContext.getInstance().findAllCategory().get(id).getLink());
        loadDetailCategory.execute();
        Log.d(TAG, Integer.toString(id)+"kkkkk");

        final LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        feedAdapter = new FeedAdapter(getContext());
        feedAdapter.notifyDataSetChanged();
        recyclerView.setAdapter(feedAdapter);
        Log.d(TAG,"ss"+ FeedItem.list.toString());

        return view;
    }

}
