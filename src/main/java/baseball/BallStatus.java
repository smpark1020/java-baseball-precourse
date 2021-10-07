package baseball;

public enum BallStatus {
    BALL, STRIKE, NOTHING;

    public boolean isNotThing() {
        return this != NOTHING;
    }

    public boolean isStrike() {
        return this == STRIKE;
    }

    public boolean isBall() {
        return this == BALL;
    }
}
