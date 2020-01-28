package com.thoughtworks.guessnumber;

import static java.lang.String.format;

public class GuessTimesExceedLimitException extends RuntimeException {
    public GuessTimesExceedLimitException(int guessTimesLimit) {
        super(format("exceed the %d limit", guessTimesLimit));
    }
}
