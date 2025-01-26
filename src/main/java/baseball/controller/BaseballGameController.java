package baseball.controller;

import baseball.model.BaseballGame;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.List;
import java.util.Objects;

public class BaseballGameController {
    private InputView inputView;
    private OutputView outputView;
    private BaseballGame baseballGame;

    public void run() {
        inputView = new InputView();
        outputView = new OutputView();
        baseballGame = new BaseballGame();

        //게임 시작
        // List<Integer> answer = baseballGame.setRandomNumbers();
        // while: 정답이 아닐 동안 || for: 9번 동안(정답 맞힐 최대 라운드 수)

        //  일단 한 라운드만 진행할게요...
        String userContinue = "1";
        while(userContinue.equals("1") || userContinue.equals("1\n")) {
            outputView.startGame();
            // 랜덤 숫자 선정
            int[] answer = baseballGame.setRandomNumbers();

            while(true) {
                // userInput 초기화
                String userInput = inputView.inputNumbers();
                int[] userInputList = baseballGame.setNumbersList(userInput);

                // 인풋 받아서 리스트로 변경
                // 입력 값 중복, 범위 검증
                if(baseballGame.hasDuplicateNums(userInputList)) { throw new IllegalArgumentException("중복되지 않은 3개의 수를 입력하세요."); }
                if(baseballGame.hasNumsOutOfRange(userInputList)) { throw new IllegalArgumentException("1~9 사이의 수를 입력하세요."); }

                // input값과 answer 비교 -> OutputView 호출
                // 비교 결과 출력

                String outMessage = BaseballGame.checkAnswer(answer, userInputList);
                outputView.roundResult(outMessage);

                if (Objects.equals(outMessage, "3스트라이크")) {
                    outputView.endGame();
                    break;
                }
            }
            userContinue = inputView.continueGame();
        }
    }
}
