package org.example.Day4;

import java.util.List;
import java.util.logging.Logger;

public class Order {
    private static final Logger log = Logger.getLogger(Order.class.getName());
    private List<Item> items;
    private Member member;

    public int getTotalPrice() {
        return items.stream()
                .mapToInt(Item::getPrice)
                .sum();
    }

    public boolean hasItems() {
        return items.size() == 0;
    }

    public boolean isNotValidatePrice() {
        return !(getTotalPrice() > 0);
    }

    // Refactor
    public boolean validate() {
        if (hasItems()) {
            log.info("주문 항목이 없습니다.");
            return false;
        }

        if (isNotValidatePrice()) {
            log.info("올바르지 않은 총 가격입니다.");
            return false;
        }

        if (member.hasNotInfo()) {
            log.info("사용자 정보가 없습니다.");
            return false;
        }

        return true;
    }
}
