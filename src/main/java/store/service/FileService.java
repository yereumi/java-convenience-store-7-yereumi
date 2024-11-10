package store.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import store.dto.ProductConstructDto;
import store.dto.PromotionConstructDto;
import store.enums.ErrorMessage;
import store.enums.Files;
import store.enums.OutputMessage;
import store.model.Product;
import store.model.Promotion;

public class FileService {
    public final List<Promotion> promotions = new ArrayList<>();
    public final List<Product> products = new ArrayList<>();

    public List<Promotion> readPromotionsFile() {
        try (BufferedReader br = new BufferedReader(new FileReader(Files.PROMOTIONS_FILE_PATH.getValue()))) {
            while (br.readLine() != null) {
                addPromotion(br.readLine());
            }
        } catch (IOException e) {
            System.out.println(ErrorMessage.INVALID_FILE_PATH.getMessage());
        }
        return promotions;
    }

    private void addPromotion(String promotionLine) {
        String[] promotion = promotionLine.split(OutputMessage.COMMA.getMessage());
        promotions.add(new PromotionConstructDto(promotion).toEntity());
    }

    public List<Product> readProductsFile() {
        try (BufferedReader br = new BufferedReader(new FileReader(Files.PRODUCTS_FILE_PATH.getValue()))) {
            while (br.readLine() != null) {
                addProduct(br.readLine());
            }
        } catch (IOException e) {
            System.out.println(ErrorMessage.INVALID_FILE_PATH.getMessage());
        }
        return products;
    }

    private void addProduct(String productLine) {
        String[] product = productLine.split(OutputMessage.COMMA.getMessage());
        products.add(new ProductConstructDto(product, promotions).toEntity());
    }
}
