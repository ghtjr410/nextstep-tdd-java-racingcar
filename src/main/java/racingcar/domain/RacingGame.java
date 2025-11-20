package racingcar.domain;

import racingcar.policy.MovePolicy;

public class RacingGame {
    private final Cars cars;
    private final MovePolicy movePolicy;

    public RacingGame(Cars cars, MovePolicy movePolicy) {
        this.cars = cars;
        this.movePolicy = movePolicy;
    }

    public RaceHistory race(int roundCount) {
        return executeRounds(new Round(roundCount));
    }

    private RaceHistory executeRounds(Round round) {
        RaceHistory raceHistory = new RaceHistory();

        while (!round.isFinished()) {
            executeRound();
            raceHistory.record(getRoundResult());

            round.next();
        }

        return raceHistory;
    }

    private void executeRound() {
        cars.moveAll(this.movePolicy);
    }

    private RoundResult getRoundResult() {
        return new RoundResult(cars.toSnapshots());
    }
}
