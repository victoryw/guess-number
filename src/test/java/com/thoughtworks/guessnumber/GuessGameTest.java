package com.thoughtworks.guessnumber;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.List;

import static java.lang.String.format;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.fail;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.verify;

public class GuessGameTest extends BaseGameTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();


    @Test
    public void should_use_the_guess_number_generator_to_init() {
        reset(generator);
        game.init(6);
        verify(generator).generate();
    }

    @org.junit.Test
    public void should_exceed_the_max_guess_times_limit() {
        final String input = "1 2 3 4";
        game.guess(input);
        game.guess(input);
        game.guess(input);
        game.guess(input);
        game.guess(input);
        game.guess(input);
        try {
            game.guess(input);
            fail("the max is six, the seven guess should be failed, but not");
        } catch (GuessTimesExceedLimitException limitException) {
            assertThat(limitException.getMessage(),
                    is(format("exceed the %d limit", this.gameLimit)));
        }

    }

    public void should_get_the_history_of_the_guess() {
        final String firstResult = game.guess("1 2 3 4");
        final String secondResult = game.guess("1 3 2 4");

        final List<GuessResult> history = game.getHistory();

        assertEquals(history.size(), 2);
        assertEquals(history.get(0).toString(), firstResult);
        assertEquals(history.get(1).toString(), secondResult);
    }


}

