package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class CarNameTest {

    @Test
    void 이름이_5자를_초과하면_예외_발생() {
        assertThatThrownBy(() -> new CarName("일이삼사오육"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 1~5자 사이여야 합니다.");
    }
}
