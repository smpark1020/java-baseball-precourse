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

}