package org.example.kiosk.challenge.lv1;

import java.math.BigDecimal;

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
