package store.enums;

import java.text.MessageFormat;

public enum OutputMessage {
    GREETINGS("안녕하세요. W편의점입니다."),
    STOCKS("현재 보유하고 있는 상품입니다.\n"),
    PRODUCT("{0} {1}원 {2}개 {3}"),
    RECEIPT_STORE_HEADER("==============W 편의점================"),
    RECEIPT_ITEM_TITLE("상품명\t\t수량\t금액"),
    RECEIPT_ITEM("{0}\t\t{1} \t{2}"),
    RECEIPT_FREE_ITEM_HEADER("=============증\t정==============="),
    RECEIPT_FREE_ITEM("{0}\t\t{1}"),
    RECEIPT_FOOTER("===================================="),
    RECEIPT_TOTAL_PURCHASE_AMOUNT("{0}\t\t{1}\t{2}"),
    RECEIPT_PROMOTION_DISCOUNT("{0}\t\t\t-{1}"),
    RECEIPT_MEMBERSHIP_DISCOUNT("{0}\t\t\t-{1}"),
    RECEIPT_FINAL_PAYMENT("{0}\t\t\t {1}"),
    HYPHEN_SPACE("- "),
    COMMA(",");

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage(Object... args) {
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("null")) {
                args[i] = "";
            }
        }
        return MessageFormat.format(message, args);
    }
}
