package com.example.duc.vivu.viewholders;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.duc.vivu.R;
import com.example.duc.vivu.models.items.FeedItem;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by DUC on 07/01/2017.
 */

public class FeedViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.tvfeed)
    TextView tvFeed;
    @BindView(R.id.imvfeed)
    ImageView imvFeed;

    public FeedViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }

    public void setData(FeedItem feedItem, Context context){
        tvFeed.setText(feedItem.getTitle());
        Picasso.with(context).load(feedItem.getLinkImg()).into(imvFeed);

    }


}
