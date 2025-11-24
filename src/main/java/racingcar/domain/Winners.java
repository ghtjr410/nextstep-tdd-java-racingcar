package racingcar.domain;

import java.util.List;

public record Winners(List<Car> winners) {

    public Winners {
        if (winners == null || winners.isEmpty()) {
            throw new IllegalArgumentException("우승자는 1명 이상이어야 합니다.");
        }
    }
}
