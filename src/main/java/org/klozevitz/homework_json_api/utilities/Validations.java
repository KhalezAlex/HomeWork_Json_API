package org.klozevitz.homework_json_api.utilities;

import org.klozevitz.homework_json_api.logic.LinearOperator;
import org.klozevitz.homework_json_api.service.JsonMessage;

public class Validations {
// input level validations

    // operation - arguments amount check
    public static boolean isRequestValid(JsonMessage.InputMessage input) {
        return "sum, diff, mult".contains(input.operation) && (input.lo1 != null && input.lo2 != null);
    }

    // sum-diff dimension check
    public static boolean canBeSummarized(JsonMessage.InputMessage input) {
        return input.lo1.length == input.lo2.length &&
                input.lo1[0].length == input.lo2[0].length;
    }

    // multiply dimension check
    public static boolean canBeMultiplied(JsonMessage.InputMessage input) {
        return (input.lo1.length == input.lo2[0].length &&
                input.lo1[0].length == input.lo2.length) ||
                (input.lo1.length == 1 || input.lo2.length == 1);
    }


//  service layer validations

    // square operator check
    public static boolean isSqr(LinearOperator lo) {
        return lo.getOperator().length == lo.getOperator()[0].length;
    }
}
