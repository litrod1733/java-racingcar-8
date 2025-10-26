package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.domain.Cars;
import racingcar.domain.Car;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class CarsTest {

	@Test
	void CSV_공백_트림_적용되어_Car_생성() {
		Cars cars = Cars.fromCsv("pobi, woni, jun");
		assertThat(cars).isNotNull();
	}

	@Test
	void 중복_이름이_있으면_예외() {
		assertThatThrownBy(() -> Cars.fromCsv("pobi, woni, pobi")).isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	void fromNames_정상_생성() {
		Cars cars = Cars.fromNames(List.of("pobi", "woni", "jun"));
		assertThat(cars).isNotNull();
	}
}
