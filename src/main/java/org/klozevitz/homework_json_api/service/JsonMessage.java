package org.klozevitz.homework_json_api.service;

import java.time.LocalDateTime;
import java.util.Arrays;

public class JsonMessage {
    public interface IMessage {}

    public static class Message implements IMessage {
        public String message;
        public LocalDateTime time;

        public Message(String message) {
            this.message = message;
            this.time = LocalDateTime.now();
        }



        @Override
        public String toString() {
            return "{message=" + message + ", time=" + time + '}';
        }
    }

    public static class InputMessage implements IMessage {
        public String operation;
        public double[][] lo1;
        public double[][] lo2;

        public InputMessage() {}

        public InputMessage(String operation, double[][] lo1, double[][] lo2) {
            this.operation = operation;
            this.lo1 = lo1;
            this.lo2 = lo2;
        }

        public InputMessage(String operation, double[][] lo) {
            this.operation = operation;
            this.lo1 = lo;
            this.lo2 = null;
        }

        @Override
        public String toString() {
            return "{operation='" + operation + '\'' +
                    ", lo1=" + Arrays.deepToString(lo1) +
                    ", lo2=" + Arrays.deepToString(lo2) + '}';
        }
    }

    public static class OutputMessage implements IMessage {
        public Object output;

        public OutputMessage(Object output) {
            this.output = output;
        }
    }

    public static class ErrorMessage extends Message {
        public ErrorMessage(String error) {
            super(error);
        }
    }

}
