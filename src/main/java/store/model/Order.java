package store.model;

import java.util.Map;

public class Order {
    private Map<String, Integer> product;
    private Map<String, Integer> freeItem;
    private int totalCount;
    private int totalPrice;
    private int promotionDiscount;
    private int membershipDiscount;
    private int resultPurchase;

    public Order(Map<String, Integer> product, Map<String, Integer> freeItem, int totalCount, int totalPrice,
                 int promotionDiscount, int membershipDiscount, int resultPurchase) {
        this.product = product;
        this.freeItem = freeItem;
        this.totalCount = totalCount;
        this.totalPrice = totalPrice;
        this.promotionDiscount = promotionDiscount;
        this.membershipDiscount = membershipDiscount;
        this.resultPurchase = resultPurchase;
    }

    public Map<String, Integer> getProduct() {
        return product;
    }

    public Map<String, Integer> getFreeItem() {
        return freeItem;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public int getPromotionDiscount() {
        return promotionDiscount;
    }

    public int getMembershipDiscount() {
        return membershipDiscount;
    }

    public int getResultPurchase() {
        return resultPurchase;
    }

    public void setProduct(Map<String, Integer> product) {
        this.product = product;
    }

    public void setFreeItem(Map<String, Integer> freeItem) {
        this.freeItem = freeItem;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void setPromotionDiscount(int promotionDiscount) {
        this.promotionDiscount = promotionDiscount;
    }

    public void setMembershipDiscount(int membershipDiscount) {
        this.membershipDiscount = membershipDiscount;
    }

    public void setResultPurchase(int resultPurchase) {
        this.resultPurchase = resultPurchase;
    }
}
