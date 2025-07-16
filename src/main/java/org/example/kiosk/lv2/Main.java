package org.example.kiosk.lv2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        List<MenuItem> menuItems = new ArrayList<>(); // List 선언 및 초기화

        MenuItem firstMenu = new MenuItem("ShackBurger",6.9,"토마토, 양상추, 쉑소스가 토핑된 치즈버거");
        MenuItem secondMenu = new MenuItem("SmokeShack",8.9,"베이컨 체리 페퍼에 쉑소스가 토핑된 치즈버거");
        MenuItem thirdMenu = new MenuItem("Cheeseburger",6.9,"포테이토 번과 비프패티, 치즈가 토핑된 치즈버거");
        MenuItem fourthMenu = new MenuItem("Hamburger",5.4,"비프패티를 기반으로 야채가 들어간 기본버거");

        menuItems.add(firstMenu); // add 함수를 통해 new MenuItem(이름, 가격, 설명) List에 삽입
        menuItems.add(secondMenu);
        menuItems.add(thirdMenu);
        menuItems.add(fourthMenu);

        Scanner sc = new Scanner(System.in); // Scanner 선언

        while (true) {
            System.out.println("[ SHACKSHACK MENU ]");
            for (int i = 0; i < menuItems.size(); i++) { // 반복문을 활용해 List 안에 있는 MenuItem을 하나씩 출력
                System.out.println((i + 1) + ". " + menuItems.get(i).name + " | w " + menuItems.get(i).price + " | " + menuItems.get(i).info);
            }
            System.out.println("0. 종료     | 종료");
            int choice = sc.nextInt(); // 숫자를 입력 받기
            switch (choice) { // 입력된 숫자에 따른 처리
                case 1: // 선택한 메뉴 : 이름, 가격, 설명
                    System.out.println("선택하신 메뉴: 1. " + menuItems.get(0).name + " | w " + menuItems.get(0).price + " | " + menuItems.get(0).info);
                    break;
                case 2:
                    System.out.println("선택하신 메뉴: 2. " + menuItems.get(1).name + " | w " + menuItems.get(1).price + " | " + menuItems.get(1).info);
                    break;
                case 3:
                    System.out.println("선택하신 메뉴: 3. " + menuItems.get(2).name + " | w " + menuItems.get(2).price + " | " + menuItems.get(2).info);
                    break;
                case 4:
                    System.out.println("선택하신 메뉴: 4. " + menuItems.get(3).name + " | w " + menuItems.get(3).price + " | " + menuItems.get(3).info);
                    break;
                case 0:
                    System.out.println("프로그램을 종료합니다."); // 프로그램을 종료
                    break;
            }
            break;
        }
    }
}