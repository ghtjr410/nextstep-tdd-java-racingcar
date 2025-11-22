package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class CarDistanceTest {
    @Test
    void 생성_기본값으로_초기화() {
        assertThat(new CarDistance().value()).isEqualTo(0);
    }

    @Test
    void increase_거리증가() {
        assertThat(new CarDistance().increase().value()).isEqualTo(1);
    }
}
