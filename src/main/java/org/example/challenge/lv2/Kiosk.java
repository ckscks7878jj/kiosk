package org.example.challenge.lv2;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 콘솔 기반의 키오스크 시스템입니다.
 * 메뉴 목록을 출력하고, 메뉴 선택 및 주문 기능을 제공합니다.
 */
public class Kiosk {

    private final List<Menu> menu;
    private final Scanner sc = new Scanner(System.in);

    // 사용자가 선택한 메뉴를 담는 장바구니 List
    private final List<MenuItem> cartItems = new ArrayList<>();

    public Kiosk(List<Menu> menu) {
        this.menu = menu;
    }

    // 키오스크의 메인 메뉴를 출력하고 사용자 선택에 응답합니다.
    public void start() {
        while (true) {
            try {
                System.out.println("\n[ MAIN MENU ]");
                IntStream.range(0, 3)
                        .forEach(num -> System.out.println((num + 1) + ". " +menu.get(num).getCategory()));
                System.out.println("0. 종료       | 종료");

                if (!cartItems.isEmpty()) {
                    System.out.println("\n[ ORDER MENU ]");
                    System.out.println("4. Orders");
                    System.out.println("5. Cancel");
                }

                int selectedMenu = sc.nextInt();

                if (selectedMenu == 1) {
                    System.out.println("\n[ BURGERS MENU ]");
                    subMenu(selectedMenu);
                    continue;
                } else if (selectedMenu == 2) {
                    System.out.println("\n[ DRINKS MENU ]");
                    subMenu(selectedMenu);
                    continue;
                } else if (selectedMenu == 3) {
                    System.out.println("\n[ DESSERTS MENU ]");
                    subMenu(selectedMenu);
                    continue;
                } else if (selectedMenu == 4 && !cartItems.isEmpty()) {
                    confirmOrder();
                    continue;
                } else if (selectedMenu == 5 && !cartItems.isEmpty()) {
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

    // 선택된 메뉴 카테고리에 속한 하위 메뉴를 출력하고 메뉴를 선택받습니다.
    public void subMenu(int selectedItem) {
        List<MenuItem> items = menu.get(selectedItem - 1).getMenuItems();

        IntStream.range(0, items.size())
                .forEach(index -> System.out.println((index + 1) + ". " + formatMenu(items.get(index))));
        System.out.println("0. 뒤로가기");

        int pickOrder = sc.nextInt();

        if (1 <= pickOrder && pickOrder <= items.size()) {
            MenuItem picked = items.get(pickOrder - 1);
            System.out.println("선택한 메뉴: " + formatMenu(picked));
            System.out.printf("\n\" %s \"", formatMenu(picked));
            System.out.println("\n위 메뉴를 장바구니에 추가하시겠습니까?");
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

    // 화면 출력용 메뉴 형식으로 변환합니다.
    public String formatMenu(MenuItem item) {
        return String.format("%-13s | W%4.1f | %s",
                item.getName(),
                item.getPrice().doubleValue(),
                item.getInfo()
        );
    }

    // 장바구니를 조회하고 주문 확인 및 결제를 진행합니다.
    public void confirmOrder() {
        boolean order = true;

        while (order) {
            System.out.println("\n아래와 같이 주문 하시겠습니까?");
            System.out.println("\n[ ORDERS ]");
            cartItems.forEach(item -> System.out.println(formatMenu(item)));
            System.out.println("\n[ TOTAL ]");
            BigDecimal totalPrice = cartItems.stream()
                    .map(MenuItem::getPrice)
                    .reduce(BigDecimal.ZERO, BigDecimal::add);
            System.out.println("W " + totalPrice);
            System.out.println("\n1. 결제하기");
            System.out.println("2. 메뉴로 돌아가기");
            System.out.println("3. 선택 취소");

            int finalChoice = sc.nextInt();

            if (finalChoice == 1) {
                Discount.printDiscount();
                int selectedDiscount = sc.nextInt();
                totalPrice = Discount.applyDiscount(totalPrice, selectedDiscount);
                System.out.printf("\n주문이 완료되었습니다. 결제하실 금액은 W %.1f 입니다.\n", totalPrice);
                cartItems.clear();
                System.out.println("이용해주셔서 감사합니다.");
                order = false;
            }

            if (finalChoice == 2) {
                order = false;
            }

            if (finalChoice == 3) {
                System.out.println(" [ ORDERS ] ");
                IntStream.range(0, cartItems.size())
                        .forEach(index -> System.out.println((index + 1) + ". " + formatMenu(cartItems.get(index))));

                System.out.println("\n주문에서 제외할 메뉴의 번호를 입력해주세요.");
                int cancelMenu = sc.nextInt();
                if (cancelMenu >= 1 && cancelMenu <= cartItems.size()) {
                    System.out.println(cartItems.get(cancelMenu - 1).getName() + " 가 삭제되었습니다.");
                    cartItems.remove(cancelMenu - 1);
                } else {
                    throw new IllegalArgumentException("잘못된 번호를 입력하셨습니다.");
                }
                if (cartItems.isEmpty()) {
                    System.out.println("장바구니가 비어있습니다. 메인 화면으로 돌아갑니다.");
                    order = false;
                }
            }
        }
    }
}
