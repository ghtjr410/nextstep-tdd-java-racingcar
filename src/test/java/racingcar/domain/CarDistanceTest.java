package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class CarDistanceTest {
    @Test
    void 생성자_인자없음_거리0으로초기화() {
        assertThat(new CarDistance()).isEqualTo(new CarDistance(0));
    }

    @Test
    void increase_거리1증가() {
        assertThat(new CarDistance().increase()).isEqualTo(new CarDistance(1));
    }

    @ParameterizedTest(name = "현재={0}, 비교={1} -> 최대={2}")
    @CsvSource({"0, 1, 1", "1, 0, 1", "1, 1, 1"})
    void max_비교값입력_최대값반환(int current, int compare, int expected) {
        assertThat(new CarDistance(current).max(compare)).isEqualTo(expected);
    }

    @ParameterizedTest(name = "현재={0}, 비교={1} -> 결과={2}")
    @CsvSource({"1, 1, true", "1, 0, false"})
    void isSame_비교값입력_거리가같은지반환(int current, int compare, boolean expected) {
        assertThat(new CarDistance(current).isSame(compare)).isEqualTo(expected);
    }
}
