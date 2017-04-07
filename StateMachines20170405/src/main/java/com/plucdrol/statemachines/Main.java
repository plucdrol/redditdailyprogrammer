package com.plucdrol.statemachines;

import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");

        App app = new App();

        HashMap start = new HashMap<String, int[]>();
        start.put("cutchar", new int[]{0, 0});
        start.put("other", new int[]{1, 1});

        HashMap inword = new HashMap<String, int[]>();
        inword.put("cutchar", new int[]{0, 3});
        inword.put("other", new int[]{1, 0});
    }
}
