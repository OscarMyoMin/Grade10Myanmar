package com.oscarmyomin.grade10_myanmar;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.oscarmyomin.grade10_myanmar.adapter.TabAdapter;
import com.oscarmyomin.grade10_myanmar.fragment.PoemFragment;

public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;
    TabAdapter tabAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.viewpager);
        tabLayout = findViewById(R.id.tablayout);

        tabAdapter = new TabAdapter(getSupportFragmentManager());
        tabAdapter.addFragment(new PoemFragment(), "Poem");

        viewPager.setAdapter(tabAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }
}
