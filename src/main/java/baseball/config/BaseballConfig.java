package baseball.config;

import baseball.controller.BaseballController;
import baseball.controller.validator.NumberValidator;
import baseball.service.BaseballService;

public class BaseballConfig {

    private static BaseballService baseballService() {
        return new BaseballService();
    }

    private static NumberValidator numberValidator() {
        return new NumberValidator();
    }

    public static BaseballController baseballController() {
        return new BaseballController(baseballService(), numberValidator());
    }

}
