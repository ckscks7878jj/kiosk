package org.example.challenge.lv2;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // 메뉴 등록 및 관리를 위한 List
        List<Menu> menu = new ArrayList<>();

        // 버거 메뉴 설정
        Menu burgers = new Menu("Burgers");
        List<MenuItem> burgerItems = List.of(
                new MenuItem("ShackBurger",6.9,"토마토, 양상추, 쉑소스가 토핑된 치즈버거"),
                new MenuItem("SmokeShack",8.9,"베이컨 체리 페퍼에 쉑소스가 토핑된 치즈버거"),
                new MenuItem("Cheeseburger",6.9,"포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"),
                new MenuItem("Hamburger",5.4,"비프패티를 기반으로 야채가 들어간 기본버거")
        );
        burgerItems.forEach(burgers::addMenuItem);
        menu.add(burgers);

        // 음료 메뉴 설정
        Menu drinks = new Menu("Drinks");
        List<MenuItem> drinkItems = List.of(
                new MenuItem("Coke",2.0, ""),
                new MenuItem("ZeroCoke",2.0, ""),
                new MenuItem("Sprite",2.0, ""),
                new MenuItem("MilkShake",2.5, ""),
                new MenuItem("Water",1.0, "")
        );
        drinkItems.forEach(drinks::addMenuItem);
        menu.add(drinks);

        // 디저트 메뉴 설정
        Menu desserts = new Menu("Desserts");
        List<MenuItem> dessertItems = List.of(
                new MenuItem("Fries",3.0,"바삭하고 담백한 크링클 컷 프라이"),
                new MenuItem("CheeseFries",3.5,"고소하고 진한 치즈 소스를 듬뿍 올린 프라이"),
                new MenuItem("ChickenBites",2.5,"한 입에 먹기 좋은 바삭한 치킨 바이트")
        );
        dessertItems.forEach(desserts::addMenuItem);
        menu.add(desserts);

        // 주문 메뉴 (장바구니 비어있음)
        Menu orders = new Menu("Orders");
        menu.add(orders);

        // 주문 취소 메뉴
        Menu cancel = new Menu("Cancel");
        menu.add(cancel);

        // 키오스크 구동
        Kiosk kiosk = new Kiosk(menu);
        kiosk.start();
    }
}