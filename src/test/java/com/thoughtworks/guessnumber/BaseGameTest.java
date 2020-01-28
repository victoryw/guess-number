package com.thoughtworks.guessnumber;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.stub;

public class BaseGameTest {
    protected GuessNumberGenerator generator;
    protected GuessGame game;
    protected int gameLimit;

    @org.junit.Before
    public void setUp() throws Exception {
        generator = mock(GuessNumberGenerator.class);
        stub(generator.generate()).toReturn(new int[]{1,2,3,4});
        game = new GuessGame(generator, new StringToGuessNumberGenerator());
        gameLimit = 6;
        game.init(gameLimit);
    }
}
