package com.thoughtworks.guessnumber;

public class GuessGame {
    private final GuessNumberGenerator generator;
    private int[] guessNumber;

    public GuessGame(final GuessNumberGenerator generator) {
        this.generator = generator;
    }

    public void init() {
        guessNumber = this.generator.generate();
    }


}
