package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class CarsTest {

    @Test
    void 생성자_정상입력_생성성공() {
        assertThatCode(() -> new Cars("일,이,삼")).doesNotThrowAnyException();
    }

    @ParameterizedTest(name = "빈 값: {0}")
    @NullAndEmptySource
    void 생성자_빈값입력_예외발생(List<Car> inputs) {
        assertThatThrownBy(() -> new Cars(inputs))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차는 1대 이상이어야 합니다.");
    }
}
