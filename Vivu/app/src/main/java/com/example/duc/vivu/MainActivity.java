package com.example.duc.vivu;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.duc.vivu.fragments.LoginFragment;
import com.example.duc.vivu.fragments.MainFragment;
import com.example.duc.vivu.loaddata.LoadCategory;
import com.example.duc.vivu.loaddata.LoadDetailCategory;
import com.example.duc.vivu.models.items.CategoryItem;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = MainActivity.class.toString();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EventBus.getDefault().register(this);
        ButterKnife.bind(this);
        if(DbContext.getInstance().getSizeCategory() == 0){
            new LoadCategory().execute();
        }
        else changeFragment(new MainFragment(),false,null);
        for(CategoryItem categoryItem :DbContext.getInstance().findAllCategory()){
            Log.d(TAG, categoryItem.getLink()+ categoryItem.getId()+"hihi");
        }


    }

    public void changeFragment(Fragment fragment, boolean addToBackstack, String tag){
        android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.activity_main, fragment);
        if(addToBackstack){
            fragmentTransaction.addToBackStack(tag);
        }
        fragmentTransaction.commit();
    }

    @Subscribe
    public void onEvent(LoadCategoryEvent loadCategoryEvent){
      //  changeFragment(new LoginFragment(), false, null);
        Log.d(TAG, String.valueOf(CategoryItem.list.size()+"hh"));
        if(DbContext.getInstance().getSizeCategory() == 0){
            for(CategoryItem categoryItem : CategoryItem.list){
                DbContext.getInstance().addCategory(categoryItem);
            }
        }

    }

}
