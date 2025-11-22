package racingcar.domain;

public class RacingGame {
    private Cars cars;
    private MovableCondition movableCondition;

    public RacingGame(Cars cars, MovableCondition movableCondition) {
        this.cars = cars;
        this.movableCondition = movableCondition;
    }

    public RacingGame(String inputNames, MovableCondition movableCondition) {
        this(new Cars(inputNames), movableCondition);
    }

    public void race() {
        cars.moveAll(movableCondition);
    }

    public RaceResult result() {
        return new RaceResult(cars.statuses());
    }
}
