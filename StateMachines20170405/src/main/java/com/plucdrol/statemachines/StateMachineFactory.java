package com.plucdrol.statemachines;

/**
 * Created by Pierre-Luc on 2017-04-07.
 */
public class StateMachineFactory {

    private static final int nbStatesCut = 2;
    private static final int nbStatesQuote = 3;

    private static final int nbInputsCut = 2;
    private static final int nbInputsQuote = 3;

    private static final int nbParameters = 2;

    private static final int sStart = 0;
    private static final int sInWord = 1;
    private static final int sInQuote = 2;

    private static final int cutChar = 0;
    private static final int otherChar = 1;
    private static final int quoteChar = 2;

    private static final int actNothing = 0;
    private static final int actNewWord = 1;
    private static final int actEndWordNewWord = 2;
    private static final int actEndWord = 3;

    public static int[][][] createCutCharMachine() {

        int[][][] machine = new int[nbStatesCut][nbInputsCut][nbParameters];
        machine[sStart][cutChar] = new int[]{sStart, actNothing};
        machine[sStart][otherChar] = new int[]{sInWord, actNewWord};
        machine[sInWord][cutChar] = new int[]{sStart, actEndWord};
        machine[sInWord][otherChar] = new int[]{sInWord, actNothing};

        return machine;
    }

    public static int[][][] createQuoteCharMachine() {

        int[][][] machine = new int[nbStatesQuote][nbInputsQuote][nbParameters];

        machine[sStart][cutChar] = new int[]{sStart, actNothing};
        machine[sStart][otherChar] = new int[]{sInWord, actNewWord};
        machine[sStart][quoteChar] = new int[]{sInQuote, actNewWord};

        machine[sInWord][cutChar] = new int[]{sStart, actEndWord};
        machine[sInWord][otherChar] = new int[]{sInWord, actNothing};
        machine[sInWord][quoteChar] = new int[]{sInQuote, actEndWordNewWord};

        machine[sInQuote][cutChar] = new int[]{sInQuote, actNothing};
        machine[sInQuote][otherChar] = new int[]{sInQuote, actNothing};
        machine[sInQuote][quoteChar] = new int[]{sStart, actEndWord};

        return machine;
    }
}
