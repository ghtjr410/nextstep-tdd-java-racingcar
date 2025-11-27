package racingcar.domain;

public record CarName(String value) {
    private static final int MAX_LENGTH = 5;

    public CarName {
        validateNotBlank(value);
        validateLength(value);
    }

    private void validateNotBlank(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("자동차 이름은 필수입니다.");
        }
    }

    private void validateLength(String name) {
        if (name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException(String.format("자동차 이름은 1~%d자 사이여야 합니다.", MAX_LENGTH));
        }
    }
}
