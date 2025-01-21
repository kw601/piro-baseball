package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static String inputNumbers() {
        try {
            System.out.println("숫자를 입력해주세요: ");
            return Console.readLine();
        }
        catch(IllegalArgumentException e) {
            return inputNumbers();
        }
    }

    // 나중에 게임 계속할건지 물어보는 코드
    public static String inputNumbers(int number) {
        try {
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            return Console.readLine();
        }
        catch(IllegalArgumentException e) {
            return inputNumbers();
        }
    }
}
