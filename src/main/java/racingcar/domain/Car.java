package racingcar.domain;

import racingcar.domain.strategy.MoveStrategy;

public class Car {
	private static final int MAX_NAME_LENGTH = 5;

	private final String name;
	private int position = 0;

	public Car(String name) {
		validateName(name);
		this.name = name;
	}
	private void validateName(String name) {
		if (name == null || name.trim().isEmpty()) {
			throw new IllegalArgumentException("자동차 이름은 비어 있을 수 없습니다.");
		}
		if (name.trim().length() > MAX_NAME_LENGTH) {
			throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다.");
		}
	}
	public void move(int step) {
		if (step > 0) {
			this.position += step;
		}
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
