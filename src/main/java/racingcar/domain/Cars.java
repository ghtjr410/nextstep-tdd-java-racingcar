package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> values;

    public Cars(List<Car> inputs) {
        validateNotEmpty(inputs);
        this.values = new ArrayList<>(inputs);
    }

    private void validateNotEmpty(List<Car> inputs) {
        if (inputs == null || inputs.isEmpty()) {
            throw new IllegalArgumentException("자동차는 1대 이상이어야 합니다.");
        }
    }

    public Cars(String inputNames) {
        this(createCars(inputNames));
    }

    private static List<Car> createCars(String inputNames) {
        List<Car> cars = new ArrayList<>();

        for (String name : split(inputNames)) {
            cars.add(new Car(name));
        }

        return cars;
    }

    private static String[] split(String input) {
        return input.split(",");
    }

    public void moveAll(MovableCondition condition) {
        for (Car car : values) {
            car.move(condition);
        }
    }

    public List<CarStatus> statuses() {
        List<CarStatus> statuses = new ArrayList<>();

        for (Car car : values) {
            statuses.add(car.status());
        }

        return statuses;
    }

    public Winners winners() {
        return new Winners(findWinners(findMaxDistance()));
    }

    private List<Car> findWinners(int maxDistance) {
        return this.values.stream()
                .filter(car -> car.isSameDistance(maxDistance))
                .toList();
    }

    private int findMaxDistance() {
        int max = 0;
        for (Car car : this.values) {
            max = car.maxDistance(max);
        }
        return max;
    }
}
