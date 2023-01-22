package org.klozevitz.homework_json_api.controllers;

import org.klozevitz.homework_json_api.logic.ISolution;
import org.klozevitz.homework_json_api.service.JsonMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/linearOperators")
public class Controller {
    @Autowired
    private ISolution solution;

    @GetMapping("/ping")
    public JsonMessage.IMessage ping() {
        return new JsonMessage.OutputMessage("pong");
    }

    @GetMapping("/status")
    public JsonMessage.IMessage status() {
        return new JsonMessage.OutputMessage("Server is active");
    }

    @PostMapping("/solve")
    public JsonMessage.IMessage solve(@RequestBody JsonMessage.InputMessage input) {
        return solution.answer(input);
    }
}
