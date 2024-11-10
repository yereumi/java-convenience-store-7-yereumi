package store.controller;

import java.util.Map;
import store.model.Product;
import store.model.Promotion;
import store.service.FileService;
import store.view.InputView;
import store.view.OutputView;

public class Controller {
    public static Map<String, Promotion> promotions;
    public static Map<String, Product> products;
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final FileService fileService = new FileService();


    public void run() {
        loadData();

    }

    private void loadData() {
        promotions = fileService.readPromotionsFile();
        products = fileService.readProductsFile();
        outputView.printGreetings();
        outputView.printStocks(products);
    }

}
