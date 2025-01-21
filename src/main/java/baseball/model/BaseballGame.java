package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class BaseballGame {
    private final static int MIN_VALUE = 1;
    private final static int MAX_VALUE = 9;
    private final static int CNT = 3;


    // string to int[]
    public static int[] setNumbersList(String stringNumbers) {
        int[] numbers = new int[3];

        for (int i = 0; i < 3; i++) {
            numbers[i] = Integer.parseInt(stringNumbers.substring(i, i + 1));
        }
        return numbers;
    }

    // 답 만듦
    public static int[] setRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(MIN_VALUE, MAX_VALUE, CNT)
                .stream()
                .mapToInt(Integer::intValue)
                .toArray(); // List<Integer> -> int[]
    }

    public static boolean hasDuplicateNums(int[] baseballNumber) {
        return new HashSet<>(Arrays.stream(baseballNumber).boxed().toList()).size() != baseballNumber.length;
    }

    public static boolean hasNumsOutOfRange(int[] baseballNumber) {
        for (int num : baseballNumber) {
            if (num < 1 || num > 9) {
                return false;
            }
        }
        return true;
    }
}
