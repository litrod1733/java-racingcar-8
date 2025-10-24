package racingcar.domain.strategy;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomMoveStrategy implements MoveStrategy {
	private static final int START_NUM = 0;
	private static final int END_NUM = 9;
	private static final int MOVE_THRESHOLD = 4;

	@Override
	public boolean movable() {
		return Randoms.pickNumberInRange(START_NUM, END_NUM) >= MOVE_THRESHOLD;
	}
}
