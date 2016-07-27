package com.begentgroup.sampledesignsupport;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

/**
 * Created by Administrator on 2016-07-27.
 */
public class MenuAdapter extends BaseExpandableListAdapter {
    MenuGroup[] items;
    public MenuAdapter(MenuGroup[] items) {
        this.items = items;
    }

    @Override
    public int getGroupCount() {
        return items.length;
    }

    @Override
    public int getChildrenCount(int i) {
        return items[i].children.size();
    }

    @Override
    public MenuGroup getGroup(int i) {
        return items[i];
    }

    @Override
    public MenuChild getChild(int i, int child) {
        return items[i].children.get(child);
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int childposition) {
        return childposition;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getGroupView(int groupPosition, boolean expanded, View convertView, ViewGroup parent) {
        TextView tv;
        if (convertView == null) {
            tv = (TextView)LayoutInflater.from(parent.getContext()).inflate(R.layout.view_group_item, parent, false);
        } else {
            tv = (TextView)convertView;
        }
        tv.setText(items[groupPosition].groupName);
        return tv;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLast, View convertView, ViewGroup parent) {
        TextView tv;
        if (convertView == null) {
            tv = (TextView)LayoutInflater.from(parent.getContext()).inflate(R.layout.view_child_item, parent, false);
        } else {
            tv = (TextView)convertView;
        }
        tv.setText(items[groupPosition].children.get(childPosition).menuName);
        return tv;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }
}
