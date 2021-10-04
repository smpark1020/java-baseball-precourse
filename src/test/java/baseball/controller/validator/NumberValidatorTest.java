package baseball.controller.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;

class NumberValidatorTest {

    NumberValidator numberValidator = new NumberValidator();

    @Test
    @DisplayName("주어진 num이 set에 있는지 검증 - 중복 없음")
    void 주어진_num이_set에_있는지_검증_중복_없음() throws Exception {
        // given
        Method checkContains = numberValidator.getClass().getDeclaredMethod("checkContains", int[].class, Set.class, int.class);
        checkContains.setAccessible(true);

        Set<Integer> set = new HashSet<>();
        set.add(1);
        int[] numbers = {1, 2, 3};
        int num = 2;

        // when
        checkContains.invoke(numberValidator, numbers, set, num);

        // then
        assertThat(set.size()).isEqualTo(2);
    }

    @Test
    @DisplayName("주어진 num이 set에 있는지 검증 - 중복 발생")
    void 주어진_num이_set에_있는지_검증_중복_발생() throws Exception {
        // given
        Method checkContains = numberValidator.getClass().getDeclaredMethod("checkContains", int[].class, Set.class, int.class);
        checkContains.setAccessible(true);

        Set<Integer> set = new HashSet<>();
        set.add(1);
        int[] numbers = {1, 1, 3};
        int num = 1;

        // when, then
        assertThatThrownBy(() -> checkContains.invoke(numberValidator, numbers, set, num))
                .isInstanceOf(InvocationTargetException.class)
                .getCause()
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복되는 숫자가 존재합니다")
                .hasMessageContaining(Arrays.toString(numbers));
    }

    @Test
    @DisplayName("중복된 숫자가 있는지 검증 - 중복 숫자 없음")
    void 중복된_숫자가_있는지_검증_중복_숫자_없음() throws Exception {
        // given
        Method validateDuplicateNumber = numberValidator.getClass().getDeclaredMethod("validateDuplicateNumber", int[].class);
        validateDuplicateNumber.setAccessible(true);

        int[] numbers = {1, 2, 3};

        // when, then
        validateDuplicateNumber.invoke(numberValidator, numbers);
    }

    @Test
    @DisplayName("중복된 숫자가 있는지 검증 - 중복 숫자 있음")
    void 중복된_숫자가_있는지_검증_중복_숫자_있음() throws Exception {
        // given
        Method validateDuplicateNumber = numberValidator.getClass().getDeclaredMethod("validateDuplicateNumber", int[].class);
        validateDuplicateNumber.setAccessible(true);

        int[] numbers = {1, 2, 2};

        // when, then
        assertThatThrownBy(() -> validateDuplicateNumber.invoke(numberValidator, numbers))
                .isInstanceOf(InvocationTargetException.class)
                .getCause()
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복되는 숫자가 존재합니다")
                .hasMessageContaining(Arrays.toString(numbers));
    }

    @Test
    @DisplayName("입력된 두 숫자의 길이의 유효성을 검증 - 길이 같음")
    void 입력된_숫자의_길이의_유효성을_검증_길이_같음() throws Exception {
        // given
        Method validateNumbersLength = numberValidator.getClass().getDeclaredMethod("validateNumbersLength", int[].class, int[].class);
        validateNumbersLength.setAccessible(true);

        int[] targetNumbers = {1, 2, 3};
        int[] inputNumbers = {1, 2, 3};

        // when, then
        validateNumbersLength.invoke(numberValidator, targetNumbers, inputNumbers);
    }

    @Test
    @DisplayName("입력된 두 숫자의 길이의 유효성을 검증 - 길이 다름")
    void 입력된_숫자의_길이의_유효성을_검증_길이_다름() throws Exception {
        // given
        Method validateNumbersLength = numberValidator.getClass().getDeclaredMethod("validateNumbersLength", int[].class, int[].class);
        validateNumbersLength.setAccessible(true);

        int[] targetNumbers = {1, 2, 3};
        int[] inputNumbers = {1, 2, 3, 4};

        // when, then
        assertThatThrownBy(() -> validateNumbersLength.invoke(numberValidator, targetNumbers, inputNumbers))
                .isInstanceOf(InvocationTargetException.class)
                .getCause()
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력된 두 숫자의 길이가 다릅니다")
                .hasMessageContaining("타겟 숫자 길이: " + targetNumbers.length)
                .hasMessageContaining("입력 숫자 길이: " + inputNumbers.length);
    }

    @Test
    @DisplayName("targetNumbers와 inputNumber의 유효성을 검증 - 정상 입력")
    void targetNumbers와_inputNumber의_유효성을_검증_정상_입력(){
        // given
        int[] targetNumbers = {1, 2, 3};
        int[] inputNumbers = {1, 2, 3};

        // when, then
        numberValidator.validate(targetNumbers, inputNumbers);
    }

    @Test
    @DisplayName("targetNumbers와 inputNumber의 유효성을 검증 - targetNumbers 중복 숫자 존재")
    void targetNumbers와_inputNumber의_유효성을_검증_targetNumbers_중복_숫자_존재(){
        // given
        int[] targetNumbers = {1, 1, 3};
        int[] inputNumbers = {1, 2, 3};

        // when, then
        assertThatThrownBy(() -> numberValidator.validate(targetNumbers, inputNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복되는 숫자가 존재합니다")
                .hasMessageContaining(Arrays.toString(targetNumbers));
    }

    @Test
    @DisplayName("targetNumbers와 inputNumber의 유효성을 검증 - inputNumbers 중복 숫자 존재")
    void targetNumbers와_inputNumber의_유효성을_검증_inputNumbers_중복_숫자_존재(){
        // given
        int[] targetNumbers = {1, 2, 3};
        int[] inputNumbers = {1, 1, 3};

        // when, then
        assertThatThrownBy(() -> numberValidator.validate(targetNumbers, inputNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복되는 숫자가 존재합니다")
                .hasMessageContaining(Arrays.toString(inputNumbers));
    }

    @Test
    @DisplayName("targetNumbers와 inputNumber의 유효성을 검증 - 서로 길이 다른 경우")
    void targetNumbers와_inputNumber의_유효성을_검증_서로_길이_다른_경우(){
        // given
        int[] targetNumbers = {1, 2, 3};
        int[] inputNumbers = {1, 2, 3, 4};

        // when, then
        assertThatThrownBy(() -> numberValidator.validate(targetNumbers, inputNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력된 두 숫자의 길이가 다릅니다")
                .hasMessageContaining("타겟 숫자 길이: " + targetNumbers.length)
                .hasMessageContaining("입력 숫자 길이: " + inputNumbers.length);
    }
}