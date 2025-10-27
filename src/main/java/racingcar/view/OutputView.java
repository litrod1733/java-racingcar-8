package racingcar.view;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Cars;

public final class OutputView {

	private OutputView() {}

	public static void printStart() {
		System.out.println("실행 결과");
	}

	public static void printRound(final Cars cars) {
		for (Car car : cars.toList()) {
			printCarState(car.getName(), car.getPosition());
		}
		System.out.println();
	}

	private static void	printCarState(final String name, final int position) {
		StringBuilder bar = new StringBuilder();
		for (int i = 0; i < position; i++) {
			bar.append("-");
		}
		System.out.println(name + " : " + bar);
	}

	public static void printWinners(final List<String> winners) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < winners.size(); i++) {
			sb.append(winners.get(i));
			if (i < winners.size() - 1) {
				sb.append(", ");
			}
		}
		System.out.println("최종 우승자 : " + sb);
	}
}
