package org.example.kiosk.lv5;

import java.util.List;
import java.util.Scanner;

public class Kiosk { // 사용자 입력 처리 및 메뉴 출력

    private final List<Menu> menu;

    public Kiosk(List<Menu> menu) {
        this.menu = menu;
    }

    Scanner sc = new Scanner(System.in);
    public void start() {
        while (true) {
            try {
                System.out.println("\n[ MAIN MENU ]");
                for (int i = 0; i < menu.size(); i++) { // 반복문을 활용해 List 안에 있는 Menu를 하나씩 출력
                    System.out.println((i + 1) + ". " + menu.get(i).getCategory());
                }
                System.out.println("0. 종료       | 종료");
                int pickMenu = sc.nextInt();
                if (pickMenu == 1) {
                    System.out.println("\n[ BURGERS MENU ]");
                    subMenu(pickMenu); // 중복 코드를 메서드화
                    continue;
                }
                if (pickMenu == 2) {
                    System.out.println("\n[ DRINKS MENU ]");
                    subMenu(pickMenu);
                    continue;
                }
                if (pickMenu == 3) {
                    System.out.println("\n[ DESSERTS MENU ]");
                    subMenu(pickMenu);
                    continue;
                } else if (pickMenu == 0) {
                    System.out.println("프로그램을 종료합니다.");
                } else {
                    throw new IllegalArgumentException("잘못된 번호를 입력하셨습니다."); // 유효하지 않은 입력에 대해 오류 메시지 출력
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                continue;
            }
            break;
        }
    }

    public void subMenu(int pickMenu) {
        List<MenuItem> menuItems = menu.get(pickMenu - 1).getMenuItems();
        for (int i = 0; i < menuItems.size(); i++) { // 반복문을 활용해 List 안에 있는 MenuItem을 하나씩 출력
            System.out.printf("%d. %-13s | W%4.1f | %s\n",
                    i + 1,
                    menuItems.get(i).getName(),
                    menuItems.get(i).getPrice(),
                    menuItems.get(i).getInfo());
        }
        System.out.println("0. 뒤로가기");
        int pickOrder = sc.nextInt();
        switch (pickOrder) {
            case 1: // 선택한 메뉴 : 이름, 가격, 설명
                pickedMenu(menuItems, pickOrder);
                return;
            case 2:
                pickedMenu(menuItems, pickOrder);
                return;
            case 3:
                pickedMenu(menuItems, pickOrder);
                return;
            case 4:
                pickedMenu(menuItems, pickOrder);
                return;
            case 5:
                pickedMenu(menuItems, pickOrder);
                return;
            case 0:
                return;
            default:
                throw new IllegalArgumentException("잘못된 번호를 입력하셨습니다.");
        }
    }

    public void pickedMenu(List<MenuItem> menuItems, int pickOrder) {
        String info = menuItems.get(pickOrder - 1).getInfo();
        if (info != null && !info.equalsIgnoreCase("null")) { // drinks 메뉴의 설명을 일부러 비웠는데, 여전히 null로 표기된다.
            System.out.printf("%s: %d. %-13s | W%4.1f | %s\n",
                    "선택한 메뉴",
                    pickOrder,
                    menuItems.get(pickOrder - 1).getName(),
                    menuItems.get(pickOrder - 1).getPrice(),
                    menuItems.get(pickOrder - 1).getInfo());
        } else {
            System.out.printf("%s: %d. %-13s | W%4.1f\n",
                    "선택한 메뉴",
                    pickOrder,
                    menuItems.get(pickOrder - 1).getName(),
                    menuItems.get(pickOrder - 1).getPrice());
        }
    }
}
