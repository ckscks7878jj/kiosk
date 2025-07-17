package org.example.kiosk.lv5;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Menu> menu = new ArrayList<>();

        Menu burgers = new Menu("BURGERS");
        MenuItem shackBurger = new MenuItem("ShackBurger",6.9,"토마토, 양상추, 쉑소스가 토핑된 치즈버거");
        burgers.addMenuItem(shackBurger);
        MenuItem smokeShack = new MenuItem("SmokeShack",8.9,"베이컨 체리 페퍼에 쉑소스가 토핑된 치즈버거");
        burgers.addMenuItem(smokeShack);
        MenuItem cheeseburger = new MenuItem("Cheeseburger",6.9,"포테이토 번과 비프패티, 치즈가 토핑된 치즈버거");
        burgers.addMenuItem(cheeseburger);
        MenuItem hamburger = new MenuItem("Hamburger",5.4,"비프패티를 기반으로 야채가 들어간 기본버거");
        burgers.addMenuItem(hamburger);
        menu.add(burgers);

        Menu drinks = new Menu("DRINKS");
        MenuItem coke = new MenuItem("Coke",2.0);
        drinks.addMenuItem(coke);
        MenuItem zeroCoke = new MenuItem("ZeroCoke",2.0);
        drinks.addMenuItem(zeroCoke);
        MenuItem sprite = new MenuItem("Sprite",2.0);
        drinks.addMenuItem(sprite);
        MenuItem milkShake = new MenuItem("MilkShake",2.5);
        drinks.addMenuItem(milkShake);
        MenuItem water = new MenuItem("Water",1.0);
        drinks.addMenuItem(water);
        menu.add(drinks);

        Menu desserts = new Menu("DESSERTS");
        MenuItem Fries = new MenuItem("Fries",3.0,"바삭하고 담백한 크링클 컷 프라이");
        desserts.addMenuItem(Fries);
        MenuItem frenchFries = new MenuItem("CheeseFries",3.5,"고소하고 진한 치즈 소스를 듬뿍 올린 프라이");
        desserts.addMenuItem(frenchFries);
        MenuItem chickenBites = new MenuItem("ChickenBites",2.5,"한 입에 먹기 좋은 바삭한 치킨 바이트");
        desserts.addMenuItem(chickenBites);
        menu.add(desserts);

        Kiosk kiosk = new Kiosk(menu);
        kiosk.start();
    }
}