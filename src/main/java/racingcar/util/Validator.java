package racingcar.util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class Validator {

	private Validator() {}

	public static final	String ERR_EMPTY_NAME = "자동차 이름은 비어 있을 수 없습니다.";
	public static final String ERR_NAME_LENGTH = "자동차 이름은 5자 이하여야 합니다.";
	public static final String ERR_DUPLICATE_NAME = "자동차 이름은 중복될 수 없습니다.";
	public static final String ERR_ATTEMPTS_NOT_NUMBER = "시도 횟수는 숫자여야 합니다.";
	public static final String ERR_ATTEMPTS_RANGE = "시도 횟수는 1 이상의 정수여야 합니다.";

	public static void validateNames(final List<String> rawNames) {
		if (rawNames == null || rawNames.isEmpty()) {
			throw new IllegalArgumentException(ERR_EMPTY_NAME);
		}

		final Set<String> seen = new HashSet<>();
		for (String raw : rawNames) {
			String name = "";
			if (raw != null) {
				name = raw.trim();
			}

			if (name.isEmpty()) {
				throw new IllegalArgumentException(ERR_EMPTY_NAME);
			}
			if (name.length() > 5) {
				throw new IllegalArgumentException(ERR_NAME_LENGTH);
			}
			if (!seen.add(name)) {
				throw new IllegalArgumentException(ERR_DUPLICATE_NAME);
			}
		}
	}

	public static int validateAttempts(final String raw) {
		if (raw == null || raw.isBlank()) {
			throw new IllegalArgumentException(ERR_ATTEMPTS_NOT_NUMBER);
		}

		for (char c : raw.toCharArray()) {
			if (!Character.isDigit(c)) {
				throw new IllegalArgumentException(ERR_ATTEMPTS_NOT_NUMBER);
			}
		}

		int attempts = Integer.parseInt(raw);
		if (attempts < 1) {
			throw new IllegalArgumentException(ERR_ATTEMPTS_RANGE);
		}
		return attempts;
	}
}
