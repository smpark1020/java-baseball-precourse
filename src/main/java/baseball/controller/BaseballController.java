package baseball.controller;

import baseball.controller.validator.NumberValidator;
import baseball.service.BaseballService;

public class BaseballController {

    private final BaseballService baseballService;
    private final NumberValidator numberValidator;

    public BaseballController(BaseballService baseballService, NumberValidator numberValidator) {
        this.baseballService = baseballService;
        this.numberValidator = numberValidator;
    }

    /**
     * 스트라이크 갯수를 조회한다.
     * @param targetNumbers
     * @param inputNumbers
     * @return 스트라이크 갯수
     * @throws IllegalArgumentException 중복된 숫자가 존재하는 경우, 입력된 두 숫자배열의 길이가 다른 경우
     */
    public int getStrikeCount(int[] targetNumbers, int[] inputNumbers) {
        numberValidator.validate(targetNumbers, inputNumbers);
        return baseballService.getStrikeCount(targetNumbers, inputNumbers);
    }

    /**
     * 볼 갯수를 조회한다.
     * @param targetNumbers
     * @param inputNumbers
     * @return 볼 갯수
     * @throws IllegalArgumentException 중복된 숫자가 존재하는 경우, 입력된 두 숫자배열의 길이가 다른 경우
     */
    public int getBallCount(int[] targetNumbers, int[] inputNumbers) {
        numberValidator.validate(targetNumbers, inputNumbers);
        return baseballService.getBallCount(targetNumbers, inputNumbers);
    }

}
