package store.dto;

import store.controller.Controller;
import store.model.Product;
import store.validator.OrderValidator;

public class OrderDto {
    private final String name;
    private int count;
    private int totalPrice;
    private int freeItemCount;

    public OrderDto(String name, String count) {
        OrderValidator.validateOrder(name, count);
        this.name = name;
        this.count = Integer.parseInt(count);
        this.totalPrice = calculateTotalPrice();
    }

    public String getName() {
        return name;
    }

    public int getCount() {
        return count;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public int getFreeItemCount() {
        return freeItemCount;
    }

    private Product getProductByName() {
        return Controller.generalProducts.get(name);
    }

    private int calculateTotalPrice() {
        return getProductPrice() * count;
    }

    private int getProductPrice() {
        return getProductByName().price();
    }

    public void setFreeItemCount(int count) {
        this.freeItemCount = count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }
}
