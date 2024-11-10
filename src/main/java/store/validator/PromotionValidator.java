package store.validator;

import store.enums.Constants;
import store.enums.ErrorMessage;
import store.util.CommonUtil;

public class PromotionValidator {
    public static void validatePromotion(String name, String buy, String get, String start_date, String end_date) {
        validatePromotionName(name);
        validatePromotionBuy(buy);
        validatePromotionGet(get);
        validatePromotionStartDate(start_date);
        validatePromotionEndDate(end_date);
    }

    private static void validatePromotionName(String name) {
        if (name.isBlank() || name.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_FILE_TYPE.getMessage());
        }
    }

    private static void validatePromotionBuy(String buy) {
        try {
            CommonUtil.validateInteger(buy);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_FILE_TYPE.getMessage());
        }
        if (Integer.parseInt(buy) <= Constants.ZERO.getIntValue()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_FILE_TYPE.getMessage());
        }
    }

    private static void validatePromotionGet(String get) {
        try {
            CommonUtil.validateInteger(get);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_FILE_TYPE.getMessage());
        }
        if (Integer.parseInt(get) <= Constants.ZERO.getIntValue()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_FILE_TYPE.getMessage());
        }
    }

    private static void validatePromotionStartDate(String start_date) {
        try {
            CommonUtil.validateDate(start_date);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_FILE_TYPE.getMessage());
        }
    }

    private static void validatePromotionEndDate(String end_date) {
        try {
            CommonUtil.validateDate(end_date);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_FILE_TYPE.getMessage());
        }
    }
}
