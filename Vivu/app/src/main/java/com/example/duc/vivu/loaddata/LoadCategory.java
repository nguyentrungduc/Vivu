package com.example.duc.vivu.loaddata;

import android.os.AsyncTask;
import android.util.Log;

import com.example.duc.vivu.Constant;
import com.example.duc.vivu.LoadCategoryEvent;
import com.example.duc.vivu.MainActivity;
import com.example.duc.vivu.Utils;
import com.example.duc.vivu.models.items.CategoryItem;

import org.greenrobot.eventbus.EventBus;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * Created by DUC on 04/01/2017.
 */

public class LoadCategory extends AsyncTask<Void,Void,Void> {
    public static final String TAG = MainActivity.class.toString();
    @Override
    protected Void doInBackground(Void... params) {
        try {
            Document document = Jsoup.connect(Constant.CATEGORY).get();

            Elements subjectElements = document.select("ul.sub-menu");
            if (subjectElements != null && subjectElements.size() > 0) {
                Elements elements = subjectElements.select("a");
                int i = 0;
                for(Element e : elements.subList(1,13)){
                    String link = e.attr("href");
                    Log.d(TAG,link);
                    Log.d(TAG,e.text());
                    String title = Utils.getCategory(e.text());
                    CategoryItem categoriesItem = new CategoryItem(i, title,link);
                    CategoryItem.list.add(categoriesItem);
                    i++;
                }
                Log.d(TAG, CategoryItem.list.toString());

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void result) {
        Log.d(TAG,"da change");
        EventBus.getDefault().post(new LoadCategoryEvent());
    }
}
