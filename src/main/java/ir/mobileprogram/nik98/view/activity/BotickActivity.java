package ir.mobileprogram.nik98.view.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import ir.mobileprogram.nik98.R;
import ir.mobileprogram.nik98.view.adapter.ClothesViewPagerAdapter;

public class BotickActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_botick);
        TabLayout tabLayout=(TabLayout)findViewById(R.id.tabLayout) ;
        ViewPager viewPager=(ViewPager)findViewById(R.id.viewpager);
        ClothesViewPagerAdapter adapter=new ClothesViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }


}
