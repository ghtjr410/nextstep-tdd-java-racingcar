package racingcar.domain;

public record CarDistance(int value) {
    private static final int DEFAULT_DISTANCE = 0;
    private static final int STEP = 1;

    public CarDistance() {
        this(DEFAULT_DISTANCE);
    }

    public CarDistance increase() {
        return new CarDistance(this.value + STEP);
    }

    public int max(int that) {
        return Math.max(this.value, that);
    }

    public boolean isSame(int that) {
        return this.value == that;
    }
}
