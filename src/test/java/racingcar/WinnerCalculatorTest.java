package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.domain.Cars;
import racingcar.domain.WinnerCalculator;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WinnerCalculatorTest {

	@Test
	void woni_단독_우승자() {
		Cars cars = Cars.fromCsv("pobi, woni, jun");

		cars.toList().get(0).moveIf(() -> true);

		cars.toList().get(1).moveIf(() -> true);
		cars.toList().get(1).moveIf(() -> true);

		cars.toList().get(2).moveIf(() -> false);

		List<String> winners = WinnerCalculator.calculate(cars);

		assertThat(winners).containsExactly("woni");
	}

	@Test
	void 공동_우승자() {
		Cars cars = Cars.fromCsv("pobi, woni, jun");
		cars.moveAll(() -> true);
		cars.moveAll(() -> true);

		List<String> winners = WinnerCalculator.calculate(cars);
		assertThat(winners).containsExactlyInAnyOrder("pobi", "woni", "jun");
	}
}
