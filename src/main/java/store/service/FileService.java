package store.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import store.controller.Controller;
import store.dto.ProductConstructDto;
import store.dto.PromotionConstructDto;
import store.enums.ErrorMessage;
import store.enums.Files;
import store.enums.OutputMessage;
import store.view.OutputView;

public class FileService {
    private static final OutputView outputView = new OutputView();

    public void readPromotionsFile() {
        try (BufferedReader br = new BufferedReader(new FileReader(Files.PROMOTIONS_FILE_PATH.getValue()))) {
            br.readLine();
            String line;
            while ((line = br.readLine()) != null) {
                addPromotion(line);
            }
        } catch (IOException e) {
            System.out.println(ErrorMessage.INVALID_FILE_PATH.getMessage());
        }
    }

    private void addPromotion(String promotionLine) {
        String[] promotion = promotionLine.split(OutputMessage.COMMA.getMessage());
        Controller.promotions.put(promotion[0], new PromotionConstructDto(promotion).toEntity());
    }

    public void readProductsFile() {
        try (BufferedReader br = new BufferedReader(new FileReader(Files.PRODUCTS_FILE_PATH.getValue()))) {
            br.readLine();
            String line;
            while ((line = br.readLine()) != null) {
                addProduct(line);
            }
        } catch (IOException e) {
            System.out.println(ErrorMessage.INVALID_FILE_PATH.getMessage());
        }
    }

    private void addProduct(String productLine) {
        String[] product = productLine.split(OutputMessage.COMMA.getMessage());
        if (!isExistPromotion(product[3])) {
            Controller.generalProducts.put(product[0], new ProductConstructDto(product).toEntity());
            outputView.printStock(product[0], product[1], product[2]);
        }
        if (isExistPromotion(product[3])) {
            Controller.promotionProducts.put(product[0], new ProductConstructDto(product).toEntity());
            outputView.printStock(product[0], product[1], product[2], product[3]);
        }
    }

    private boolean isExistPromotion(String promotion) {
        return !promotion.equals("null");
    }
}
