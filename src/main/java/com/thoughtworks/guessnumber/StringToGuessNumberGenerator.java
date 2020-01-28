package com.thoughtworks.guessnumber;

import static java.util.Arrays.stream;
import static org.apache.commons.lang3.StringUtils.split;

public class StringToGuessNumberGenerator extends GuessNumberGenerator {

    private String value;

    public void init(String value) {
        this.value = value;
    }

    @Override
    protected int[] createValue() {
        final String[] split = split(value);
        return stream(split).mapToInt(Integer::parseInt).toArray();
    }
}
