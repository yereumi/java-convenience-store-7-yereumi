package store.validator;

import camp.nextstep.edu.missionutils.DateTimes;
import java.time.LocalDateTime;
import store.controller.Controller;
import store.enums.Constants;
import store.enums.ErrorMessage;
import store.model.Product;
import store.model.Promotion;
import store.util.CommonUtil;

public class OrderValidator {
    private static Product promotionProduct;
    private static Product generalProduct;
    private static int productStock = 0;

    public static void validateOrder(String name, String count) {
        if (Controller.promotionProducts.containsKey(name)) {
            promotionProduct = Controller.promotionProducts.get(name);
            productStock += promotionProduct.quantity();
        }
        generalProduct = Controller.generalProducts.get(name);
        productStock += generalProduct.quantity();
        validateProductName(name);
        validateProductCount(count);
    }

    private static void validateProductName(String name) {
        if (name.isBlank() || name.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT_TYPE.getMessage());
        }
        if (!isProductExistsByName(name)) {
            throw new IllegalArgumentException(ErrorMessage.PRODUCT_NOT_FOUND.getMessage());
        }
    }

    private static boolean isProductExistsByName(String name) {
        return Controller.generalProducts.containsKey(name) || Controller.promotionProducts.containsKey(name);
    }

    private static void validateProductCount(String count) {
        try {
            CommonUtil.validateInteger(count);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT_TYPE.getMessage());
        }
        if (Integer.parseInt(count) <= Constants.ZERO.getIntValue()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT_TYPE.getMessage());
        }
        if (Integer.parseInt(count) > productStock) {
            throw new IllegalArgumentException(ErrorMessage.QUANTITY_EXCEEDED.getMessage());
        }
    }

    public static void validateYesOrNo(String response) {
        if (!response.equals("Y") && !response.equals("N")) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT_TYPE.getMessage());
        }
    }

    public static boolean isValidatePromotionDate(Promotion promotion) {
        LocalDateTime now = DateTimes.now();
        return !now.isBefore(promotion.startDate()) || !now.isAfter(promotion.endDate());
    }
}
