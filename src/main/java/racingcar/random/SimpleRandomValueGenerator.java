package racingcar.random;

import java.util.Random;
import racingcar.domain.RandomNumber;

public class SimpleRandomValueGenerator implements RandomValueGenerator {
    private final Random random;

    private static final int MAX_VALUE = 10;

    public SimpleRandomValueGenerator() {
        this.random = new Random();
    }

    @Override
    public RandomNumber generate() {
        return new RandomNumber(random.nextInt(MAX_VALUE));
    }
}
