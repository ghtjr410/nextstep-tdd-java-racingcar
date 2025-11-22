package racingcar.domain;

public class Car {
    private final CarName name;
    private CarDistance distance;

    public Car(CarName name, CarDistance distance) {
        this.name = name;
        this.distance = distance;
    }

    public Car(String name) {
        this(new CarName(name), new CarDistance());
    }

    public void move(MovableCondition condition) {
        if (condition.isMovable()) {
            this.distance = distance.increase();
        }
    }

    public int getDistance() {
        return distance.value();
    }
}
