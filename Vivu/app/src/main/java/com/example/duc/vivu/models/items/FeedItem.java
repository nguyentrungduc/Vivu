package com.example.duc.vivu.models.items;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DUC on 06/01/2017.
 */

public class FeedItem {
    private String title;
    private String linkURL;
    private String linkImg;
    private boolean favourite;


    public FeedItem(String title, String linkURL, String linkImg, boolean favourite) {
        this.title = title;
        this.linkURL = linkURL;
        this.linkImg = linkImg;
        this.favourite = favourite;
    }

    public FeedItem(){

    }

    public String getLinkURL() {
        return linkURL;
    }

    public void setLinkURL(String linkURL) {
        this.linkURL = linkURL;
    }

    public String getLinkImg() {
        return linkImg;
    }

    public void setLinkImg(String linkImg) {
        this.linkImg = linkImg;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isFavourite() {
        return favourite;
    }

    public void setFavourite(boolean favourite) {
        this.favourite = favourite;
    }

    public static List<FeedItem> list = new ArrayList<FeedItem>();
}
