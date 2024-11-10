package store.model;

import java.time.LocalDateTime;

public record Promotion(int buy, int get, LocalDateTime startDate, LocalDateTime endDate) {
}
