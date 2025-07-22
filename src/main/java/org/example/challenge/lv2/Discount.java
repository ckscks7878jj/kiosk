package org.example.challenge.lv2;

import java.math.BigDecimal;

/**
 * 대상별 할인을 정의하고, 선택된 할인에 따라 가격을 계산하는 Enum 클래스입니다.
 */
public enum Discount {
    VETERAN("국가유공자","10%", 0.1),
    SOLDIER("군인","5%", 0.05),
    STUDENT("학생","3%", 0.03),
    REGULAR("일반","0%", 0);

    private final String type;
    private final String displayRate;
    private final BigDecimal rate;

    Discount(String type, String displayRate, double rate) {
        this.type = type;
        this.displayRate = displayRate;
        this.rate = BigDecimal.valueOf(rate);
    }

    public BigDecimal getRate() {
        return rate;
    }

    public static void printDiscount() { // 재사용성을 고려한 리팩토링이 필요해보인다.
        System.out.println("\n할인 정보를 입력해주세요.");
        System.out.println("1. " + VETERAN.type + " : " + VETERAN.displayRate);
        System.out.println("2. " + SOLDIER.type + " : " + SOLDIER.displayRate);
        System.out.println("3. " + STUDENT.type + " : " + STUDENT.displayRate);
        System.out.println("4. " + REGULAR.type + " : " + REGULAR.displayRate);
    }

    public static BigDecimal applyDiscount(BigDecimal totalPrice, int selectedDiscount) {
        if (selectedDiscount == 1) {
            return totalPrice.subtract(totalPrice.multiply(VETERAN.getRate()));
        }
        if (selectedDiscount == 2) {
            return totalPrice.subtract(totalPrice.multiply(SOLDIER.getRate()));
        }
        if (selectedDiscount == 3) {
            return totalPrice.subtract(totalPrice.multiply(STUDENT.getRate()));
        }
        return totalPrice;
    }
}
