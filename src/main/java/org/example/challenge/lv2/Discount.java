package org.example.challenge.lv2;

import java.math.BigDecimal;

public enum Discount {
    veteran("국가유공자","10%", 0.1),
    soldier("군인","5%", 0.05),
    student("학생","3%", 0.03),
    regular("일반","0%", 0);

    private final String type;
    private final String displayRate;
    private final BigDecimal rate;

    Discount(String type, String displayRate, double rate) {
        this.type = type;
        this.displayRate = displayRate;
        this.rate = BigDecimal.valueOf(rate); // double로 받고 BigDecimal로 필드에 저장
    }

    public BigDecimal getRate() {
        return rate;
    }

    public static void printDiscount() {
        System.out.println("할인 정보를 입력해주세요.");
        System.out.println("1. " + veteran.type + " : " + veteran.displayRate);
        System.out.println("2. " + soldier.type + " : " + soldier.displayRate);
        System.out.println("3. " + student.type + " : " + student.displayRate);
        System.out.println("4. " + regular.type + " : " + regular.displayRate);
    }

    public static BigDecimal applyDiscount(BigDecimal totalPrice, int selectedDiscount) {
        if (selectedDiscount == 1) {
            return totalPrice.subtract(totalPrice.multiply(Discount.veteran.getRate()));
        }
        if (selectedDiscount == 2) {
            return totalPrice.subtract(totalPrice.multiply(Discount.soldier.getRate()));
        }
        if (selectedDiscount == 3) {
            return totalPrice.subtract(totalPrice.multiply(Discount.student.getRate()));
        }
        return totalPrice;
    }
}
