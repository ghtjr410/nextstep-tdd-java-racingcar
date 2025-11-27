package racingcar.domain;

import racingcar.utils.MovableCondition;

public class RacingGame {
    private final Cars cars;
    private final RacingRound round;

    public RacingGame(String inputNames, RacingRound round) {
        this(new Cars(inputNames), round);
    }

    public RacingGame(String inputNames, int tryNumber) {
        this(new Cars(inputNames), new RacingRound(tryNumber));
    }

    public RacingGame(Cars cars, RacingRound round) {
        this.cars = cars;
        this.round = round;
    }

    public void race(MovableCondition condition) {
        if (isFinished()) {
            throw new IllegalArgumentException("게임이 종료되었습니다.");
        }

        cars.moveAll(condition);
        round.next();
    }

    public RaceResult result() {
        return cars.status();
    }

    public Winners winners() {
        return cars.winners();
    }

    public boolean isFinished() {
        return round.isFinished();
    }
}
