package racingcar.view;

import racingcar.domain.CarStatus;
import racingcar.domain.RaceResult;
import racingcar.domain.Winners;

public class ResultView {
    private static final String RESULT_HEADER = "실행 결과";

    public static void printHeader() {
        System.out.println(RESULT_HEADER);
    }

    public static void printRaceResult(RaceResult result) {
        for (CarStatus status : result.statuses()) {
            printCarStatus(status);
        }
        System.out.println();
    }

    private static void printCarStatus(CarStatus status) {
        System.out.println(status.formatForDisplay());
    }

    public static void printWinners(Winners winners) {
        System.out.println(winners.formatForDisplay());
    }
}
