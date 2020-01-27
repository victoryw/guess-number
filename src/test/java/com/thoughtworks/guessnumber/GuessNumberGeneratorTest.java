package com.thoughtworks.guessnumber;

import org.junit.Before;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class GuessNumberGeneratorTest {
    private GuessNumberGenerator generator;

    @org.junit.Rule
    public org.junit.rules.ExpectedException thrown = org.junit.rules.ExpectedException.none();

    @Before
    public void setUp() throws Exception {
        generator = mock(GuessNumberGenerator.class, CALLS_REAL_METHODS);
        doReturn(new int[]{1, 2, 3, 4}).when(generator).createValue();
    }

    @org.junit.Test
    public void should_use_the_guess_number_generator_to_createValue() {
        generator.generate();
        verify(generator).createValue();
    }

    @org.junit.Test
    public void should_return_the_value_by_create_value_method() {
        final int[] expected = {1, 2, 3, 4};
        doReturn(expected).when(generator).createValue();
        final int[] generate = generator.generate();
        assertEquals(expected, generate);
    }

    @org.junit.Test
    public void should_failed_when_the_guess_number_is_duplicated() {
        doReturn(new int[]{1, 1, 3, 4}).when(generator).createValue();
        thrown.expect(DuplicateGuessNumberException.class);
        generator.generate();
    }

    @org.junit.Test
    public void should_failed_when_the_guess_number_length_length_than_four() {
        doReturn(new int[]{1, 2, 3, 4, 5}).when(generator).createValue();
        thrown.expect(GuessNumberLengthException.class);
        generator.generate();
    }

    @org.junit.Test
    public void should_failed_when_the_guess_number_length_short_than_four() {
        doReturn(new int[]{1, 2, 3}).when(generator).createValue();
        thrown.expect(GuessNumberLengthException.class);
        generator.generate();
    }
}
