package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class BaseballGame {
    private final static int MIN_VALUE = 1;
    private final static int MAX_VALUE = 9;
    private final static int CNT = 3;

    private static final String failMessage = "낫싱";
    private static final String successMessage = "3스트라이크";

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

    public static boolean hasDuplicateNums(int[] inputNumbers) {
        return new HashSet<>(Arrays.stream(inputNumbers).boxed().toList()).size() != inputNumbers.length;
    }

    public static boolean hasNumsOutOfRange(int[] inputNumbers) {
        for (int num : inputNumbers) {
            if (num < 1 || num > 9) {
                return false;
            }
        }
        return true;
    }

    // 비교 -> 볼 count
    public static int countBall(int[] answer, int[] inputNumbers) {
        int ballCount = 0;
        List<Integer> answerList = convertToList(answer);
        List<Integer> inputNumbersList = convertToList(inputNumbers);

        for (int i = 0; i < answer.length; i++) {
            if (answerList.contains(inputNumbers[i]) && inputNumbers[i] != answer[i]) {
                ballCount++;
            }
        }

        return ballCount;
    }

    // 비교 -> 스트라이크 count
    public static int countStrike(int[] answer, int[] inputNumbers) {
        int strikeCount = 0;
        for (int i = 0; i < answer.length; i++) {
            if (answer[i] == (inputNumbers[i])) {
                strikeCount++;
            }
        }

        return strikeCount;
    }

    public static String checkAnswer(int[] answer, int[] inputNumbers) {
        int strikeCount = countStrike(answer, inputNumbers);
        int ballCount = countBall(answer, inputNumbers);

        String outMessage = "";

        if (ballCount == 0 && strikeCount == 0){
            return failMessage;
        }

        if (strikeCount == 3){
            return successMessage;
        }

        if (ballCount != 0){
            outMessage += ballCount + "볼";
        }

        if (strikeCount != 0){
            if (ballCount != 0) { outMessage += " "; }
            outMessage += strikeCount + "스트라이크";
        }

        return outMessage;
    }
    // int[] -> List<Integer> : 아 진짜 리팩토링 할까...
    public static List<Integer> convertToList(int[] array) {
        List<Integer> list = new ArrayList<>();
        for (int num : array) {
            list.add(num);
        }
        return list;
    }
}
