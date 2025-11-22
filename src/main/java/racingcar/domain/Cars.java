package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> values;

    public Cars(List<Car> values) {
        this.values = new ArrayList<>(values);
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
}
