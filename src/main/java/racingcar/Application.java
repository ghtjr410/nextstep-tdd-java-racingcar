package racingcar;

import racingcar.domain.*;
import racingcar.utils.RandomMovableCondition;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class Application {
    public static void main(String[] args) {
        String carNames = InputView.getCarNames();
        int tryNumber = InputView.getTryNumber();

        ResultView.printHeader();

        RacingGame game = new RacingGame(carNames, tryNumber);
        var condition = new RandomMovableCondition();

        while (!game.isFinished()) {
            game.race(condition);

            ResultView.printRaceResult(game.result());
        }

        ResultView.printWinners(game.winners());
    }
}
