package store.view;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Map;
import store.controller.Controller;
import store.enums.OutputMessage;
import store.model.Order;

public class OutputView {
    public void printGreetings() {
        System.out.println(OutputMessage.GREETINGS.getMessage());
        System.out.println(OutputMessage.STOCKS.getMessage());
    }

    public void printStock(String name, String price, String quantity, String promotion) {
        System.out.println(
                OutputMessage.HYPHEN_SPACE.getMessage() + OutputMessage.PRODUCT.getMessage(name,
                        convertPrice(Integer.parseInt(price)),
                        quantity,
                        promotion));
    }

    public void printStock(String name, String price, String quantity) {
        System.out.println(
                OutputMessage.HYPHEN_SPACE.getMessage() + OutputMessage.PRODUCT.getMessage(name,
                        convertPrice(Integer.parseInt(price)),
                        quantity,
                        price));
    }

    private String convertPrice(int price) {
        NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.US);
        return numberFormat.format(price);
    }

    public void printReceipt(Order order) {
        System.out.println(OutputMessage.RECEIPT_STORE_HEADER.getMessage());
        System.out.println(OutputMessage.RECEIPT_ITEM_TITLE.getMessage());
        for (Map.Entry<String, Integer> entry : order.getProduct().entrySet()) {
            int price = Controller.generalProducts.get(entry.getKey()).price();
            System.out.println(OutputMessage.RECEIPT_ITEM_TITLE.getMessage(entry.getKey(), entry.getValue(),
                    entry.getValue() * price));
        }
        System.out.println(OutputMessage.RECEIPT_FREE_ITEM_HEADER.getMessage());
        for (Map.Entry<String, Integer> entry : order.getFreeItem().entrySet()) {
            System.out.println(OutputMessage.RECEIPT_FREE_ITEM.getMessage(entry.getKey(), entry.getValue()));
        }
        System.out.println(OutputMessage.RECEIPT_FOOTER.getMessage());
        System.out.println(
                OutputMessage.RECEIPT_TOTAL_PURCHASE_AMOUNT.getMessage(order.getTotalCount(), order.getTotalPrice()));
        System.out.println(OutputMessage.RECEIPT_PROMOTION_DISCOUNT.getMessage(order.getPromotionDiscount()));
        System.out.println(OutputMessage.RECEIPT_MEMBERSHIP_DISCOUNT.getMessage(order.getMembershipDiscount()));
        System.out.println(OutputMessage.RECEIPT_FINAL_PAYMENT.getMessage(order.getResultPurchase()));
    }

    public void printError(String errorMessage) {
        System.out.println(errorMessage);
    }

}
