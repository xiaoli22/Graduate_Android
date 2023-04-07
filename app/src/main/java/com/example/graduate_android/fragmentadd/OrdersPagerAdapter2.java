package com.example.graduate_android.fragmentadd;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class OrdersPagerAdapter2 extends FragmentStateAdapter {

    public OrdersPagerAdapter2(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }


    @NonNull
    @Override
    public Fragment createFragment(int position) {
            switch (position){
                case 0:
                    return new OutcomeFragment();
                case 1:
                    return new IncomeFragment();
                case 2:
                    return new TransferFragment();
                case 3:
                    return new BalanceFragment();
//                case 4:
//                    return new LoanFragment();
                case 4:
                    return new ReimbursementFragment();
            }
            return null;
    }


    @Override
    public int getItemCount() {
        return 5;
    }
}
