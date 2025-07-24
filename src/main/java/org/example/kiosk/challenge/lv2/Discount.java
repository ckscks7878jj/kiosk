package org.example.kiosk.challenge.lv2;

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

    public String getType() {
        return type;
    }

    public String getDisplayRate() {
        return displayRate;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public static void printDiscount() {
        System.out.println("\n할인 정보를 입력해주세요.");
        int index = 1;
        for (Discount discount : Discount.values()) {
            System.out.println(index++ + ". " + discount.type + " : " + discount.displayRate);
        }
    }

    public static BigDecimal applyDiscount(BigDecimal totalPrice, int selectedDiscount) {
        if (selectedDiscount > 0 && selectedDiscount <= Discount.values().length) {
            return totalPrice.subtract(totalPrice.multiply(Discount.values()[selectedDiscount - 1].getRate()));
        } else {
            throw new IllegalArgumentException("잘못된 번호를 입력하셨습니다.");
        }
    }

}
