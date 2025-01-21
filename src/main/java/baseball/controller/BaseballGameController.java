package baseball.controller;

import baseball.model.BaseballGame;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.List;

public class BaseballGameController {
    private InputView inputView;
    private OutputView outputView;
    private BaseballGame baseballGame;

    public void run() {
        inputView = new InputView();
        outputView = new OutputView();
        baseballGame = new BaseballGame();

        //게임 시작
        // 랜덤 숫자 선정
        int[] answer = baseballGame.setRandomNumbers();
        // List<Integer> answer = baseballGame.setRandomNumbers();
        // while: 정답이 아닐 동안 || for: 9번 동안(정답 맞힐 최대 라운드 수)

        //  일단 한 라운드만 진행할게요...
        outputView.startGame();

        // 인풋 받아서 리스트로 변경
        String userInput = inputView.inputNumbers();
        int[] userInputList = baseballGame.setNumbersList(userInput);

        // input값과 answer 비교 -> OutputView 호출
        // 비교 결과 출력

        int ballCnt = baseballGame.countBall(answer, userInputList);
        int strikeCnt = baseballGame.countStrike(answer, userInputList);
        outputView.roundResult(ballCnt, strikeCnt);

        // if 정답: break;
        if (strikeCnt == 3) {
            return;
        }
    }
}
