package store.enums;

public enum ErrorMessage {
    ERROR_PREFIX("[ERROR]"),
    INVALID_INTEGER_TYPE("올바르지 않은 정수 형식입니다."),
    INVALID_DATE_TYPE("올바르지 않은 날짜 형식 입니다."),
    INVALID_FILE_PATH("올바르지 않은 파일 경로입니다. 파일을 다시 업로드해 주세요."),
    INVALID_FILE_TYPE("올바르지 않은 파일 형식입니다. 파일을 다시 업로드해 주세요."),
    INVALID_INPUT_TYPE("올바르지 않은 형식으로 입력했습니다. 다시 입력해 주세요."),
    PRODUCT_NOT_FOUND("존재하지 않는 상품입니다. 다시 입력해 주세요."),
    QUANTITY_EXCEEDED("재고 수량을 초과하여 구매할 수 없습니다. 다시 입력해 주세요."),
    INVALID_INPUT("잘못된 입력입니다. 다시 입력해 주세요.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return ERROR_PREFIX.message + message;
    }
}
