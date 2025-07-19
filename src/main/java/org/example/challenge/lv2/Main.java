package org.example.challenge.lv2;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Menu> menu = new ArrayList<>();

        Menu burgers = new Menu("Burgers"); // 버거를 관리하는 메뉴 카테고리 생성
        List<MenuItem> burgerItems = List.of( // List.of를 사용해 한 번에 객체 생성
                new MenuItem("ShackBurger",6.9,"토마토, 양상추, 쉑소스가 토핑된 치즈버거"),
                new MenuItem("SmokeShack",8.9,"베이컨 체리 페퍼에 쉑소스가 토핑된 치즈버거"),
                new MenuItem("Cheeseburger",6.9,"포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"),
                new MenuItem("Hamburger",5.4,"비프패티를 기반으로 야채가 들어간 기본버거")
        );
        burgerItems.forEach(burgers::addMenuItem); // 생성된 버거들을 burgers 객체에 하나씩 등록
        menu.add(burgers); // 완성된 burgers 메뉴를 전체 메뉴 리스트에 추가

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

        Menu desserts = new Menu("Desserts");
        List<MenuItem> dessertItems = List.of(
                new MenuItem("Fries",3.0,"바삭하고 담백한 크링클 컷 프라이"),
                new MenuItem("CheeseFries",3.5,"고소하고 진한 치즈 소스를 듬뿍 올린 프라이"),
                new MenuItem("ChickenBites",2.5,"한 입에 먹기 좋은 바삭한 치킨 바이트")
        );
        dessertItems.forEach(desserts::addMenuItem);

        menu.add(desserts);

        Kiosk kiosk = new Kiosk(menu);
        kiosk.start();
    }
}