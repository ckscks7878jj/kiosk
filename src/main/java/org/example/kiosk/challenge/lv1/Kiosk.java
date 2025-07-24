package org.example.kiosk.challenge.lv1;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Kiosk { // 사용자 입력 처리 및 메뉴 출력

    private final List<Menu> menu;
    private final Scanner sc = new Scanner(System.in);
    private final List<MenuItem> cartItems = new ArrayList<>(); // 장바구니 생성 및 관리 기능

    public Kiosk(List<Menu> menu) {
        this.menu = menu;
    }

    public void start() {
        while (true) {
            try {
                System.out.println("\n[ MAIN MENU ]");

                for (int i = 0; i <= 2; i++) {
                    System.out.println((i + 1) + ". " + menu.get(i).getCategory());
                }
                System.out.println("0. 종료       | 종료");

                if (cartItems.size() > 0) {
                    System.out.println("\n[ ORDER MENU ]");
                    Menu orders = new Menu("Orders");
                    Menu cancel = new Menu("Cancel");
                    menu.add(orders);
                    menu.add(cancel);
                    System.out.println("4. Orders");
                    System.out.println("5. Cancel");
                }

                int selectedMenu = sc.nextInt();

                if (selectedMenu == 1) {
                    System.out.println("\n[ BURGERS MENU ]");
                    subMenu(selectedMenu); // 중복 코드 → 메서드로 분리
                    continue;
                } else if (selectedMenu == 2) {
                    System.out.println("\n[ DRINKS MENU ]");
                    subMenu(selectedMenu);
                    continue;
                } else if (selectedMenu == 3) {
                    System.out.println("\n[ DESSERTS MENU ]");
                    subMenu(selectedMenu);
                    continue;
                } else if (selectedMenu == 4 && cartItems.size() > 0) {
                    System.out.println("아래와 같이 주문 하시겠습니까?");
                    System.out.println("\n[ ORDERS ]"); // 장바구니 출력 및 금액 계산
                    for (MenuItem item : cartItems) {
                        System.out.println(formatMenu(item));
                    }
                    System.out.println("\n[ TOTAL ]");
                    BigDecimal totalPrice = BigDecimal.ZERO;
                    for (MenuItem item : cartItems) {
                        totalPrice = totalPrice.add(item.getPrice());
                    }
                    System.out.println("W " + totalPrice);
                    System.out.println("\n1. 주문       2. 메뉴판"); // 주문 기능
                    int finalChoice = sc.nextInt();
                    if (finalChoice == 1) {
                        System.out.println("주문이 완료되었습니다. 결제하실 금액은 W " + totalPrice + " 입니다.");
                        cartItems.clear();
                        System.out.println("이용해주셔서 감사합니다.");
                        break;
                    }
                    continue;
                } else if (selectedMenu == 5 && cartItems.size() > 0) {
                    System.out.println("주문이 취소 되었습니다.");
                    cartItems.clear();
                    continue;
                } else if (selectedMenu == 0) {
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

    public void subMenu(int selectedItem) {
        List<MenuItem> items = menu.get(selectedItem - 1).getMenuItems();

        for (int i = 0; i < items.size(); i++) {
            System.out.printf("%d. %s\n", i + 1, formatMenu(items.get(i)));
        }
        System.out.println("0. 뒤로가기");

        int pickOrder = sc.nextInt();

        if (pickOrder >= 1 && pickOrder <= items.size()) {
            MenuItem picked = items.get(pickOrder - 1);
            System.out.println("선택한 메뉴: " + formatMenu(picked));
            System.out.printf("\n\" %s \"", formatMenu(picked));
            System.out.println("\n위 메뉴를 장바구니에 추가하시겠습니까?"); // 장바구니 담기 기능
            System.out.println("1. 확인         2. 취소");
            int cartChoice = sc.nextInt();
            if (cartChoice == 1) {
                cartItems.add(picked);
                System.out.println(picked.getName() + " 메뉴가 장바구니에 추가되었습니다.");
            }
        } else if (pickOrder == 0) {
            return;
        } else {
            throw new IllegalArgumentException("잘못된 번호를 입력하셨습니다.");
        }
    }

    public String formatMenu(MenuItem item) {
        return String.format("%-13s | W%4.1f | %s",
                item.getName(),
                item.getPrice().doubleValue(),
                item.getInfo()
        );
    }
}
