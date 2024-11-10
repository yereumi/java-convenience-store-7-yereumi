package store.validator;

import java.util.List;
import store.enums.Constants;
import store.enums.ErrorMessage;
import store.model.Promotion;
import store.util.CommonUtil;

public class ProductValidator {
    public static void validateProduct(String name, String price, String quantity, String promotion,
                                       List<Promotion> promotions) {
        validateProductName(name);
        validateProductPrice(price);
        validateProductQuantity(quantity);
        validateProductPromotion(promotion, promotions);
    }

    private static void validateProductName(String name) {
        if (name.isBlank() || name.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_FILE_TYPE.getMessage());
        }
    }

    private static void validateProductPrice(String price) {
        try {
            CommonUtil.validateInteger(price);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_FILE_TYPE.getMessage());
        }
        if (Integer.parseInt(price) <= Constants.ZERO.getIntValue()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_FILE_TYPE.getMessage());
        }
    }

    private static void validateProductQuantity(String quantity) {
        try {
            CommonUtil.validateInteger(quantity);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_FILE_TYPE.getMessage());
        }
        if (Integer.parseInt(quantity) < Constants.ZERO.getIntValue()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_FILE_TYPE.getMessage());
        }
    }

    private static void validateProductPromotion(String promotion, List<Promotion> promotions) {
        if (!promotions.contains(promotion)) {
            throw new IllegalArgumentException(ErrorMessage.PRODUCT_NOT_FOUND.getMessage());
        }
    }
}
