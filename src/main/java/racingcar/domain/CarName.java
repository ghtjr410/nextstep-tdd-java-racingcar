package racingcar.domain;

public record CarName(String value) {
    public CarName {
        if (value.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 1~5자 사이여야 합니다.");
        }
    }
}
