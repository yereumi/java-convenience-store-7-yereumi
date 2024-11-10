package store.dto;

import store.model.Product;
import store.validator.ProductValidator;

public class ProductConstructDto {
    private final String[] product;

    public ProductConstructDto(String[] product) {
        this.product = product;
    }

    public Product toEntity() {
        String name = product[0];
        String price = product[1];
        String quantity = product[2];
        String promotion = product[3];
        ProductValidator.validateProduct(name, price, quantity, promotion); // TODO 리팩토링
        return new Product(Integer.parseInt(price), Integer.parseInt(quantity), promotion);
    }
}
