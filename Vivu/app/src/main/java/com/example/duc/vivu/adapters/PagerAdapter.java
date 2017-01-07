package com.example.duc.vivu.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;

import com.example.duc.vivu.MainActivity;
import com.example.duc.vivu.fragments.CategoryFragment;

/**
 * Created by DUC on 06/01/2017.
 */

public class PagerAdapter extends FragmentStatePagerAdapter {
    private static final String TAG = MainActivity.class.toString();
    int nbofTabs;

    public PagerAdapter(FragmentManager fm,int nbofTabs) {
        super(fm);
        this.nbofTabs = nbofTabs;
    }

    @Override
    public Fragment getItem(int position) {
        for(int i = 0 ; i < nbofTabs; i ++){
            if(i == position) {
                Log.d(TAG,"abc"+position);

                return new CategoryFragment(i);
            }
        }
        return null;
    }

    @Override
    public int getCount() {
        return nbofTabs;
    }
}
