package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class WinnersTest {

    @ParameterizedTest(name = "빈값: {0}")
    @NullAndEmptySource
    void 생성자_빈값_예외발생(List<Car> inputs) {
        assertThatThrownBy(() -> new Winners(inputs))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("우승자는 1명 이상이어야 합니다.");
    }
}
