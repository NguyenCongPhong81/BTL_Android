package com.example.btl_android_tkb.TKB.acti;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.btl_android_tkb.TKB.sukien.SuKienFragment;
import com.example.btl_android_tkb.TKB.thoigianbieu.ThoiGianBieuFragment;


public class ThoiKhoaBieuAdapter extends FragmentStatePagerAdapter {


    public ThoiKhoaBieuAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new ThoiGianBieuFragment();
            case 1:
                return new SuKienFragment();
            default:
                return new ThoiGianBieuFragment();
        }

    }

    @Override
    public int getCount() {
        return 2;
    }
}
