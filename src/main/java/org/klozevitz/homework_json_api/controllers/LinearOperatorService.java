package org.klozevitz.homework_json_api.controllers;

import org.klozevitz.homework_json_api.logic.ISolution;
import org.klozevitz.homework_json_api.logic.LinearOperator;
import org.klozevitz.homework_json_api.service.JsonMessage;

import static org.klozevitz.homework_json_api.utilities.Validations.*;

public class LinearOperatorService implements ISolution {

    @Override
    public JsonMessage.IMessage answer(JsonMessage.InputMessage input) {
        return chooseOperation(input);
    }

//operation choice method
    private JsonMessage.IMessage chooseOperation(JsonMessage.InputMessage input) {
        if (!isRequestValid(input))
            return new JsonMessage.ErrorMessage("Wrong arguments");
        if (input.operation.equals("sum"))
            return sum(input);
        if (input.operation.equals("diff"))
            return diff(input);
        if (input.operation.equals("mult"))
            return mult(input);
        if (input.operation.equals("det"))
            return det(input);
        return new JsonMessage.ErrorMessage("Wrong operation");
    }

    private JsonMessage.IMessage sum(JsonMessage.InputMessage input) {
        if (!canBeSummarized(input))
            return new JsonMessage.ErrorMessage("Wrong linear operators dimensions");
        LinearOperator lo = new LinearOperator(input.lo1);
        lo.sum(new LinearOperator(input.lo2));
        return new JsonMessage.OutputMessage(lo);
    }

    private JsonMessage.IMessage diff(JsonMessage.InputMessage input) {
        if (!canBeSummarized(input))
            return new JsonMessage.ErrorMessage("Wrong linear operators dimensions");
        LinearOperator lo = new LinearOperator(input.lo1);
        lo.diff(new LinearOperator(input.lo2));
        return new JsonMessage.OutputMessage(lo);
    }

    private JsonMessage.IMessage mult(JsonMessage.InputMessage input) {
        if (!canBeMultiplied(input))
            return new JsonMessage.ErrorMessage("Wrong linear operators dimensions");
        LinearOperator lo = new LinearOperator(input.lo1);
        lo.multiply(new LinearOperator(input.lo2));
        return new JsonMessage.OutputMessage(lo);
    }

    private JsonMessage.IMessage det(JsonMessage.InputMessage input) {
        LinearOperator lo = new LinearOperator(input.lo1);
        if (!isSqr(lo))
            return new JsonMessage.ErrorMessage("Wrong linear operator dimension: cannot " +
                                                    "get a non-square operator determinant");
        return new JsonMessage.OutputMessage(lo.determinant());
    }
}
