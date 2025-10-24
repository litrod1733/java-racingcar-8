package racingcar.domain;

import racingcar.domain.strategy.MoveStrategy;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Cars {
	private final List<Car> cars;

	private Cars(List<Car> cars) {
		this.cars = List.copyOf(cars);
	}
	public static Cars fromCsv(String csv) {
		List<String> names = Arrays.stream(csv.split(",")).map(String::trim).filter(name -> !name.isEmpty()).toList();

		validateDuplicate(names);
		return fromNames(names);
	}
	public static Cars fromNames(List<String> names) {
		if (names.isEmpty()) {
			throw new IllegalArgumentException("자동차 이름 목록이 비어 있습니다.");
		}

		List<Car> cars = names.stream().map(Car::new).toList();

		return new Cars(cars);
	}
	private static void validateCsv(String csv) {
		if (csv == null || csv.trim().isEmpty()) {
			throw new IllegalArgumentException("자동차 이름을 입력해야 합니다.");
		}
	}
	private static void validateDuplicate(List<String> names) {
		Set<String> distinctNames = new HashSet<>(names);
		if (distinctNames.size() != names.size()) {
			throw new IllegalArgumentException("자동차 이름은 중복될 수 없습니다.");
		}
	}
	public void moveAll(MoveStrategy strategy) {
		for (Car car : cars) {
			car.moveIf(strategy);
		}
	}
}
