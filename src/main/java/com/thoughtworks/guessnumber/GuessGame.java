package com.thoughtworks.guessnumber;

public class GuessGame {
    private final GuessNumberGenerator generator;
    private int[] guessNumber;
    private final StringToGuessNumberGenerator inputToGuessNumberGenerator;

    public GuessGame(final GuessNumberGenerator generator,
                     final StringToGuessNumberGenerator inputToGuessNumberGenerator) {
        this.inputToGuessNumberGenerator = inputToGuessNumberGenerator;
        this.generator = generator;
    }

    public void init() {
        guessNumber = this.generator.generate();
    }


    public String guess(String input) {
        inputToGuessNumberGenerator.init(input);
        int[] inputValue = inputToGuessNumberGenerator.generate();
        GuessResult guessResult = new GuessResult(guessNumber, inputValue);
        return guessResult.toString();
    }


}


