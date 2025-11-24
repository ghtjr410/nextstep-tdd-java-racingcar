package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class CarStatusTest {

    @Test
    void formatForDisplay_이름과거리_포맷된문자열반환() {
        assertThat(new CarStatus("자동차", 1).formatForDisplay()).isEqualTo("자동차 : -");
    }
}
