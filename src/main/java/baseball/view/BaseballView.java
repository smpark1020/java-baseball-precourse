package baseball.view;

import baseball.config.BaseballConfig;
import baseball.controller.BaseballController;
import nextstep.utils.Console;
import nextstep.utils.Randoms;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class BaseballView {

    private static final BaseballController baseballController = BaseballConfig.baseballController();
    private static final int BASEBALL_SIZE = 3;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;
    private static boolean IS_FINISH = false;

    /**
     * 게임의 메인 메서드
     * @return 게임 종료 여부
     */
    public static boolean baseballStart() {
        int[] targetNumbers = createTargetNumbers();
        System.out.println(Arrays.toString(targetNumbers));
        boolean isAnswer = false;
        while (!isAnswer) {
            int[] inputNumbers = getInputNumbers();
            isAnswer = checkAnswer(targetNumbers, inputNumbers);
        }
        return IS_FINISH;
    }

    /**
     * 맞춰야하는 숫자를 생성한다.
     * @return 맞춰야 하는 숫자 배열
     */
    private static int[] createTargetNumbers() {
        Set<Integer> set = new HashSet<>();
        int[] targetNumbers = new int[BASEBALL_SIZE];
        int targetIndex = 0;
        while (set.size() < BASEBALL_SIZE) {
            targetIndex = createRandomNumber(set, targetNumbers, targetIndex);
        }
        return targetNumbers;
    }

    /**
     * 중복되지 않는 숫자일 경우에만 숫자를 저장한다.
     * @param set
     * @param targetNumbers
     * @param targetIndex
     * @return 다음 targetIndex
     */
    private static int createRandomNumber(Set<Integer> set, int[] targetNumbers, int targetIndex) {
        int num = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
        if (!set.contains(num)) {
            set.add(num);
            targetNumbers[targetIndex] = num;
            targetIndex++;
        }
        return targetIndex;
    }

    /**
     * 사용자 입력 숫자 배열을 생성한다.
     * @return 사용자 입력 숫자 배열
     */
    private static int[] getInputNumbers() {
        boolean isContinue = false;
        int[] inputNumbers = null;
        while (!isContinue) {
            System.out.print("숫자를 입력해주세요: ");
            String inputStr = Console.readLine();
            inputNumbers = new int[inputStr.length()];
            settingInputNumbers(inputStr, inputNumbers);
            isContinue = validateInputNumbers(inputNumbers, inputStr);
        }
        return inputNumbers;
    }

    /**
     * 입력된 문자열을 int형 배열에 저장한다.
     * @param inputStr
     * @param inputNumbers
     */
    private static void settingInputNumbers(String inputStr, int[] inputNumbers) {
        for (int i = 0; i < inputNumbers.length; i++) {
            inputNumbers[i] = inputStr.charAt(i) - '0';
        }
    }

    /**
     * 각 자리에 입력된 값이 1~9 범위의 숫자인지 유효성 검증한다.
     * @param inputNumbers
     * @param inputStr
     * @return 정상이면 true, 아니면 false
     */
    private static boolean validateInputNumbers(int[] inputNumbers, String inputStr) {
        int invalidCount = 0;
        for (int num : inputNumbers) {
            invalidCount = (num < MIN_NUMBER || num > MAX_NUMBER) ? invalidCount + 1 : invalidCount;
        }
        if (invalidCount > 0) {
            System.out.println("[ERROR] 각 자리의 숫자는 " + MIN_NUMBER + " ~ " + MAX_NUMBER
                    + " 범위의 숫자만 입력 가능합니다.(공백도 불가) (입력값: " + inputStr + ")");
            return false;
        }
        return true;
    }

    /**
     * 결과를 확인한다.
     * @param targetNumbers
     * @param inputNumbers
     * @return
     */
    private static boolean checkAnswer(int[] targetNumbers, int[] inputNumbers) {
        try {
            return checkAnswerResult(targetNumbers, inputNumbers);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
            return false;
        }
    }

    /**
     * 결과를 출력하고, 정답일 경우 게임 종료 여부를 선택한다.
     * @param targetNumbers
     * @param inputNumbers
     * @return 게임 종료 여부
     */
    private static boolean checkAnswerResult(int[] targetNumbers, int[] inputNumbers) {
        boolean isAnswer = checkAnswerAndPrintResult(targetNumbers, inputNumbers);
        if (isAnswer) {
            System.out.println(BASEBALL_SIZE + "개의 숫자를 모두 맞히셨습니다! 게임 끝");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            checkFinish();
            return true;
        }
        return false;
    }

    /**
     * 정답 확인 후 결과를 출력하고 반환한다.
     * @param targetNumbers
     * @param inputNumbers
     * @return 정답 여부
     */
    private static boolean checkAnswerAndPrintResult(int[] targetNumbers, int[] inputNumbers) {
        boolean isAnswer = baseballController.checkAnswer(targetNumbers, inputNumbers);
        int strikeCount = baseballController.getStrikeCount(targetNumbers, inputNumbers);
        int ballCount = baseballController.getBallCount(targetNumbers, inputNumbers);
        if (strikeCount == 0 && ballCount == 0) {
            System.out.println("낫싱");
            return isAnswer;
        }
        printBaseballCountMessage(strikeCount, ballCount);
        return isAnswer;
    }

    /**
     * 사용자로부터 게임 종료 여부를 입력 받는다.
     */
    private static void checkFinish() {
        boolean isFinish = false;
        while (!isFinish) {
            String inputStr = Console.readLine();
            isFinish = checkInputStr(inputStr);
        }
    }

    /**
     * 게임 종료 여부 입력 값을 확인한다.
     * @param inputStr
     * @return 게임 종료 여부 입력 성공 여부
     */
    private static boolean checkInputStr(String inputStr) {
        if ("1".equals(inputStr)) {
            return true;
        }
        if ("2".equals(inputStr)) {
            IS_FINISH = true;
            return true;
        }
        System.out.println("[ERROR] 1과 2만 입력 가능합니다. (입력값: " + inputStr + ")");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return false;
    }

    /**
     * 스트라이크와 볼 갯수를 출력한다.
     * @param strikeCount
     * @param ballCount
     */
    private static void printBaseballCountMessage(int strikeCount, int ballCount) {
        if (strikeCount > 0 && ballCount == 0) {
            System.out.println(strikeCount + "스트라이크");
            return;
        }
        if (strikeCount == 0 && ballCount > 0) {
            System.out.println(ballCount + "볼");
            return;
        }
        System.out.println(strikeCount + "스트라이크 " + ballCount + "볼");
    }
}