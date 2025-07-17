package org.example.kiosk.lv5;

public class MenuItem {

    private final String name;
    private final double price;
    private String info; // 메뉴 설명은 추후 변경이 가능하도록 final로 선언하지 않았다.

    public MenuItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public MenuItem(String name, double price, String info) {
            this.name = name;
            this.price = price;
            this.info = info;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String newInfo) {
        this.info = newInfo;
    }
}
