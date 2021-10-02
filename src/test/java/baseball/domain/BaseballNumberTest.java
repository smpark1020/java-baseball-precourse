package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;

import static org.assertj.core.api.Assertions.assertThat;

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

    @Test
    @DisplayName("targetIndex와 inputIndex의 값을 기준으로 볼인지 검사")
    void targetIndex와_inputIndex의_값을_기준으로_볼인지_검사() throws Exception {
        // given
        BaseballNumber baseballNumber = new BaseballNumber(new int[] {1, 2, 3});
        Method checkBall = baseballNumber.getClass().getDeclaredMethod("checkBall", int[].class, int.class, int.class, int.class);
        checkBall.setAccessible(true);

        int[] inputNumbers = {2, 1, 3};
        int ballCount = 0;
        int targetIndex = 0;
        int inputIndex = 1;

        // when
        int getBallCount = (int) checkBall.invoke(baseballNumber, inputNumbers, ballCount, targetIndex, inputIndex);

        // then
        assertThat(getBallCount).isEqualTo(ballCount + 1);
    }

    @Test
    @DisplayName("targetIndex를 기준으로 볼이 있는지 검사")
    void targetIndex를_기준으로_볼이_있는지_검사() throws Exception {
        // given
        BaseballNumber baseballNumber = new BaseballNumber(new int[] {1, 2, 3});
        Method checkBall = baseballNumber.getClass().getDeclaredMethod("checkBall", int[].class, int.class, int.class);
        checkBall.setAccessible(true);

        int[] inputNumbers = {2, 1, 3};
        int ballCount = 0;
        int targetIndex = 0;

        // when
        int getBallCount = (int) checkBall.invoke(baseballNumber, inputNumbers, ballCount, targetIndex);

        // then
        assertThat(getBallCount).isEqualTo(ballCount + 1);
    }
    
    @Test
    @DisplayName("볼 갯수를 조회")
    void 볼_갯수_조회() {
        // given
        BaseballNumber baseballNumber = new BaseballNumber(new int[] {1, 2, 3});
        int[] inputNumbers = {1, 3, 2};

        // when
        int ballCount = baseballNumber.getBallCount(inputNumbers);

        // then
        assertThat(ballCount).isEqualTo(2);
    }

}