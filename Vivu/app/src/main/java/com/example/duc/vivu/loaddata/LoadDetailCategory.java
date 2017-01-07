package com.example.duc.vivu.loaddata;

import android.os.AsyncTask;

import android.util.Log;

import com.example.duc.vivu.MainActivity;
import com.example.duc.vivu.fragments.CategoryFragment;
import com.example.duc.vivu.models.items.FeedItem;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by DUC on 06/01/2017.
 */

public class LoadDetailCategory extends AsyncTask<Void, Void, Void> {

    public static final String TAG = MainActivity.class.toString();
    String link;

    public LoadDetailCategory(String link){
        this.link = link;
    }

    @Override
    protected Void doInBackground(Void... params) {
        try {
            // Connect to the web site
            Document document = Jsoup.connect(link).get();

            ArrayList<String> linkImg = new ArrayList<>();

            Elements elements1 = document.select("img");
            for(Element element : elements1.subList(2,22)){
                Log.d(TAG,element.attr("src").toString());
                linkImg.add(element.attr("src"));
            }

            Elements subjectElements = document.select("header.entry-header");
            if (subjectElements != null && subjectElements.size() > 0) {
                int i = 0;
                Log.d(TAG, String.valueOf(linkImg.size())+"HHHHHHh");
                for (Element element : subjectElements) {
                    Element titleSubject = element.getElementsByTag("h2").first();
                    //   if (titleSubject != null) {
                    String title = titleSubject.text();
                    Log.e(TAG, "doInBackground: " + title);
                    //   }
                    Element srcSubject = element.getElementsByTag("a").first();
                    //    if (srcSubject != null) {
                    String src = srcSubject.attr("href");
                    Log.e(TAG, "doInBackground: " + src);
                    //    }
                    Element dateSubject = element.getElementsByTag("span").first();
                    //    if (dateSubject != null) {
                    String date = dateSubject.text();
                    Log.e(TAG, "doInBackground: " + date);
                    //    }
                    FeedItem feedItem = new FeedItem(title, src, linkImg.get(i)
                            , false);

                    Log.d(TAG, linkImg.get(i).toString()+"  oo");
                    i++;
                    FeedItem.list.add(feedItem);

                }
                Log.d(TAG, String.valueOf(subjectElements.size()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void result) {
        CategoryFragment.feedAdapter.notifyDataSetChanged();


    }

}


