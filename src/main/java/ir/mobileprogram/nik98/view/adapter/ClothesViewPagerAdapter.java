package ir.mobileprogram.nik98.view.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import ir.mobileprogram.nik98.view.fragment.ClothesFragment;

public class ClothesViewPagerAdapter extends FragmentPagerAdapter {
    public ClothesViewPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:return "مشاهده شده ها" ;
            case 1:return "برترین ها" ;
            case 2:return "پر بازدیدترین ها" ;
            default:return ""; } }
    @NonNull
    @Override
    public Fragment getItem(int position) {
        return ClothesFragment.newInstance();
    }
    @Override
    public int getCount() {
        return 3;
    }
}
