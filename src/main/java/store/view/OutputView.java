package store.view;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Map;
import store.enums.OutputMessage;
import store.model.Product;

public class OutputView {
    public void printGreetings() {
        System.out.println(OutputMessage.GREETINGS.getMessage());
    }

    public void printStocks(Map<String, Product> products) {
        System.out.println(OutputMessage.STOCKS.getMessage());
        for (Map.Entry<String, Product> entry : products.entrySet()) {
            System.out.println(OutputMessage.HYPHEN_SPACE.getMessage() +
                    OutputMessage.PRODUCT.getMessage(entry.getKey(), convertPrice(entry.getValue().price()),
                            entry.getValue().quantity(), entry.getValue().promotion()));
        }
    }

    private String convertPrice(int price) {
        NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.US);
        return numberFormat.format(price);
    }

    public void printReceipt() {

    }

}
