package store.service;

import java.util.LinkedHashMap;
import java.util.Map;
import store.controller.Controller;
import store.dto.OrderDto;
import store.enums.ErrorMessage;
import store.model.Order;
import store.model.Promotion;
import store.validator.OrderValidator;
import store.view.InputView;

public class OrderService {
    private final Map<String, Integer> products = new LinkedHashMap<>();
    private final Map<String, Integer> freeItems = new LinkedHashMap<>();
    private int totalCount = 0;
    private int totalPrice = 0;
    private int promotionDiscount = 0;
    private int membershipDiscount = 0;
    private int resultPurchase = 0;
    private final InputView inputView = new InputView();

    public Order saveOrder() {
        String orderInput = inputView.readOrder();
        String[] orders = orderInput.split(",");

        for (String inputOrder : orders) {
            OrderDto orderDto = extractOrder(inputOrder);

            if (isPromotionExists(orderDto.getName())) {
                Promotion promotion = Controller.promotions.get(
                        Controller.promotionProducts.get(orderDto.getName()).promotion());
                int generalStock = Controller.generalProducts.get(orderDto.getName()).quantity();
                int promotionStock = Controller.promotionProducts.get(orderDto.getName()).quantity();
                if (generalStock + promotionStock < orderDto.getCount()) {
                    throw new IllegalArgumentException(ErrorMessage.QUANTITY_EXCEEDED.getMessage());
                }
                checkPromotionStock(promotion, promotionStock, orderDto);
                checkFreeItem(promotion, orderDto);
            }
        }
        checkMembershipDiscount(totalPrice - promotionDiscount);
        resultPurchase = totalPrice - promotionDiscount - membershipDiscount;
        return new Order(products, freeItems, totalCount, totalPrice, promotionDiscount, membershipDiscount,
                resultPurchase);
    }

    private boolean isPromotionExists(String name) {
        return Controller.promotionProducts.containsKey(name);
    }

    private void checkPromotionStock(Promotion promotion, int promotionStock, OrderDto orderDto) {

        if (promotionStock < orderDto.getCount()) {
            String response = inputView.confirmPromotionExclusion(orderDto.getName(),
                    orderDto.getCount() - maxPromotionCount(promotion, promotionStock));
            OrderValidator.validateYesOrNo(response);
            // TODO try-catch로 유효한 답할때까지...
            if (OrderValidator.isValidatePromotionDate(promotion) && response.equals("Y")) {
                orderDto.setFreeItemCount(
                        maxPromotionCount(promotion, promotionStock) / (promotion.buy() + promotion.get())
                                * promotion.get());
                products.put(orderDto.getName(), orderDto.getCount());
                freeItems.put(orderDto.getName(), orderDto.getFreeItemCount());
                totalCount += orderDto.getCount();
                totalPrice += Controller.generalProducts.get(orderDto.getName()).price() * orderDto.getCount();
                promotionDiscount += Controller.generalProducts.get(orderDto.getName()).price()
                        * orderDto.getFreeItemCount();
            }
        }
    }

    private void checkFreeItem(Promotion promotion, OrderDto orderDto) {
        if (orderDto.getCount() % (promotion.buy() + promotion.get()) != promotion.buy()) {
            return;
        }
        int additionalCount = promotion.get();
        String response = inputView.confirmFreeItemOffer(orderDto.getName(), additionalCount);
        OrderValidator.validateYesOrNo(response);
        if (response.equals("Y")) {
            orderDto.setCount(orderDto.getCount() + additionalCount);
            products.put(orderDto.getName(), orderDto.getCount());
            freeItems.put(orderDto.getName(),
                    orderDto.getCount() / (promotion.get() + promotion.buy()) * promotion.get());
            totalCount += orderDto.getCount();
            totalPrice += Controller.generalProducts.get(orderDto.getName()).price() * orderDto.getCount();
            promotionDiscount +=
                    Controller.generalProducts.get(orderDto.getName()).price() * orderDto.getFreeItemCount();
        }
    }

    private OrderDto extractOrder(String order) {
        String[] orderContent = order.replace("[", "").replace("]", "").split("-");
        return new OrderDto(orderContent[0], orderContent[1]);
    }

    private int maxPromotionCount(Promotion promotion, int stock) {
        int setCount = promotion.buy() + promotion.get();
        int totalCount = 0;
        while (totalCount < stock) {
            totalCount += setCount;
        }
        return totalCount - setCount;
    }

    private void checkMembershipDiscount(int price) {
        membershipDiscount = (int) (price * 0.3);
        if (membershipDiscount > 8000) {
            membershipDiscount = 8000;
        }
    }


}
