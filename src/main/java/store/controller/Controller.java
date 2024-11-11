package store.controller;

import java.util.LinkedHashMap;
import java.util.Map;
import store.model.Order;
import store.model.Product;
import store.model.Promotion;
import store.service.FileService;
import store.service.OrderService;
import store.view.InputView;
import store.view.OutputView;

public class Controller {
    public static Map<String, Promotion> promotions = new LinkedHashMap<>();
    public static Map<String, Product> promotionProducts = new LinkedHashMap<>();
    public static Map<String, Product> generalProducts = new LinkedHashMap<>();
    public static Order order;
    private final InputView inputView;
    private final OutputView outputView;
    private final FileService fileService;
    private final OrderService orderService;

    public Controller() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.fileService = new FileService();
        this.orderService = new OrderService();
    }

    public void run() {
        loadData();
        do {
            order = purchase();
            printReceipt(order);
        } while (!inputView.confirmBuyAnotherItem().equals("N"));
    }

    private void loadData() {
        outputView.printGreetings();
        fileService.readPromotionsFile();
        fileService.readProductsFile();
    }

    private Order purchase() {
        while (true) {
            try {
                return orderService.saveOrder();
            } catch (IllegalArgumentException e) {
                outputView.printError(e.getMessage());
            }
        }

    }

    private void printReceipt(Order order) {
        outputView.printReceipt(order);
    }

}
