package org.example.challenge.lv2;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class Kiosk {

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
                // 기존에 생성한 Menu의 MenuItem을 조회 할 때 스트림을 사용하여 출력하도록 수정
                AtomicInteger menuNumber = new AtomicInteger(1);
                menu.stream()
                        .map(Menu::getCategory)
                        .filter(category -> menuNumber.get() <= 3)
                        .forEach(category -> System.out.println(menuNumber.getAndIncrement() + ". " + category));
                System.out.println("0. 종료       | 종료");

                if (cartItems.size() > 0) {
                    System.out.println("\n[ ORDER MENU ]");
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
                    confirmOrder();
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

        AtomicInteger menuItemNumber = new AtomicInteger(1);
        AtomicInteger index = new AtomicInteger();
        menu.stream()
                .map(Menu::getMenuItems)
                .limit(items.size())
                .forEach(menuItem ->
                        System.out.println(menuItemNumber.getAndIncrement() + ". " + formatMenu(items.get(index.getAndIncrement()))));
        System.out.println("0. 뒤로가기");

        int pickOrder = sc.nextInt();

        if (1 <= pickOrder && pickOrder <= items.size()) {
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
        } else if (pickOrder != 0) {
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

    public void confirmOrder() {
        System.out.println("아래와 같이 주문 하시겠습니까?");
        System.out.println("\n[ ORDERS ]"); // 장바구니 출력 및 금액 계산
        cartItems.stream().forEach(item -> System.out.println(formatMenu(item)));
        System.out.println("\n[ TOTAL ]");
        BigDecimal totalPrice = cartItems.stream() // 장바구니 리스트를 스트림으로 변환
                .map(MenuItem::getPrice) // 메뉴 하나하나에서 가격만 꺼내기
                .reduce(BigDecimal.ZERO, BigDecimal::add); // 가격들을 모두 더해서 최종 금액 구하기
        System.out.println("W " + totalPrice);
        System.out.println("\n1. 주문       2. 메뉴판"); // 주문 기능

        int finalChoice = sc.nextInt();

        if (finalChoice == 1) {
            Discount.printDiscount(); // 할인율 선택지 출력
            int selectedDiscount = sc.nextInt();
            if (selectedDiscount >= 1 && selectedDiscount <= 3) { // 각 번호에 해당하는 할인율 만큼 할인 적용 후 계산
                totalPrice = Discount.applyDiscount(totalPrice, selectedDiscount);
            } else if (selectedDiscount != 0){
                throw new IllegalArgumentException("잘못된 번호를 입력하셨습니다.");
            }
            System.out.println("주문이 완료되었습니다. 결제하실 금액은 W " + totalPrice + " 입니다.");
            cartItems.clear(); // 합산하여 총 금액을 계산하고, “주문하기”를 누르면 장바구니를 초기화합니다.
            System.out.println("이용해주셔서 감사합니다.");
        }
    }
}
