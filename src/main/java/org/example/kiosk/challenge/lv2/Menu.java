package org.example.kiosk.challenge.lv2;

import java.util.ArrayList;
import java.util.List;

/**
 * 버거, 음료 등의 메뉴 카테고리를 분류하고, 각 카테고리에 메뉴 항목을 관리하는 클래스입니다.
 */
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
