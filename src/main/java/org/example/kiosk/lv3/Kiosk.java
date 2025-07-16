package org.example.kiosk.lv3;

import java.util.List;
import java.util.Scanner;

public class Kiosk { // 키오스크 프로그램의 메뉴를 관리하고 사용자 입력을 처리하는 클래스

    private final List<MenuItem> menuItems;

    public Kiosk(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    public void start() {
        while (true) {
            System.out.println("[ SHACKSHACK MENU ]");
            for (int i = 0; i < menuItems.size(); i++) { // 반복문을 활용해 List 안에 있는 MenuItem을 하나씩 출력
                System.out.println((i + 1) + ". " + menuItems.get(i).name + " | w " + menuItems.get(i).price + " | " + menuItems.get(i).info);
            }
            System.out.println("0. 종료     | 종료");
            Scanner sc = new Scanner(System.in); // Scanner 선언
            int choice = sc.nextInt(); // 숫자 입력 받기
            switch (choice) { // 입력된 숫자에 따른 처리
                case 1: // 선택한 메뉴 : 이름, 가격, 설명
                    System.out.println("선택하신 메뉴: 1. " + menuItems.get(0).name + " | w " + menuItems.get(0).price + " | " + menuItems.get(0).info);
                    continue;
                case 2:
                    System.out.println("선택하신 메뉴: 2. " + menuItems.get(1).name + " | w " + menuItems.get(1).price + " | " + menuItems.get(1).info);
                    continue;
                case 3:
                    System.out.println("선택하신 메뉴: 3. " + menuItems.get(2).name + " | w " + menuItems.get(2).price + " | " + menuItems.get(2).info);
                    continue;
                case 4:
                    System.out.println("선택하신 메뉴: 4. " + menuItems.get(3).name + " | w " + menuItems.get(3).price + " | " + menuItems.get(3).info);
                    continue;
                case 0:
                    System.out.println("프로그램을 종료합니다."); // 프로그램을 종료
                    break;
                default:
                    throw new IllegalArgumentException("잘못된 번호를 입력하셨습니다."); // 유효하지 않은 입력에 대해 오류 메시지 출력
            }
            break;
        }
    }
}
