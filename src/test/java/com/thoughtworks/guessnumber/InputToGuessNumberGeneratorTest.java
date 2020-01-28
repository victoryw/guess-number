package com.thoughtworks.guessnumber;

import org.junit.Test;

import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.junit.Assert.assertThat;

public class InputToGuessNumberGeneratorTest {

    private StringToGuessNumberGenerator inputTransformer;

    @org.junit.Rule
    public org.junit.rules.ExpectedException thrown = org.junit.rules.ExpectedException.none();

    @org.junit.Before
    public void setUp() throws Exception {
        inputTransformer = new StringToGuessNumberGenerator();
    }

    @Test
    public void should_as_child_of_guess_number_generator() {
        assertThat(inputTransformer, instanceOf(GuessNumberGenerator.class));
    }

    @Test
    public void should_throw_exception_when_the_input_is_not_number() {
        thrown.expect(NumberFormatException.class);
        inputTransformer.init("a 1 2 3");
        inputTransformer.generate();
    }
}
