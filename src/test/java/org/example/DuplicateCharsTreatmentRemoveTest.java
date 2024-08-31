package org.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class DuplicateCharsTreatmentRemoveTest {
    private final String input;
    private final String expected;


    public DuplicateCharsTreatmentRemoveTest(String input, String expected) {
        this.input = input;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection testCases() {
        return Arrays.asList(new Object[][] {
                { "abc", "abc" },
                { "aaa", "" },
                { "aabcccbbad", "d" },
                { "", "" },
                { "aabbcc", "aabbcc" },
        });
    }

    @Test
    public void testExecuteRemoveStrategy() {
        DuplicateCharsTreatment treatment = new DuplicateCharsTreatment(new RemoveStrategy());
        String s = treatment.executeStrategy(input);
        assertEquals(expected, s);
    }



}