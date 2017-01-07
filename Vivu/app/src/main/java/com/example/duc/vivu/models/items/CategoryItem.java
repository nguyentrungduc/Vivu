package com.example.duc.vivu.models.items;

import java.util.ArrayList;
import java.util.List;

import io.realm.RealmObject;

/**
 * Created by DUC on 04/01/2017.
 */

public class CategoryItem extends RealmObject{
    private int id;
    private String title;
    private String link;

    public CategoryItem(int id, String title, String link) {
        this.id = id;
        this.title = title;
        this.link = link;
    }

    public CategoryItem() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public String toString() {
        return "CategoriesItem{" +
                "id=" + id +
                ", title='" + title + '\'' +" "+link +
                '}';
    }

    public static List<CategoryItem> list = new ArrayList<CategoryItem>();

}
