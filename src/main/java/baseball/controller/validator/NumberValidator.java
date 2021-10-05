package baseball.controller.validator;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class NumberValidator {

    /**
     * targetNumbers와 inputNumber의 유효성을 검증한다.
     * 1. 중복된 숫자가 있는지 검사한다.
     * 2. 두 숫자의 길이를 검사한다.
     * @param targetNumbers
     * @param inputNumbers
     * @throws IllegalArgumentException 중복된 숫자가 존재하는 경우, 입력된 두 숫자배열의 길이가 다른 경우
     */
    public void validate(int[] targetNumbers, int[] inputNumbers) {
        validateDuplicateNumber(targetNumbers);
        validateDuplicateNumber(inputNumbers);
        validateNumbersLength(targetNumbers, inputNumbers);
    }

    /**
     * 입력된 두 숫자의 길이의 유효성을 검증한다.
     * @param targetNumbers
     * @param inputNumbers
     * @throws IllegalArgumentException 중복된 숫자가 존재하는 경우
     */
    private void validateNumbersLength(int[] targetNumbers, int[] inputNumbers) {
        if (targetNumbers.length != inputNumbers.length) {
            throw new IllegalArgumentException(
                    "입력된 두 숫자의 길이가 다릅니다. (맞춰야하는 숫자 길이: " + targetNumbers.length + ", 입력 숫자 길이: " + inputNumbers.length + ")");
        }
    }

    /**
     * 중복된 숫자가 있는지 검증한다.
     * @param numbers
     * @throws IllegalArgumentException 중복되는 숫자가 있는 경우
     */
    private void validateDuplicateNumber(int[] numbers) {
        Set<Integer> set = new HashSet<>();
        for (int num : numbers) {
            checkContains(numbers, set, num);
        }
    }

    /**
     * 주어진 num이 set에 있는지 검증한다.
     * @param numbers
     * @param set
     * @param num
     * @throws IllegalArgumentException num이 set에 이미 존재하는 경우
     */
    private void checkContains(int[] numbers, Set<Integer> set, int num) {
        if (set.contains(num)) {
            throw new IllegalArgumentException("중복되는 숫자가 존재합니다. (" + Arrays.toString(numbers) + ")");
        }
        set.add(num);
    }

}
