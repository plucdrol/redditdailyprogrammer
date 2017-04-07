package com.plucdrol.statemachines;

public class InputMappingFactory {

    private static final int NB_ASCII_CHAR_VALUES = 256;

    private static final int INPUT_OTHER = 1;
    private static final int INPUT_CUTCHAR = 0;
    private static final int INPUT_QUOTECHAR = 2;

    public static int[] createInputMapping(char[] cutChars) {
        int[] inputMapping = new int[NB_ASCII_CHAR_VALUES];

        for (int i = 0; i < 256; i++) {

            inputMapping[i] = INPUT_OTHER;
            for (int charIndex = 0; charIndex < cutChars.length; charIndex++) {

                if (i == cutChars[charIndex]) {
                    inputMapping[i] = INPUT_CUTCHAR;
                }
            }
        }

        return inputMapping;
    }

    public static int[] createInputMapping(char[] cutChars, char[] quoteChars) {
        int[] inputMapping = new int[NB_ASCII_CHAR_VALUES];

        for (int i = 0; i < NB_ASCII_CHAR_VALUES; i++) {

            inputMapping[i] = 1;
            for (int charIndex = 0; charIndex < cutChars.length; charIndex++) {

                if (i == cutChars[charIndex]) {
                    inputMapping[i] = INPUT_CUTCHAR;
                }
            }

            for (int charIndex = 0; charIndex < quoteChars.length; charIndex++) {

                if (i == quoteChars[charIndex]) {
                    inputMapping[i] = INPUT_QUOTECHAR;
                }
            }
        }

        return inputMapping;
    }

}
