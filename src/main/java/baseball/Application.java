package baseball;

import baseball.view.BaseballView;

public class Application {
    public static void main(String[] args) {
        boolean isFinish = false;
        while (!isFinish) {
            isFinish = BaseballView.baseballStart();
        }
    }
}
