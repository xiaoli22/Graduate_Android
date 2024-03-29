package com.example.graduate_android.fragmentchart;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.graduate_android.fragmentchart.AccountFragment;
import com.example.graduate_android.fragmentchart.BaseFragment;
import com.example.graduate_android.fragmentchart.MenbersFragment;
import com.example.graduate_android.fragmentchart.ProjectFragment;

/**
 * @author: HP
 * @date: 2023/3/3
 * 选择器
 */
public class OrdersPagerAdapter extends FragmentStateAdapter {

//    public OrdersPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
//        super(fragmentActivity);
//    }

    public OrdersPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new BaseFragment();
//            case 1:
//                return new AccountFragment();
            case 1:
                return new MenbersFragment();
            case 2:
                return new ProjectFragment();
        }
        return null;
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
