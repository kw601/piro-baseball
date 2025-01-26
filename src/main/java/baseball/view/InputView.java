package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static String inputNumbers() {
        try {
            System.out.print("숫자를 입력해주세요: ");
            String userInput = Console.readLine();
            if(userInput.length() != 3) { throw new IllegalArgumentException(); }

            return userInput;
        }
        catch(IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }
    }

    // 나중에 게임 계속할건지 물어보는 코드
    public static String continueGame() {
        try {
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String userInput = Console.readLine();
            if(userInput != "1" || userInput != "2") { throw new IllegalArgumentException(); }
            return userInput;
        }
        catch(IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }
    }
}
