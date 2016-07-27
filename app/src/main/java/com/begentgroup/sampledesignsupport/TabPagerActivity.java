package com.begentgroup.sampledesignsupport;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

public class TabPagerActivity extends AppCompatActivity {

    TabLayout tabs;
    ViewPager pager;
    MyPagerAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_pager);
        tabs = (TabLayout)findViewById(R.id.tabs);
        pager = (ViewPager)findViewById(R.id.pager);
        mAdapter = new MyPagerAdapter(getSupportFragmentManager());

        pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                setTitle("pager : " + position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        pager.setAdapter(mAdapter);

        tabs.setupWithViewPager(pager);

        tabs.removeAllTabs();
        for (int i = 0; i < 10; i++) {
            tabs.addTab(tabs.newTab().setText("TT"+i));
        }


    }
}
