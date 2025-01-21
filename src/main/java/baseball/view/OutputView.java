package baseball.view;

public class OutputView {
    private final String startingMessage = "숫자 야구 게임을 시작합니다.";
    private final String failMessage = "낫싱";
    private final String successMessage = "3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    public void startGame() {
        System.out.println(startingMessage);
    }

    public void roundResult(int ballCount, int strikeCount){
        if (ballCount == 0 && strikeCount == 0){
            System.out.println(failMessage);
            return;
        }

        if (strikeCount == 3){
            System.out.println(successMessage);
            return;
        }

        if (ballCount != 0){
            System.out.print(ballCount+"볼 ");
        }

        if (strikeCount != 0){
            System.out.println(strikeCount+"스트라이크");
        }
    }

    public void endGame() {}
}