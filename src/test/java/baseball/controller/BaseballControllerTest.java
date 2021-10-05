package baseball.controller;

import baseball.config.BaseballConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BaseballControllerTest {

    BaseballController baseballController = BaseballConfig.baseballController();

    @Test
    @DisplayName("스트라이크 갯수를 조회 - 성공")
    void 스트라이크_갯수를_조회_성공() {
        // given
        int[] targetNumbers = {1, 2, 3};
        int[] inputNumbers = {1, 2, 3};

        // when
        int strikeCount = baseballController.getStrikeCount(targetNumbers, inputNumbers);

        // then
        assertThat(strikeCount).isEqualTo(3);
    }

    @Test
    @DisplayName("스트라이크 갯수를 조회 - targetNumbers에 중복 숫자 존재")
    void 스트라이크_갯수를_조회_성공_targetNumbers에_중복_숫자_존재() {
        // given
        int[] targetNumbers = {1, 2, 2};
        int[] inputNumbers = {1, 2, 3};

        // when, then
        assertThatThrownBy(() -> baseballController.getStrikeCount(targetNumbers, inputNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복되는 숫자가 존재합니다")
                .hasMessageContaining(Arrays.toString(targetNumbers));
    }

    @Test
    @DisplayName("스트라이크 갯수를 조회 - inputNumbers에 중복 숫자 존재")
    void 스트라이크_갯수를_조회_성공_inputNumbers에_중복_숫자_존재() {
        // given
        int[] targetNumbers = {1, 2, 3};
        int[] inputNumbers = {1, 2, 2};

        // when, then
        assertThatThrownBy(() -> baseballController.getStrikeCount(targetNumbers, inputNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복되는 숫자가 존재합니다")
                .hasMessageContaining(Arrays.toString(inputNumbers));
    }

    @Test
    @DisplayName("스트라이크 갯수를 조회 - 두 숫자의 길이가 다른 경우")
    void 스트라이크_갯수를_조회_성공_두_숫자의_길이가_다른_경우() {
        // given
        int[] targetNumbers = {1, 2, 3};
        int[] inputNumbers = {1, 2, 3, 4};

        // when, then
        assertThatThrownBy(() -> baseballController.getStrikeCount(targetNumbers, inputNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력된 두 숫자의 길이가 다릅니다")
                .hasMessageContaining("타겟 숫자 길이: " + targetNumbers.length)
                .hasMessageContaining("입력 숫자 길이: " + inputNumbers.length);
    }

    @Test
    @DisplayName("볼 갯수를 조회 - 성공")
    void 볼_갯수를_조회_성공() {
        // given
        int[] targetNumbers = {1, 2, 3};
        int[] inputNumbers = {1, 3, 2};

        // when
        int ballCount = baseballController.getBallCount(targetNumbers, inputNumbers);

        // then
        assertThat(ballCount).isEqualTo(2);
    }

    @Test
    @DisplayName("볼 갯수를 조회 - targetNumbers에 중복 숫자 존재")
    void 볼_갯수를_조회_성공_targetNumbers에_중복_숫자_존재() {
        // given
        int[] targetNumbers = {1, 2, 2};
        int[] inputNumbers = {1, 2, 3};

        // when, then
        assertThatThrownBy(() -> baseballController.getBallCount(targetNumbers, inputNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복되는 숫자가 존재합니다")
                .hasMessageContaining(Arrays.toString(targetNumbers));
    }

    @Test
    @DisplayName("볼 갯수를 조회 - inputNumbers에 중복 숫자 존재")
    void 볼_갯수를_조회_성공_inputNumbers에_중복_숫자_존재() {
        // given
        int[] targetNumbers = {1, 2, 3};
        int[] inputNumbers = {1, 2, 2};

        // when, then
        assertThatThrownBy(() -> baseballController.getBallCount(targetNumbers, inputNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복되는 숫자가 존재합니다")
                .hasMessageContaining(Arrays.toString(inputNumbers));
    }

    @Test
    @DisplayName("볼 갯수를 조회 - 두 숫자의 길이가 다른 경우")
    void 볼_갯수를_조회_성공_두_숫자의_길이가_다른_경우() {
        // given
        int[] targetNumbers = {1, 2, 3};
        int[] inputNumbers = {1, 2, 3, 4};

        // when, then
        assertThatThrownBy(() -> baseballController.getBallCount(targetNumbers, inputNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력된 두 숫자의 길이가 다릅니다")
                .hasMessageContaining("타겟 숫자 길이: " + targetNumbers.length)
                .hasMessageContaining("입력 숫자 길이: " + inputNumbers.length);
    }

}