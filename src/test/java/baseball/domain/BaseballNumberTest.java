package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.in;

class BaseballNumberTest {

    @Test
    @DisplayName("index 위치의 값이 일치하는 경우")
    void index_위치의_값이_일치하는_경우() throws Exception {
        // given
        BaseballNumber baseballNumber = new BaseballNumber(new int[] {1, 2, 3});
        Method checkStrike = baseballNumber.getClass().getDeclaredMethod("checkStrike", int[].class, int.class, int.class);
        checkStrike.setAccessible(true);

        int strikeCount = 0;
        int[] inputNumbers = {1, 2, 3};
        int index = 0;

        // when
        int getStrikeCount = (int) checkStrike.invoke(baseballNumber, inputNumbers, strikeCount, index);

        // then
        assertThat(getStrikeCount).isEqualTo(strikeCount + 1);
    }

    @Test
    @DisplayName("index 위치의 값이 일치하지 않는 경우")
    void index_위치의_값이_일치하지_않는_경우() throws Exception {
        // given
        BaseballNumber baseballNumber = new BaseballNumber(new int[] {1, 2, 3});
        Method checkStrike = baseballNumber.getClass().getDeclaredMethod("checkStrike", int[].class, int.class, int.class);
        checkStrike.setAccessible(true);

        int strikeCount = 0;
        int[] inputNumbers = {2, 3, 4};
        int index = 0;

        // when
        int getStrikeCount = (int) checkStrike.invoke(baseballNumber, inputNumbers, strikeCount, index);

        // then
        assertThat(getStrikeCount).isEqualTo(strikeCount);
    }

    @Test
    @DisplayName("스트라이크 개수 조회")
    void 스트라이크_개수_조회() {
        // given
        BaseballNumber baseballNumber = new BaseballNumber(new int[] {1, 2, 3});
        int[] inputNumbers = {1, 2, 3};

        // when
        int strikeCount = baseballNumber.getStrikeCount(inputNumbers);

        // then
        assertThat(strikeCount).isEqualTo(3);
    }

}