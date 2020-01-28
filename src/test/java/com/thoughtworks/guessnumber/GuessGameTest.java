package com.thoughtworks.guessnumber;

import org.junit.Test;

import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.verify;

public class GuessGameTest extends BaseGameTest {

    @Test
    public void should_use_the_guess_number_generator_to_init() {
        reset(generator);
        game.init();
        verify(generator).generate();
    }
}

