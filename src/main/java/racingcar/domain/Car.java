package racingcar.domain;

public record Car(CarName name, CarDistance distance) {

    public Car(String name) {
        this(new CarName(name), new CarDistance());
    }
}
