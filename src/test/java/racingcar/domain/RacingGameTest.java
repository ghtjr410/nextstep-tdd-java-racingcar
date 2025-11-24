package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class RacingGameTest {

    @Test
    void race_게임_종료_후_실행_예외발생() {
        RacingGame game = new RacingGame("사과,바나나", new RacingRound(1, 2));
        RandomMovableCondition condition = new RandomMovableCondition();

        assertThatThrownBy(() -> game.race(condition))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("게임이 종료되었습니다.");
    }
}
