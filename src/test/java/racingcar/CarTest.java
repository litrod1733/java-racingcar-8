package racingcar;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import racingcar.domain.Car;

public class CarTest {

	@Test
	void 이동_전략이_true이면_한칸_이동한다() {
		Car car = new Car("pobi");
		car.moveIf(() -> true);
		assertThat(car.getPosition()).isEqualTo(1);
	}

	@Test
	void 이동_전략이_false이면_그대로_정지한다() {
		Car car = new Car("pobi");
		car.moveIf(() -> false);
		assertThat(car.getPosition()).isEqualTo(0);
	}
}
