package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.domain.strategy.RandomMoveStrategy;

import static org.assertj.core.api.Assertions.assertThatNoException;

public class RandomMoveStrategyTest {

	@Test
	void 랜덤_전략_호출_예외없이_동작한다() {
		RandomMoveStrategy strategy = new RandomMoveStrategy();
		assertThatNoException().isThrownBy(strategy::movable);
	}
}
