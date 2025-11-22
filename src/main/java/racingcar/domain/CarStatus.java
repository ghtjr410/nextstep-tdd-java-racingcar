package racingcar.domain;

public record CarStatus(String name, int distance) {

    public CarStatus(CarName name, CarDistance distance) {
        this(name.value(), distance.value());
    }
}
