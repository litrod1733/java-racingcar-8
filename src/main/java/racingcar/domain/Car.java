package racingcar.domain;

import racingcar.domain.strategy.MoveStrategy;

public class Car {
	private final String name;
	private int position = 0;

	public Car(String name) {
		this.name = name;
	}

	public void move(int num) {
		this.position += num;
	}
	public String getName() {
		return this.name;
	}
	public int getPosition() {
		return this.position;
	}
	public void moveIf(MoveStrategy strategy) {
		if (strategy.movable()) {
			this.position++;
		}
	}
	@Override
	public String toString() {
		return String.format("Car{name = '%s', position = %d}", name, position);
	}
}
