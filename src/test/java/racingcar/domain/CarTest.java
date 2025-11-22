package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class CarTest {

    @Test
    void 생성_이름으로_생성성공() {
        assertThatCode(() -> new Car("자동차")).doesNotThrowAnyException();
    }

    @Test
    void move_이동가능_전진() {
        MovableCondition condition = () -> true;
        Car car = new Car("자동차");

        car.move(condition);

        assertThat(car.status().distance()).isEqualTo(1);
    }

    @Test
    void move_이동불가능_정지() {
        MovableCondition condition = () -> false;
        Car car = new Car("자동차");

        car.move(condition);

        assertThat(car.status().distance()).isEqualTo(0);
    }
}
