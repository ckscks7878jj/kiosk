package org.example.challenge.lv1;

import java.util.ArrayList;
import java.util.List;

public class Menu {

    private final String category;
    private final List<MenuItem> menuItems = new ArrayList<>();

    public Menu(String category) {
        this.category = category;
    }

    public void addMenuItem(MenuItem menuItem) {
        this.menuItems.add(menuItem);
    }

    public String getCategory() {
        return category;
    }

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }
}
