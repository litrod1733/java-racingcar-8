package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.domain.strategy.MoveStrategy;

public class RacingGame {
	private final Cars cars;
	private final int attempts;
	private final MoveStrategy strategy;

	public RacingGame(Cars cars, int attempts, MoveStrategy strategy) {
		this.cars = cars;
		this.attempts = attempts;
		this.strategy = strategy;
	}
	public void play() {
		// 시도 횟수만큼 반복
		for (int i = 0; i < attempts; i++) {
			cars.moveAll(strategy);
		}
	}
	public Cars getCars() {
		return cars;
	}
}
