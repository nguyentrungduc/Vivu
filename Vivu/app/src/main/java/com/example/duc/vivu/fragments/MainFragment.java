package com.example.duc.vivu.fragments;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.duc.vivu.DbContext;
import com.example.duc.vivu.R;
import com.example.duc.vivu.Utils;
import com.example.duc.vivu.adapters.PagerAdapter;
import com.example.duc.vivu.models.items.CategoryItem;
import com.example.duc.vivu.models.items.FeedItem;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {


    private static final String TAG = MainFragment.class.toString();
    @BindView(R.id.tab_layout)
    TabLayout tabLayout;
    @BindView(R.id.viewpaper)
    ViewPager viewPager;
    @BindView(R.id.ivm_category)
    ImageView imvCategory;



    public MainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.bind(this,view);
        setup();
        return view;
    }

    private void setup(){
        for(CategoryItem categoryItem : DbContext.getInstance().findAllCategory()){
            Log.d(TAG,categoryItem.getTitle());
            tabLayout.addTab(tabLayout.newTab().setText(categoryItem.getTitle()));
        }
        final PagerAdapter pagerAdapter = new PagerAdapter(
                getActivity().getSupportFragmentManager(),tabLayout.getTabCount()
        );
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        viewPager.setAdapter(pagerAdapter);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                Log.d(TAG, "onPageSelected"+String.valueOf(position));
                int idRes = Utils.GetIdByName("category_"
                        +Integer.toString(position),getContext());
                imvCategory.setImageResource(idRes);
                FeedItem.list.clear();
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

}
