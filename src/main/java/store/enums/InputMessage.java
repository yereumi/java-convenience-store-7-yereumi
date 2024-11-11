package store.enums;

import java.text.MessageFormat;

public enum InputMessage {
    ORDER_INPUT("구매하실 상품명과 수량을 입력해 주세요. (예: [사이다-2],[감자칩-1])\n"),
    FREE_ITEM_OFFER_CONFIRMATION("현재 {0}은(는) 1개를 무료로 더 받을 수 있습니다. 추가하시겠습니까? (Y/N)"),
    PROMOTION_EXCLUSION_CONFIRMATION("현재 {0} {1}개는 프로모션 할인이 적용되지 않습니다. 그래도 구매하시겠습니까? (Y/N)"),
    MEMBERSHIP_DISCOUNT("멤버십 할인을 받으시겠습니까? (Y/N)"),
    BUY_ANOTHER_ITEM("감사합니다. 구매하고 싶은 다른 상품이 있나요? (Y/N)"),
    ;

    private final String message;

    InputMessage(String message) {
        this.message = message;
    }

    public String getMessage(Object... args) {
        return MessageFormat.format(message, args);
    }
}
