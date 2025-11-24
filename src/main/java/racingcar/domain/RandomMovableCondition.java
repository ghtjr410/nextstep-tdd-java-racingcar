package racingcar.domain;

import java.util.Random;

public class RandomMovableCondition implements MovableCondition {
    private static final int FORWARD_THRESHOLD = 4;
    private static final int MAX_VALUE = 10;

    private final RandomValueGenerator generator;

    public RandomMovableCondition(RandomValueGenerator generator) {
        this.generator = generator;
    }

    public RandomMovableCondition() {
        this(() -> new Random().nextInt(MAX_VALUE));
    }

    @Override
    public boolean isMovable() {
        return generator.generate() >= FORWARD_THRESHOLD;
    }
}
