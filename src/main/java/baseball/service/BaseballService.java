package baseball.service;

import baseball.domain.BaseballNumber;

public class BaseballService {

    /**
     * 스트라이크 갯수를 조회한다.
     * @param targetNumbers
     * @param inputNumbers
     * @return 스트라이크 갯수
     */
    public int getStrikeCount(int[] targetNumbers, int[] inputNumbers) {
        BaseballNumber baseballNumber = BaseballNumber.create(targetNumbers);
        return baseballNumber.getStrikeCount(inputNumbers);
    }

    /**
     * 볼 갯수를 조회한다.
     * @param targetNumbers
     * @param inputNumbers
     * @return 볼 갯수
     */
    public int getBallCount(int[] targetNumbers, int[] inputNumbers) {
        BaseballNumber baseballNumber = BaseballNumber.create(targetNumbers);
        return baseballNumber.getBallCount(inputNumbers);
    }

    /**
     * 정답 여부를 조회한다.
     * @param targetNumbers
     * @param inputNumbers
     * @return 정답이면 true, 아니면 false
     */
    public boolean checkAnswer(int[] targetNumbers, int[] inputNumbers) {
        BaseballNumber baseballNumber = BaseballNumber.create(targetNumbers);
        return baseballNumber.isAnswer(inputNumbers);
    }
}
