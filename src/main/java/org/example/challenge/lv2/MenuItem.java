package org.example.challenge.lv2;

import java.math.BigDecimal;

/**
 * 메뉴 항목의 이름, 가격, 설명을 담는 클래스입니다.
 */
public class MenuItem {

    private final String name;
    private final BigDecimal price;
    private final String info;

    public MenuItem(String name, double price, String info) {
            this.name = name;
            this.price = BigDecimal.valueOf(price);
            this.info = info;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getInfo() {
        return info;
    }

}
