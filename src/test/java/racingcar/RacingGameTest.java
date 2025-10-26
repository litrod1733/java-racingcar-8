package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.controller.RacingGame;
import racingcar.domain.Cars;
import racingcar.domain.Car;
import racingcar.domain.strategy.MoveStrategy;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.InstanceOfAssertFactories.map;

public class RacingGameTest {

	@Test
	void 시도수만큼_이동호출_항상_이동() {
		Cars cars = Cars.fromCsv("pobi, woni, jun");
		MoveStrategy alwaysMove = () -> true;
		int attempts = 5;

		RacingGame game = new RacingGame(cars, attempts, alwaysMove);

		game.play();

		cars.toList().forEach(car -> assertThat(car.getPosition()).isEqualTo(attempts));
	}

	@Test
	void 시도_횟수가_0일때_항상_이동() {
		Cars cars = Cars.fromCsv("pobi, woni, jun");
		MoveStrategy alwaysMove = () -> true;
		int attempts = 0;

		RacingGame game = new RacingGame(cars, attempts, alwaysMove);

		game.play();

		cars.toList().forEach(car -> assertThat(car.getPosition()).isZero());
	}

	@Test
	void 시도수만큼_이동호출_항상_정지() {
		Cars cars = Cars.fromCsv("pobi, woni, jun");
		MoveStrategy neverMove = () -> false;
		int attempts = 5;

		RacingGame game = new RacingGame(cars, attempts, neverMove);

		game.play();

		cars.toList().forEach(car -> assertThat(car.getPosition()).isZero());
	}
}
