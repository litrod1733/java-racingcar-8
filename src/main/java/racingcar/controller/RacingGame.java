package racingcar.controller;

import racingcar.domain.Cars;

public class RacingGame {
	private final Cars cars;
	private final int attempts;

	public RacingGame(Cars cars, int attempts) {
		this.cars = cars;
		this.attempts = attempts;
	}
	public void play() {
		// 시도 횟수만큼 반복
	}
	public Cars getCars() {
		return cars;
	}
}
