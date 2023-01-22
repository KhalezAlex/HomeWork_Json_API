package org.klozevitz.homework_json_api.logic;

import org.klozevitz.homework_json_api.service.JsonMessage;
import org.springframework.stereotype.Component;

@Component
public interface ISolution {
    JsonMessage.IMessage answer(JsonMessage.InputMessage input);
}
