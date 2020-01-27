package com.thoughtworks.guessnumber;

public class GuessGame {
    private final GuessNumberGenerator generator;
    private int[] guessNumber;

    public GuessGame(final GuessNumberGenerator generator) {
        this.generator = generator;
    }

    public void init() {
        final int[] generate = this.generator.generate();
        validateDuplicatedGuessNumber(generate);
        validateGuessNumberLength(generate);
        guessNumber = generate;
    }

    private void validateGuessNumberLength(int[] generate) {
        if(generate.length != 4) {
            throw new GuessNumberLengthException();
        }
    }

    private void validateDuplicatedGuessNumber(int[] guessNumber) {
        final int noDuplicatedLength = java.util.Arrays.stream(guessNumber).distinct().toArray().length;
        if(noDuplicatedLength < guessNumber.length) {
            throw new DuplicateGuessNumberException();
        }
    }
}
