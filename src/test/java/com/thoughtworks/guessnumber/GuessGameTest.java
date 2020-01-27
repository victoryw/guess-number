package com.thoughtworks.guessnumber;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class GuessGameTest {

    private GuessNumberGenerator generator;
    private GuessGame game;

    @Before
    public void setUp() throws Exception {
        generator = mock(GuessNumberGenerator.class);
        game = new GuessGame(generator);
    }

    @Test
    public void should_use_the_guess_number_generator_to_init() {
        game.init();
        verify(generator).generate();
    }
}
