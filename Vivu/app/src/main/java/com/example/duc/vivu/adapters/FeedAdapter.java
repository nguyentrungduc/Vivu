package com.example.duc.vivu.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.duc.vivu.R;
import com.example.duc.vivu.models.items.FeedItem;
import com.example.duc.vivu.viewholders.FeedViewHolder;

/**
 * Created by DUC on 07/01/2017.
 */

public class FeedAdapter extends RecyclerView.Adapter<FeedViewHolder> {

    Context context;
    public FeedAdapter(Context context){
        this.context = context;
    }
    @Override
    public FeedViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View itemview = layoutInflater.inflate(R.layout.feed_item, parent, false);
        FeedViewHolder feedViewHolder = new FeedViewHolder(itemview);
        return  feedViewHolder;
    }

    @Override
    public void onBindViewHolder(FeedViewHolder holder, int position) {
        FeedItem feedItem = FeedItem.list.get(position);
        holder.setData(feedItem, context);

    }

    @Override
    public int getItemCount() {
        return FeedItem.list.size();
    }
}
