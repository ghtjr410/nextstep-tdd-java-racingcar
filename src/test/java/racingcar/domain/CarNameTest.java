package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class CarNameTest {

    @ParameterizedTest(name = "정상 입력: {0}")
    @ValueSource(strings = {"일", "일이삼사오"})
    void 생성_정상입력_생성성공(String input) {
        assertThatCode(() -> new CarName(input)).doesNotThrowAnyException();
    }

    @ParameterizedTest(name = "빈 값: {0}")
    @NullAndEmptySource
    @ValueSource(strings = {" ", "\t", " \n"})
    void 생성_빈값입력_예외발생(String input) {
        assertThatThrownBy(() -> new CarName(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 필수입니다.");
    }

    @Test
    void 생성_길이초과_예외발생() {
        assertThatThrownBy(() -> new CarName("일이삼사오육"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 1~5자 사이여야 합니다.");
    }
}
