package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class RacingRoundTest {

    @Test
    void 생성자_현재라운드1로초기화() {
        assertThat(new RacingRound(5)).isEqualTo(new RacingRound(5, 1));
    }

    @Test
    void 생성자_총라운드0이하_예외발생() {
        assertThatThrownBy(() -> new RacingRound(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("총 라운드 수는 1이상이어야 합니다.");
    }

    @ParameterizedTest(name = "총 라운드: {0}, 현재 라운드:{1} -> 결과:{2}")
    @CsvSource({"1, 1, false", "1, 2, true"})
    void isFinished_남은_라운드_여부확인(int total, int current, boolean expected) {
        assertThat(new RacingRound(total, current).isFinished()).isEqualTo(expected);
    }

    @Test
    void next_현재라운드1증가() {
        RacingRound round = new RacingRound(2, 1);

        round.next();

        assertThat(round).isEqualTo(new RacingRound(2, 2));
    }
}
