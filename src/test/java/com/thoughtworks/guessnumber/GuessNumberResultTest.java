package com.thoughtworks.guessnumber;

import static junit.framework.Assert.assertEquals;

@org.junit.runner.RunWith(org.junit.runners.Parameterized.class)
public class GuessNumberResultTest extends BaseGameTest {
    @org.junit.runners.Parameterized.Parameters()
    public static Iterable<Object[]> data() {
        return java.util.Arrays.asList(new Object[][]{
                {"1 2 3 4", "4A0B"},
                {"1 3 2 4", "2A2B"},
                {"1 5 3 4", "3A0B"},
                {"5 6 7 8", "0A0B"},
                {"5 6 2 8", "0A1B"},
                {"5 2 7 8", "1A0B"},
        });
    }

    private int[] guessNumber = new int[]{1, 2, 3, 4};

    private String fInput;

    private String fExpected;

    public GuessNumberResultTest(String input, String expected) {
        this.fInput = input;
        this.fExpected = expected;
    }

    @org.junit.Test
    public void test() {
        assertEquals(fExpected, this.game.guess(fInput));
    }
}
