package racingcar.policy;

import racingcar.random.RandomValueGenerator;

public class DefaultRandomValueMovePolicy implements RandomValueMovePolicy {
    private static final int FORWARD_THRESHOLD = 4;

    private final RandomValueGenerator randomValueGenerator;

    public DefaultRandomValueMovePolicy(RandomValueGenerator randomValueGenerator) {
        this.randomValueGenerator = randomValueGenerator;
    }

    @Override
    public boolean moveable() {
        var value = randomValueGenerator.generate();

        return value.isGreaterThan(FORWARD_THRESHOLD);
    }
}
