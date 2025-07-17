package org.example.challenge.lv1;

import java.util.List;
import java.util.Scanner;

public class Kiosk { // 사용자 입력 처리 및 메뉴 출력

    private final List<Menu> menu;
    private final Scanner sc = new Scanner(System.in);

    public Kiosk(List<Menu> menu) {
        this.menu = menu;
    }

    public void start() {
        while (true) {
            try {  // 유효하지 않은 입력에 대해 오류 메시지 출력
                System.out.println("\n[ MAIN MENU ]");

                for (int i = 0; i < menu.size(); i++) { // 반복문을 활용해 List 안에 있는 Menu를 하나씩 출력
                    System.out.println((i + 1) + ". " + menu.get(i).getCategory());
                }
                System.out.println("0. 종료       | 종료");

                int pickMenu = sc.nextInt();

                if (pickMenu == 1) {
                    System.out.println("\n[ BURGERS MENU ]");
                    subMenu(pickMenu); // 중복 코드 → 메서드로 분리
                    continue;
                } else if (pickMenu == 2) {
                    System.out.println("\n[ DRINKS MENU ]");
                    subMenu(pickMenu);
                    continue;
                } else if (pickMenu == 3) {
                    System.out.println("\n[ DESSERTS MENU ]");
                    subMenu(pickMenu);
                    continue;
                } else if (pickMenu == 0) {
                    System.out.println("프로그램을 종료합니다.");
                } else {
                    throw new IllegalArgumentException("잘못된 번호를 입력하셨습니다.");
                }

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                continue;
            }

            break;
        }
    }

    public void subMenu(int pickMenu) {
        List<MenuItem> items = menu.get(pickMenu - 1).getMenuItems();

        for (int i = 0; i < items.size(); i++) { // 반복문을 활용해 List 안에 있는 MenuItem을 하나씩 출력
            System.out.printf("%d. %s\n", i + 1, formatMenu(items.get(i)));
        }
        System.out.println("0. 뒤로가기");

        int pickOrder = sc.nextInt();

        switch (pickOrder) { // fall-through 활용
            case 1: // 선택한 메뉴 : 이름, 가격, 설명
            case 2:
            case 3:
            case 4:
            case 5:
                System.out.println("선택한 메뉴: " + formatMenu(items.get(pickOrder)));
                return;
            case 0:
                return;
            default:
                throw new IllegalArgumentException("잘못된 번호를 입력하셨습니다.");
        }
    }

    public String formatMenu(MenuItem item) {
        return String.format("%-13s | W%4.1f | %s\n",
                item.getName(),
                item.getPrice(),
                item.getInfo());
    }
}
