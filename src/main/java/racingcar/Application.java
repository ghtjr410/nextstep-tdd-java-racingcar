package racingcar;

import racingcar.domain.Cars;
import racingcar.domain.RaceHistory;
import racingcar.domain.RacingGame;
import racingcar.policy.DefaultRandomValueMovePolicy;
import racingcar.policy.RandomValueMovePolicy;
import racingcar.random.RandomValueGenerator;
import racingcar.random.SimpleRandomValueGenerator;
import racingcar.view.InputView;
import racingcar.view.RaceGameInput;
import racingcar.view.ResultView;

public class Application {
    public static void main(String[] args) {
        RaceGameInput input = InputView.readRaceGameInput();

        RaceHistory history = executeRaceGame(input);

        ResultView.printRaceHistory(history);
    }

    private static RaceHistory executeRaceGame(RaceGameInput input) {
        Cars cars = new Cars(input.carNames());

        RacingGame game = new RacingGame(cars, createDefaultMovePolicy());

        return game.race(input.roundCount());
    }

    private static RandomValueMovePolicy createDefaultMovePolicy() {
        RandomValueGenerator generator = new SimpleRandomValueGenerator();
        return new DefaultRandomValueMovePolicy(generator);
    }
}
