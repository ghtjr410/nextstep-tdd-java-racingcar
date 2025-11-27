package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class CarTest {

    @Test
    void 생성자_이름으로_생성성공() {
        assertThatCode(() -> new Car("자동차")).doesNotThrowAnyException();
    }

    @Test
    void move_이동가능_전진() {
        Car car = new Car("자동차", 0);

        car.move(() -> true);

        assertThat(car).isEqualTo(new Car("자동차", 1));
    }

    @Test
    void move_이동불가능_정지() {
        Car car = new Car("자동차", 0);

        car.move(() -> false);

        assertThat(car).isEqualTo(new Car("자동차", 0));
    }

    @Test
    void status_현재상태반환() {
        assertThat(new Car("자동차", 0).status()).isEqualTo(new CarStatus("자동차", 0));
    }
}
