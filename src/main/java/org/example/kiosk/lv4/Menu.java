package org.example.kiosk.lv4;

import java.util.ArrayList;
import java.util.List;

public class Menu {

    String category;
    List<MenuItem> menuItems = new ArrayList<>();

    public Menu(String category) {
        this.category = category;
    }

    public void addMenuItem(MenuItem menuItem) {
        this.menuItems.add(menuItem);
    }

}