package store.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import store.dto.ProductConstructDto;
import store.dto.PromotionConstructDto;
import store.enums.ErrorMessage;
import store.enums.Files;
import store.enums.OutputMessage;
import store.model.Product;
import store.model.Promotion;

public class FileService {
    public final Map<String, Promotion> promotions = new HashMap<>();
    public final Map<String, Product> products = new HashMap<>();

    public Map<String, Promotion> readPromotionsFile() {
        try (BufferedReader br = new BufferedReader(new FileReader(Files.PROMOTIONS_FILE_PATH.getValue()))) {
            br.readLine();
            String line;
            while ((line = br.readLine()) != null) {
                addPromotion(line);
            }
        } catch (IOException e) {
            System.out.println(ErrorMessage.INVALID_FILE_PATH.getMessage());
        }
        return promotions;
    }

    private void addPromotion(String promotionLine) {
        String[] promotion = promotionLine.split(OutputMessage.COMMA.getMessage());
        promotions.put(promotion[0], new PromotionConstructDto(promotion).toEntity());
    }

    public Map<String, Product> readProductsFile() {
        try (BufferedReader br = new BufferedReader(new FileReader(Files.PRODUCTS_FILE_PATH.getValue()))) {
            br.readLine();
            String line;
            while ((line = br.readLine()) != null) {
                addProduct(line);
            }
        } catch (IOException e) {
            System.out.println(ErrorMessage.INVALID_FILE_PATH.getMessage());
        }
        return products;
    }

    private void addProduct(String productLine) {
        String[] product = productLine.split(OutputMessage.COMMA.getMessage());
        products.put(product[0], new ProductConstructDto(product).toEntity());
    }
}
