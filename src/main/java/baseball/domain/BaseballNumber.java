package baseball.domain;

import java.util.Arrays;

public class BaseballNumber {

    private int[] targetNumbers; // 맞춰야할 숫자 배열

    public BaseballNumber(int[] targetNumbers) {
        this.targetNumbers = targetNumbers;
    }

    public int[] getTargetNumbers() {
        return targetNumbers;
    }

    /**
     * BaseballNumber 생성
     * @param targetNumbers
     * @return BaseballNumber
     */
    public static BaseballNumber create(int[] targetNumbers) {
        return new BaseballNumber(targetNumbers);
    }

    /**
     * 스트라이크 갯수를 조회한다.
     * @param inputNumbers
     * @return 스트라이크 갯수
     */
    public int getStrikeCount(int[] inputNumbers) {
        int strikeCount = 0;
        for (int i = 0; i < targetNumbers.length; i++) {
            strikeCount = checkStrike(inputNumbers, strikeCount, i);
        }
        return strikeCount;
    }

    /**
     * index의 위치의 값이 일치하는지 검사한다.
     * @param inputNumbers
     * @param strikeCount
     * @param index
     * @return 스트라이크 갯수(증가하거나 그대로)
     */
    private int checkStrike(int[] inputNumbers, int strikeCount, int index) {
        if (targetNumbers[index] == inputNumbers[index]) {
            strikeCount++;
        }
        return strikeCount;
    }

    /**
     * 볼 갯수를 조회한다.
     * @param inputNumbers
     * @return 볼 갯수
     */
    public int getBallCount(int[] inputNumbers) {
        int ballCount = 0;
        for (int i = 0; i < targetNumbers.length; i++) {
            ballCount = checkBall(inputNumbers, ballCount, i);
        }
        return ballCount;
    }

    /**
     * targetIndex를 기준으로 볼이 있는지 검사한다.
     * @param inputNumbers
     * @param ballCount
     * @param targetIndex
     * @return 볼 갯수(증가하거나 그대로)
     */
    private int checkBall(int[] inputNumbers, int ballCount, int targetIndex) {
        for (int j = 0; j < inputNumbers.length; j++) {
            ballCount = checkBall(inputNumbers, ballCount, targetIndex, j);
        }
        return ballCount;
    }

    /**
     * targetIndex와 inputIndex의 값을 기준으로 볼인지 검사한다.
     * @param inputNumbers
     * @param ballCount
     * @param targetIndex
     * @param inputIndex
     * @return 볼 갯수(증가하거나 그대로)
     */
    private int checkBall(int[] inputNumbers, int ballCount, int targetIndex, int inputIndex) {
        if (targetNumbers[targetIndex] == inputNumbers[inputIndex] && targetIndex != inputIndex) {
            ballCount++;
        }
        return ballCount;
    }

    /**
     * inputNumbers의 정답 여부를 반환한다.
     * @param inputNumbers
     * @return 정답 여부
     */
    public boolean isAnswer(int[] inputNumbers) {
        return Arrays.equals(targetNumbers, inputNumbers);
    }

}
