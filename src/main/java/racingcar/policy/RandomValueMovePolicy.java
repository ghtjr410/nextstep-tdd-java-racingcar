package racingcar.policy;

import racingcar.random.RandomValueGenerator;

public class RandomValueMovePolicy implements MovePolicy {
    private static final int FORWARD_THRESHOLD = 4;

    private final RandomValueGenerator randomValueGenerator;

    public RandomValueMovePolicy(RandomValueGenerator randomValueGenerator) {
        this.randomValueGenerator = randomValueGenerator;
    }

    @Override
    public boolean moveable() {
        var value = randomValueGenerator.generate();

        return value.isGreaterThan(FORWARD_THRESHOLD);
    }
}
