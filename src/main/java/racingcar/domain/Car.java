package racingcar.domain;

import racingcar.policy.MovePolicy;

public class Car {
    private final CarName name;
    private CarDistance distance;

    public Car(String name) {
        this.name = new CarName(name);
        this.distance = new CarDistance();
    }

    public void move(MovePolicy movePolicy) {
        if (movePolicy.moveable()) {
            this.distance = distance.increase();
        }
    }

    public CarSnapshot toSnapshot() {
        return new CarSnapshot(name, distance);
    }
}
