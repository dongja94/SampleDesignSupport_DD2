package com.begentgroup.sampledesignsupport;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2016-07-27.
 */
public class MenuGroup {
    public String groupName;
    public int menuId;
    public List<MenuChild> children = new ArrayList<>();

    public MenuGroup(String groupName, int menuId, MenuChild... children) {
        this.groupName = groupName;
        this.menuId = menuId;
        this.children.addAll(Arrays.asList(children));
    }
}
