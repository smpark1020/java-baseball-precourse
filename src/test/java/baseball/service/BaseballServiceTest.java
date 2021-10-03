package baseball.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BaseballServiceTest {

    BaseballService baseballService = new BaseballService();

    @Test
    @DisplayName("스트라이크 갯수 조회")
    void 스트라이크_갯수_조회() {
        // given
        int[] targetNumbers = {1, 2, 3};
        int[] inputNumbers = {1, 3, 2};

        // when
        int strikeCount = baseballService.getStrikeCount(targetNumbers, inputNumbers);

        // then
        assertThat(strikeCount).isEqualTo(1);
    }

    @Test
    @DisplayName("볼 갯수 조회")
    void 볼_갯수_조회() {
        // given
        int[] targetNumbers = {1, 2, 3};
        int[] inputNumbers = {1, 3, 2};

        // when
        int ballCount = baseballService.getBallCount(targetNumbers, inputNumbers);

        // then
        assertThat(ballCount).isEqualTo(2);
    }

    @Test
    @DisplayName("정답 여부 확인")
    void 정답_여부_확인() {
        // given
        int[] targetNumbers = {1, 2, 3};
        int[] inputNumbers1 = {1, 2, 3};
        int[] inputNumbers2 = {1, 3, 2};

        // when
        boolean isAnswer1 = baseballService.checkAnswer(targetNumbers, inputNumbers1);
        boolean isAnswer2 = baseballService.checkAnswer(targetNumbers, inputNumbers2);

        // then
        assertThat(isAnswer1).isTrue();
        assertThat(isAnswer2).isFalse();
    }
}