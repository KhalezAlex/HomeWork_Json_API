package org.klozevitz.homework_json_api.exceptions;

import java.io.IOException;

public class WrongArgsException extends IOException {
    public WrongArgsException(String str) {
        super(str);
    }
}
