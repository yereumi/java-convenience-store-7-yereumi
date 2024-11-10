package store.view;

import camp.nextstep.edu.missionutils.Console;
import store.enums.InputMessage;

public class InputView {
    public String readOrder() {
        System.out.println(InputMessage.ORDER_INPUT.getMessage());
        return Console.readLine();
    }

    public String confirmFreeItemOffer(String product) {
        System.out.println(InputMessage.FREE_ITEM_OFFER_CONFIRMATION.getMessage(product));
        return Console.readLine();
    }

    public String confirmPromotionExclusion(String product, int count) {
        System.out.println(InputMessage.PROMOTION_EXCLUSION_CONFIRMATION.getMessage(product, count));
        return Console.readLine();
    }

    public String confirmMembershipDiscount() {
        System.out.println(InputMessage.MEMBERSHIP_DISCOUNT.getMessage());
        return Console.readLine();
    }

    public String confirmBuyAnotherItem() {
        System.out.println(InputMessage.BUY_ANOTHER_ITEM.getMessage());
        return Console.readLine();
    }
}
