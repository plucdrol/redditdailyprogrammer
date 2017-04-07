package com.plucdrol.statemachines;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class App {

    private static final int NEXT_STATE = 0;
    private static final int ACTION = 1;

    public App() {

    }

    public String[] tokenize(int[][][] stateTransitionTable, int[] inputMapping, String stringToTokenize) {

        int state = 0;

        List<String> tokenizedString = new ArrayList<>();

        String currentWord = null;

        for (char c: stringToTokenize.toCharArray()) {
            int input = inputMapping[c];
            int action = stateTransitionTable[state][input][ACTION];

            switch (action) {
                case 0:
                    if (input == 1 || state == 2) currentWord += c;
                    break;
                case 1:
                    currentWord = new String(String.valueOf(c));
                    break;
                case 2:
                    tokenizedString.add(currentWord);
                    currentWord = new String();
                    break;
                case 3:
                    tokenizedString.add(currentWord);
                    break;
                default:
                    throw new NotImplementedException();
            }

            state = stateTransitionTable[state][input][NEXT_STATE];
        }

        return tokenizedString.toArray(new String[tokenizedString.size()]);
    }
}
