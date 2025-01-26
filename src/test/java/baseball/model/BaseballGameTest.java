package baseball.model;

import baseball.controller.BaseballGameController;
import baseball.view.InputView;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

public class BaseballGameTest {
    @Test
    public void testGenerateTargetNumber() {
        // 정답 숫자 3개 생성 확인
        BaseballGame baseballGame = new BaseballGame();
        int[] randomNumber = baseballGame.setRandomNumbers();

        // 정답 숫자 범위, 중복 여부 확인
        assertEquals(3, randomNumber.length);
        assertTrue(randomNumber[0] >= 1 && randomNumber[0] <= 9);
        assertTrue(randomNumber[1] >= 1 && randomNumber[1] <= 9);
        assertTrue(randomNumber[2] >= 1 && randomNumber[2] <= 9);
    }

    @Test
    public void testInputNumber() {
        // 아~ 잘 모르겠서요~
        BaseballGame baseballGame = new BaseballGame();
//        int[] inputNumber = new int[] {1,2,3};
//
//        String result = game.checkGuess(new int[] {1, 2, 3});
//        assertEquals("3 스트라이크", result);

        // 시뮬레이션할 입력값
        String simulatedInput = "123\n";
        ByteArrayInputStream in = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(in);  // System.in을 입력 스트림으로 교체

        InputView inputView = new InputView(); // 기본 생성자 사용

        String userInput = inputView.inputNumbers();
        int[] userInputList = baseballGame.setNumbersList(userInput);

        // 예상한 결과와 비교
        assertArrayEquals(new int[] {1, 2, 3}, userInputList);

        // 테스트 후 System.in 복구
        System.setIn(System.in);
    }

    @Test
    public void testAnswerNumber() {
        // 정답 확인(스트라이크, 볼, ... )
        BaseballGame baseballGame = new BaseballGame();
        BaseballGameController baseballGameController = new BaseballGameController();
        int[] answer = new int[] {1,2,3};

        String result = baseballGame.checkAnswer(answer, new int[] {1, 2, 3});
        assertEquals("3스트라이크", result);

        result = baseballGame.checkAnswer(answer, new int[] {1, 2, 5});
        assertEquals("2스트라이크", result);

        result = baseballGame.checkAnswer(answer, new int[] {1, 3, 2});
        assertEquals("2볼 1스트라이크", result);

        result = baseballGame.checkAnswer(answer, new int[] {1, 4, 2});
        assertEquals("1볼 1스트라이크", result);

        result = baseballGame.checkAnswer(answer, new int[] {1, 4, 5});
        assertEquals("1스트라이크", result);

        result = baseballGame.checkAnswer(answer, new int[] {2, 3, 1});
        assertEquals("3볼", result);

        result = baseballGame.checkAnswer(answer, new int[] {5, 6, 7});
        assertEquals("낫싱", result);
    }
}
