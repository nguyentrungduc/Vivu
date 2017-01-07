package com.example.duc.vivu;

import android.content.Context;
import android.content.res.Resources;

/**
 * Created by DUC on 04/01/2017.
 */

public class Utils {


    public static String getCategory(String category){
        StringBuilder s = new StringBuilder();
        String[] strings = category.split(" ");
        for(int i = 2; i < strings.length; i++){
            s.append(strings[i]);
            if(i == strings.length - 1)  break;
            s.append(" ");
        }
        return  s.toString();

    }

    public static String getURL(String category){
        String[] strings = category.split(" ");
        StringBuilder s = new StringBuilder();
        for(int i = 0; i < strings.length; i ++){
            s.append(strings[i]);
            if(i == strings.length - 1)   break;
            s.append("-");
        }
        return  s.toString();
    }

    public static int GetIdByName(String name, Context context){
        Resources res = context.getResources();
        return res.getIdentifier(name,"drawable",context.getPackageName());
    }


}
