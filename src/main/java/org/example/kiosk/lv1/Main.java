package org.example.kiosk.lv1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String first = "1. ShackBurger  | W 6.9 | 토마토, 양상추, 쉑소스가 토핑된 치즈버거";
        String second = "2. SmokeShack   | W 8.9 | 베잌너 체리 페퍼에 쉑소스가 토핑된 치즈버거";
        String third = "3. Cheeseburger | W 6.9 | 포테이토 번과 비프패티, 치즈가 토핑된 치즈버거";
        String fourth = "4. Hamburger    | W 5.4 | 비프패티를 기반으로 야채가 들어간 기본버거";

        while (true) { // 반복문 활용
            System.out.println("[ SHACKSHACK MENU ]");
            System.out.println(first);
            System.out.println(second);
            System.out.println(third);
            System.out.println(fourth);
            System.out.println("0. 종료     | 종료");

            int choice = sc.nextInt(); // Scanner 활용
            switch (choice) { // 조건문 활용
                case 1:
                    System.out.println("선택하신 메뉴: " + first);
                    break;
                case 2:
                    System.out.println("선택하신 메뉴: " + second);
                    break;
                case 3:
                    System.out.println("선택하신 메뉴: " + third);
                    break;
                case 4:
                    System.out.println("선택하신 메뉴: " + fourth);
                    break;
                case 0:
                    System.out.println("프로그램을 종료합니다.");
                    break;
            }
            break;
        }
    }
}