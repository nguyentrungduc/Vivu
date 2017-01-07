package com.example.duc.vivu;

import android.content.Context;

import com.example.duc.vivu.models.items.CategoryItem;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by DUC on 06/01/2017.
 */

public class DbContext {
    private Realm realm;

    public DbContext(Context context){
        Realm.init(context);
        realm = Realm.getDefaultInstance();

    }

    private static DbContext instance;

    public static DbContext getInstance(){
        return instance;
    }

    public static void init(Context context){
        if(instance == null) {
            instance = new DbContext(context);
        }
    }

    public void addCategory(CategoryItem categoryItem){
        realm.beginTransaction();
        realm.copyToRealm(categoryItem);
        realm.commitTransaction();
    }

    public List<CategoryItem> findAllCategory(){
        Realm realm = Realm.getDefaultInstance();
        RealmResults<CategoryItem> categoryItems =
                realm.where(CategoryItem.class)
                        .findAll();
        return categoryItems;
    }

    public int getSizeCategory(){
        Realm realm = Realm.getDefaultInstance();
        RealmResults<CategoryItem> categoryItems =
                realm.where(CategoryItem.class)
                        .findAll();
        return categoryItems.size();
    }



}
