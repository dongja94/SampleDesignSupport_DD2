package com.begentgroup.sampledesignsupport;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

public class TabLayoutActivity extends AppCompatActivity {

    TabLayout tabs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_layout);
        tabs = (TabLayout)findViewById(R.id.tabs);

        tabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                Fragment f = MessageFragment.newInstance(tab.getText().toString());
                getSupportFragmentManager().beginTransaction()
                        .add(R.id.container, f , (String)tab.getTag())
                        .commit();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                if (tab == null) return;
                String tag = (String)tab.getTag();
                Fragment f = getSupportFragmentManager().findFragmentByTag(tag);
                if (f != null) {
                    getSupportFragmentManager().beginTransaction()
                            .detach(f)
                            .commit();
                }
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                String tag = (String)tab.getTag();
                Fragment f = getSupportFragmentManager().findFragmentByTag(tag);
                if (f != null) {
                    getSupportFragmentManager().beginTransaction()
                            .attach(f)
                            .commit();
                }
            }
        });

        for (int i = 0; i < 10; i++) {
            tabs.addTab(tabs.newTab().setText("TAB"+i).setTag("tab"+i));
        }
    }
}
