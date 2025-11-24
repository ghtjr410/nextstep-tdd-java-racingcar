package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class RandomMovableConditionTest {

    @ParameterizedTest(name = "랜덤값: {0}")
    @ValueSource(ints = {4, 9})
    void isMovable_이동가능(int input) {
        RandomValueGenerator generator = () -> input;

        RandomMovableCondition condition = new RandomMovableCondition(generator);

        assertThat(condition.isMovable()).isTrue();
    }

    @ParameterizedTest(name = "랜덤값: {0}")
    @ValueSource(ints = {0, 3})
    void isMovable_이동불가능(int input) {
        RandomValueGenerator generator = () -> input;

        RandomMovableCondition condition = new RandomMovableCondition(generator);

        assertThat(condition.isMovable()).isFalse();
    }
}
