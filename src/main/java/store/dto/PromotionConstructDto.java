package store.dto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import store.model.Promotion;
import store.validator.PromotionValidator;

public class PromotionConstructDto {
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private final String[] promotion;

    public PromotionConstructDto(String[] promotion) {
        this.promotion = promotion;
    }

    public Promotion toEntity() {
        String name = promotion[0];
        String buy = promotion[1];
        String get = promotion[2];
        String start_date = promotion[3];
        String end_date = promotion[4];
        PromotionValidator.validatePromotion(name, buy, get, start_date, end_date);
        return new Promotion(Integer.parseInt(buy), Integer.parseInt(get),
                LocalDate.parse(start_date, DATE_FORMATTER).atStartOfDay(),
                LocalDate.parse(end_date, DATE_FORMATTER).atStartOfDay());
    }
}
