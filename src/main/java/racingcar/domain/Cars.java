package racingcar.domain;

import racingcar.domain.strategy.MoveStrategy;

import java.util.Arrays;
import java.util.List;

public class Cars {
	private final List<Car> cars;

	private Cars(List<Car> cars) {
		this.cars = List.copyOf(cars);
	}
	public static Cars fromCsv(String csv) {
		List<String> names = Arrays.stream(csv.split(",")).map(String::trim).toList();

		return fromNames(names);
	}
	public static Cars fromNames(List<String> names) {
		List<Car> cars = names.stream().map(Car::new).toList();

		return new Cars(cars);
	}
	public void moveAll(MoveStrategy strategy) {
		for (Car car : cars) {
			car.moveIf(strategy);
		}
	}
}
