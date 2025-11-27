package racingcar.domain;

import java.util.Objects;

public class RacingRound {
    private static final int START = 1;
    private static final int STEP = 1;

    private final int total;
    private int current;

    public RacingRound(int total) {
        this(total, START);
    }

    public RacingRound(int total, int current) {
        validateTotal(total);
        this.total = total;
        this.current = current;
    }

    private void validateTotal(int total) {
        if (total < START) {
            throw new IllegalArgumentException(String.format("총 라운드 수는 %d이상이어야 합니다.", START));
        }
    }

    public boolean isFinished() {
        return this.current > total;
    }

    public void next() {
        this.current += STEP;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof RacingRound round)) return false;
        return total == round.total && current == round.current;
    }

    @Override
    public int hashCode() {
        return Objects.hash(total, current);
    }
}
