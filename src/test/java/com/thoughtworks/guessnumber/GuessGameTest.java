package com.thoughtworks.guessnumber;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.stub;
import static org.mockito.Mockito.verify;

public class GuessGameTest {

    private com.thoughtworks.guessnumber.GuessNumberGenerator generator;
    private com.thoughtworks.guessnumber.GuessGame game;
    private int[] guessNumber;
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void setUp() throws Exception {
        generator = mock(GuessNumberGenerator.class);
        game = new GuessGame(generator);
        guessNumber = new int[]{1, 2, 3, 4};
        stub(generator.generate()).toReturn(guessNumber);
    }

    @Test
    public void should_use_the_guess_number_generator_to_init() {
        game.init();
        verify(generator).generate();
    }


    @Test
    public void should_failed_when_the_guess_number_is_duplicated() {
        stub(generator.generate()).toReturn(new int[]{1, 1, 2, 3});
        thrown.expect(DuplicateGuessNumberException.class);
        game.init();
    }

    @Test
    public void should_failed_when_the_guess_number_length_length_than_four() {
        stub(generator.generate()).toReturn(new int[]{1, 4, 2, 3, 5});
        thrown.expect(GuessNumberLengthException.class);
        game.init();
    }

    @Test
    public void should_failed_when_the_guess_number_length_short_than_four() {
        stub(generator.generate()).toReturn(new int[]{1, 4, 2});
        thrown.expect(GuessNumberLengthException.class);
        game.init();
    }
}
