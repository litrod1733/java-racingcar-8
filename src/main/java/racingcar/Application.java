package racingcar;

import racingcar.controller.RacingGame;
import racingcar.domain.*;
import racingcar.domain.strategy.RandomMoveStrategy;
import racingcar.util.Validator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String rawNames = InputView.readNames();
        Validator.validateNames(List.of(rawNames.split(",")));
        Cars cars = Cars.fromCsv(rawNames);

        String rawAttempts = InputView.readAttempts();
        int attempts = Validator.validateAttempts(rawAttempts);

        OutputView.printStart();

        RandomMoveStrategy strategy = new RandomMoveStrategy();
        for (int i = 0; i < attempts; i++) {
            cars.moveAll(new RandomMoveStrategy());
            OutputView.printRound(cars);
        }

        List<String> winners = WinnerCalculator.calculate(cars);
        OutputView.printWinners(winners);
    }
}
