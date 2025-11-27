package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public record Winners(List<Car> winners) {

    public Winners {
        if (winners == null || winners.isEmpty()) {
            throw new IllegalArgumentException("우승자는 1명 이상이어야 합니다.");
        }
    }

    public String formatForDisplay() {
        return String.format("%s가 최종 우승했습니다.", String.join(", ", names()));
    }

    private List<String> names() {
        List<String> names = new ArrayList<>();

        for (Car car : winners) {
            names.add(car.name());
        }

        return names;
    }
}
