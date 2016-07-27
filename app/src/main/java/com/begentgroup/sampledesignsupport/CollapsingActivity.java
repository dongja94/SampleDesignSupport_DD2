package com.begentgroup.sampledesignsupport;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

public class CollapsingActivity extends AppCompatActivity {

    AppBarLayout appBar;
    RecyclerView listView;
    MyAdapter mAdapter;
    TabLayout tabs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collapsing);
        setSupportActionBar((Toolbar)findViewById(R.id.toolbar));

        listView = (RecyclerView)findViewById(R.id.rv_list);
        mAdapter = new MyAdapter();
        listView.setAdapter(mAdapter);
        listView.setLayoutManager(new LinearLayoutManager(this));

        tabs = (TabLayout)findViewById(R.id.tabs);
        tabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                initData((String)tab.getTag());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        tabs.addTab(tabs.newTab().setText("TAB1").setTag("tab1"));
        tabs.addTab(tabs.newTab().setText("TAB2").setTag("tab2"));
        tabs.addTab(tabs.newTab().setText("TAB3").setTag("tab3"));
        tabs.addTab(tabs.newTab().setText("TAB4").setTag("tab4"));


    }

    private void initData(String tag) {
        mAdapter.clear();
        for (int i = 0 ; i < 40; i++) {
            mAdapter.add(tag + " item : " + i);
        }
    }
}
