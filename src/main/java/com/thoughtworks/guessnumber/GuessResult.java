package com.thoughtworks.guessnumber;

import static java.util.Arrays.stream;

public class GuessResult {
    private static final String ALL_CORRECT = "A";
    private static final String VALUE_CORRECT = "B";
    private static final String IN_CORRECT = "N";

    private final String[] answerPosition;

    public GuessResult(int[] guessNumber, int[] inputValue) {
        this.answerPosition = new String[inputValue.length];

        for (int position = 0; position < guessNumber.length; position++) {
            int actual = inputValue[position];
            int expect = guessNumber[position];
            if (actual == expect) {
                answerPosition[position] = ALL_CORRECT;
                continue;
            }

            final boolean existsValueCorrect = stream(guessNumber).anyMatch(expectNumber -> expectNumber == actual);
            if (existsValueCorrect) {
                answerPosition[position] = VALUE_CORRECT;
                continue;
            }

            answerPosition[position] = IN_CORRECT;
        }
    }

    @Override
    public String toString() {
        final long allCorrectCount = stream(answerPosition).filter(value -> value.equals(ALL_CORRECT)).count();
        final long valueCorrectCount = stream(answerPosition).filter(value -> value.equals(VALUE_CORRECT)).count();
        return String.format("%sA%sB", allCorrectCount, valueCorrectCount);
    }
}
