package baseball.view;

public class OutputView {
    private final String startingMessage = "숫자 야구 게임을 시작합니다.";
    private final String endingMessage = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    public void startGame() {
        System.out.println(startingMessage);
    }

    public void roundResult(String message){
        System.out.println(message);
    }

    public void endGame() {
        System.out.println(endingMessage);
    }
}