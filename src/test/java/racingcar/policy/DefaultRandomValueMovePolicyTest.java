package racingcar.policy;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import racingcar.domain.RandomValue;
import racingcar.random.RandomValueGenerator;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class DefaultRandomValueMovePolicyTest {

    @Test
    void moveable_랜덤값이_4_미만이면_이동_불가능() {
        RandomValueGenerator generator = () -> new RandomValue(3);
        DefaultRandomValueMovePolicy policy = new DefaultRandomValueMovePolicy(generator);

        assertThat(policy.moveable()).isFalse();
    }

    @Test
    void moveable_랜덤값이_4_이상이면_이동_가능() {
        RandomValueGenerator generator = () -> new RandomValue(4);
        DefaultRandomValueMovePolicy policy = new DefaultRandomValueMovePolicy(generator);

        assertThat(policy.moveable()).isTrue();
    }
}
