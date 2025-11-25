package racingcar.domain;

import java.util.Objects;
import racingcar.utils.MovableCondition;

public class Car {
    private final CarName name;
    private CarDistance distance;

    public Car(CarName name, CarDistance distance) {
        this.name = name;
        this.distance = distance;
    }

    public Car(String name, int distance) {
        this(new CarName(name), new CarDistance(distance));
    }

    public Car(String name) {
        this(new CarName(name), new CarDistance());
    }

    public void move(MovableCondition condition) {
        if (condition.isMovable()) {
            this.distance = distance.increase();
        }
    }

    public CarStatus status() {
        return new CarStatus(name, distance);
    }

    public int maxDistance(int that) {
        return distance.max(that);
    }

    public boolean isSameDistance(int that) {
        return distance.isSame(that);
    }

    public String name() {
        return name.value();
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Car car)) return false;
        return Objects.equals(name, car.name) && Objects.equals(distance, car.distance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, distance);
    }
}
