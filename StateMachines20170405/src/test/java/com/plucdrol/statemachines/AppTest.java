package com.plucdrol.statemachines;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AppTest {

    private App app;

    @Before
    public void setup() {
        app = new App();
    }

    @Test
    public void givenCutChar_whenTokenize_thenEmptyArrayReturned() {
        int[] inputMapping = InputMappingFactory.createInputMapping(new char[]{','});
        String stringToTokenize = ",";

        String[] result = app.tokenize(StateMachineFactory.createCutCharMachine(), inputMapping, stringToTokenize);

        assertEquals(0, result.length);
    }

    @Test
    public void givenOtherChar_whenTokenize_thenArrayWithOtherChar() {
        int[] inputMapping = InputMappingFactory.createInputMapping(new char[]{','});
        String stringToTokenize = "d,";

        String[] result = app.tokenize(StateMachineFactory.createCutCharMachine(), inputMapping, stringToTokenize);

        assertEquals(1, result.length);
    }

    @Test
    public void cutOnCommaTest1() {
        int[] inputMapping = InputMappingFactory.createInputMapping(new char[]{','});
        String stringToTokenize = ",mark,bill, steve, phil,";

        String[] result = app.tokenize(StateMachineFactory.createCutCharMachine(), inputMapping, stringToTokenize);

        assertEquals(4, result.length);
        assertEquals("mark", result[0]);
        assertEquals("bill", result[1]);
        assertEquals(" steve", result[2]);
        assertEquals(" phil", result[3]);
    }

    @Test
    public void cutOnPunctuationTest2() {
        int[] inputMapping = InputMappingFactory.createInputMapping(new char[]{',',' ','.','!','?',':'});
        String stringToTokenize = "The quick brown fox, jumped over what? The Moon!!!!";

        String[] result = app.tokenize(StateMachineFactory.createCutCharMachine(), inputMapping, stringToTokenize);

        assertEquals(9, result.length);
        assertEquals("The", result[0]);
        assertEquals("quick", result[1]);
        assertEquals("brown", result[2]);
        assertEquals("fox", result[3]);
        assertEquals("jumped", result[4]);
        assertEquals("over", result[5]);
        assertEquals("what", result[6]);
        assertEquals("The", result[7]);
        assertEquals("Moon", result[8]);

    }

    @Test
    public void quotesTestBonus2() {
        int[] inputMapping = InputMappingFactory.createInputMapping(new char[]{','}, new char[]{'"'});
        String stringToTokenize = "mark\"bill, steve\" phil,john,";

        String[] result = app.tokenize(StateMachineFactory.createQuoteCharMachine(), inputMapping, stringToTokenize);

        assertEquals(4, result.length);
        assertEquals("mark", result[0]);
        assertEquals("bill, steve", result[1]);
        assertEquals(" phil", result[2]);
        assertEquals("john", result[3]);
    }

}