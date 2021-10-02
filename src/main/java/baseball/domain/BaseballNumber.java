package baseball.domain;

public class BaseballNumber {

    private int[] targetNumbers; // 맞춰야할 숫자 배열

    public BaseballNumber(int[] targetNumbers) {
        this.targetNumbers = targetNumbers;
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
     * @return 스트라이크 갯수
     */
    private int checkStrike(int[] inputNumbers, int strikeCount, int index) {
        if (targetNumbers[index] == inputNumbers[index]) {
            strikeCount++;
        }
        return strikeCount;
    }

}
