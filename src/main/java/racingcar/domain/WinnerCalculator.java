package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WinnerCalculator {

	private WinnerCalculator() {}

	public static List<String> calculate(final Cars cars) {
		List<Car> list = cars.toList();
		if (list.isEmpty()) {
			return Collections.emptyList();
		}

		int max = 0;
		for (Car car : list) {
			if (car.getPosition() > max) {
				max = car.getPosition();
			}
		}

		List<String> winners = new ArrayList<>();
		for (Car car : list) {
			if (car.getPosition() == max) {
				winners.add(car.getName());
			}
		}
		return Collections.unmodifiableList(winners);
	}
}
