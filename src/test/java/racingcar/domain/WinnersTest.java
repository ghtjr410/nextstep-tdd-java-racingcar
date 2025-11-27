package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
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

    @Test
    void formatForDisplay_우승자_포맷된문자열반환() {
        Car apple = new Car("사과");
        Car banana = new Car("바나나");
        assertThat(new Winners(List.of(apple, banana)).formatForDisplay()).isEqualTo("사과, 바나나가 최종 우승했습니다.");
    }
}
