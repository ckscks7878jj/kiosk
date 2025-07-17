package org.example.kiosk.lv4;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Menu> menu = new ArrayList<>();

        Menu burgers = new Menu("Burgers");
        MenuItem shackBurger = new MenuItem("ShackBurger",6.9,"토마토, 양상추, 쉑소스가 토핑된 치즈버거");
        burgers.addMenuItem(shackBurger);
        MenuItem smokeShack = new MenuItem("SmokeShack",8.9,"베이컨 체리 페퍼에 쉑소스가 토핑된 치즈버거");
        burgers.addMenuItem(smokeShack);
        MenuItem cheeseburger = new MenuItem("Cheeseburger",6.9,"포테이토 번과 비프패티, 치즈가 토핑된 치즈버거");
        burgers.addMenuItem(cheeseburger);
        MenuItem hamburger = new MenuItem("Hamburger",5.4,"비프패티를 기반으로 야채가 들어간 기본버거");
        burgers.addMenuItem(hamburger);
        menu.add(burgers);
        Menu drinks = new Menu("Drinks");
        menu.add(drinks);
        Menu desserts = new Menu("Desserts");
        menu.add(desserts);

        Kiosk kiosk = new Kiosk(menu);

        try {
            kiosk.start();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}