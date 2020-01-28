package com.thoughtworks.guessnumber;

public abstract class GuessNumberGenerator {
    public int[] generate() {
        int[] value = createValue();
        validateDuplicatedGuessNumber(value);
        validateGuessNumberLength(value);
        return value;
    }

    protected abstract int[] createValue();

    private void validateGuessNumberLength(int[] generate) {
        if(generate.length != 4) {
            throw new com.thoughtworks.guessnumber.GuessNumberLengthException();
        }
    }

    private void validateDuplicatedGuessNumber(int[] guessNumber) {
        final int noDuplicatedLength = java.util.Arrays.stream(guessNumber).distinct().toArray().length;
        if(noDuplicatedLength < guessNumber.length) {
            throw new com.thoughtworks.guessnumber.DuplicateGuessNumberException();
        }
    }
}
