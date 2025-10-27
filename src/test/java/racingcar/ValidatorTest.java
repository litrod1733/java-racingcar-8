package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.util.Validator;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

public class ValidatorTest {

	@Test
	void 이름목록_정상() {
		Validator.validateNames(List.of("pobi", "woni", "jun"));
	}

	@Test
	void 이름_빈값이면_예외() {
		assertThatThrownBy(() -> Validator.validateNames(List.of("pobi", "", "jun"))).isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	void 이름_길이초과_예외() {
		assertThatThrownBy(() -> Validator.validateNames(List.of("pobi", "abcdef"))).isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	void 이름_중복_예외() {
		assertThatThrownBy(() -> Validator.validateNames(List.of("pobi", "pobi"))).isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	void 시도횟수_숫자아님_예외() {
		assertThatThrownBy(() -> Validator.validateAttempts("3a")).isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	void 시도횟수_0이하_예외() {
		assertThatThrownBy(() -> Validator.validateAttempts("0")).isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	void 시도횟수_정상반환() {
		int v = Validator.validateAttempts("5");
		assertThat(v).isEqualTo(5);
	}
}
