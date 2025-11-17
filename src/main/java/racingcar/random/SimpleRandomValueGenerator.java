package racingcar.random;

import java.util.Random;
import racingcar.domain.RandomValue;

public class SimpleRandomValueGenerator implements RandomValueGenerator {
    private final Random random;

    private static final int MAX_VALUE = 10;

    public SimpleRandomValueGenerator() {
        this.random = new Random();
    }

    @Override
    public RandomValue generate() {
        return new RandomValue(random.nextInt(MAX_VALUE));
    }
}
