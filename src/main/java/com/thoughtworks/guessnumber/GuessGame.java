package com.thoughtworks.guessnumber;

import java.util.List;

public class GuessGame {
    private final GuessNumberGenerator generator;
    private List<GuessResult> guessHistory;
    private int[] guessNumber;
    private final StringToGuessNumberGenerator inputToGuessNumberGenerator;
    private int guessTimesLimit;

    public GuessGame(final GuessNumberGenerator generator,
                     final StringToGuessNumberGenerator inputToGuessNumberGenerator) {
        this.inputToGuessNumberGenerator = inputToGuessNumberGenerator;
        this.generator = generator;
    }

    public void init(int guessTimesLimit) {
        this.guessTimesLimit = guessTimesLimit;
        guessNumber = this.generator.generate();
        this.guessHistory = new java.util.ArrayList<>(guessTimesLimit);
    }


    public String guess(String input) {
        validateTheGuessTimesLimit();
        inputToGuessNumberGenerator.init(input);
        int[] inputValue = inputToGuessNumberGenerator.generate();
        GuessResult guessResult = new GuessResult(guessNumber, inputValue);
        this.guessHistory.add(guessResult);
        return guessResult.toString();
    }

    private void validateTheGuessTimesLimit() {
        if(this.guessHistory.size() == this.guessTimesLimit) {
            throw new GuessTimesExceedLimitException(this.guessTimesLimit);
        }
    }


    public List<GuessResult> getHistory() {
        return this.guessHistory;
    }
}


