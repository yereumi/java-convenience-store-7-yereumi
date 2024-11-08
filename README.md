# java-convenience-store-precourse

## 기능 목록

### 1. 입력에 관한 기능

- `src/main/resources/products.md`, `src/main/resources/promotions.md` 파일 입력
  - 상품명, 가격, 수량, 프로모션 유효성 검증
- `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용하여 구매 입력
  - 구매할 상품명, 수량 유효성 검증
  - 구분자 유효성 검증: 하이픈(-), 대괄호([])
- 프로모션 적용이 가능한 상품에 대해 고객이 해당 수량보다 적게 가져온 경우, 그 수량만큼 추가 여부 입력(Y/N)
- 프로모션 재고가 부족하여 일부 수량을 프로모션 혜택 없이 결제해야 하는 경우, 일부 수량에 대해 정가로 결제할지 여부 입력(Y/N)
- 멤버십 할인 적용 여부 입력(Y/N)
- 추가 구매 여부 입력(Y/N)

### 2. 출력에 관한 기능

- 환영 인사와 함께 상품명, 가격, 프로모션 이름, 재고 출력
  - 만약 재고가 0개라면 `재고 없음`을 출력
- 프로모션 적용이 가능한 상품에 대해 고객이 해당 수량만큼 가져오지 않았을 경우, 혜택에 대한 안내 메시지 출력
- 프로모션 재고가 부족하여 일부 수량을 프로모션 혜택 없이 결제해야 하는 경우, 일부 수량에 대해 정가로 결제할지 여부에 대한 안내 메시지 출력
- 멤버십 할인 적용 여부를 확인하기 위해 안내 문구 출력
- 구매 상품 내역, 증정 상품 내역, 금액 정보 출력
- 추가 구매 여부를 확인하기 위해 안내 문구 출력
- 고객의 구매 내역과 할인을 요약 출력 기능
  - 구매 상품 내역: 구매한 상품명, 수량, 가격
  - 증정 상품 내역: 프로모션에 따라 무료로 제공된 증정 삼품의 목록
  - 금액 정보
    - 총구매액: 구매한 상품의 총 수량과 총 금액
    - 행사할인: 프로모션에 의해 할인된 금액
    - 멤버십할인: 멤버십에 의해 추가로 할인된 금액
    - 내실돈: 최종 결제 금액
- 사용자가 잘못된 값을 입력했을 때, "[ERROR]"로 시작하는 오류 메시지와 함께 상황에 맞는 안내 출력
  - 구매할 상품과 수량 형식이 올바르지 않은 경우: `[ERROR] 올바르지 않은 형식으로 입력했습니다. 다시 입력해 주세요.`
  - 존재하지 않는 상품을 입력한 경우: `[ERROR] 존재하지 않는 상품입니다. 다시 입력해 주세요.`
  - 구매 수량이 재고 수량을 초과한 경우: `[ERROR] 재고 수량을 초과하여 구매할 수 없습니다. 다시 입력해 주세요.`
  - 기타 잘못된 입력의 경우: `[ERROR] 잘못된 입력입니다. 다시 입력해 주세요.`


### 3. 유효성 검증 기능

#### products 파일 입력

- 상품명이 공백이 아닌 문자열인지 검증
- 가격, 수량이 1 이상의 숫자인지 검증
- 프로모션명이 존재하는지 검증

#### promotions 파일 입력

- 프로모션명이 공백이 아닌 문자열인지 검증
- buy가 1 이상의 숫자인지 검증
- get이 1 이상의 숫자인지 검증
- start_date, end_date가 0000-00-00 형식인지 검증

#### 구매 입력

- 구매할 상품명이 공백이 아닌 문자열인지 검증
- 수량이 1 이상의 숫자인지 검증
- 구매할 상품명이 존재하는지 검증
- 수량이 재고 수량을 초과하지 않는지 검증
- 구분자(하이픈, 대괄호) 외의 문자가 사용되지 않았는지 검증
- Y/N으로만 입력해야하는 경우 그 외의 문자가 사용되지 않았는지 검증

### 4. 재고 관리 기능

- 결제 가능 여부 확인 기능
- 결제된 수량만큼 해당 상품의 재고에서 차감 기능

### 5. 프로모션 할인 기능

- 오늘 날짜가 프로모션 기간 내에 포함되는지 확인 기능
- 프로모션 재고 확인 기능
- 프로모션 혜택 적용 확인 기능

### 6. 멤버십 할인 기능

- 프로모션 미적용 금액 확인 기능
- 멤버십 할인 최대 한도 확인 기능
- 멤버십 할인 기능

---

## 예외 목록

- 파일 입력 형식이 올바르지 않은 경우
  - `[ERROR] 올바르지 않은 파일 형식입니다. 파일을 다시 업로드해 주세요.`
- 구매 입력 형식이 올바르지 않은 경우
  - `[ERROR] 올바르지 않은 형식으로 입력했습니다. 다시 입력해 주세요.`
- 존재하지 않는 상품을 입력한 경우
  - `[ERROR] 존재하지 않는 상품입니다. 다시 입력해 주세요.`
- 구매 수량이 재고 수량을 초과한 경우
  - `[ERROR] 재고 수량을 초과하여 구매할 수 없습니다. 다시 입력해 주세요.`
- 기타 잘못된 입력의 경우
  - `[ERROR] 잘못된 입력입니다. 다시 입력해 주세요.`
