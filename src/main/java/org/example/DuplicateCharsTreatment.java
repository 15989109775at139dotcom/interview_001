package org.example;

import java.util.Stack;

public class DuplicateCharsTreatment {
    private final static int DUPLICATE_COUNT = 3;
    private final Strategy strategy;

    public DuplicateCharsTreatment(Strategy strategy) {
        this.strategy = strategy;
    }

    public String executeStrategy(String input) {
        if (input == null || input.isEmpty()) {
            return "";
        }
        StringBuilder ans = new StringBuilder(input);
        Stack<Integer> counts = new Stack<>();
        for (int i = 0; i < ans.length(); ++i) {
            if (i == 0 || ans.charAt(i) != ans.charAt(i - 1)) {
                counts.push(1);
            } else {
                int incremented = counts.pop() + 1;
                if (incremented == DUPLICATE_COUNT) {
                    strategy.process(ans, DUPLICATE_COUNT, i);
                    i = i - DUPLICATE_COUNT;
                } else {
                    counts.push(incremented);
                }
            }
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        DuplicateCharsTreatment contextRemoval = new DuplicateCharsTreatment(new RemoveStrategy());
        DuplicateCharsTreatment contextReplace = new DuplicateCharsTreatment(new ReplaceWithCharStrategy());
        System.out.println(contextRemoval.executeStrategy("aabcccbbad"));
        System.out.println(contextReplace.executeStrategy("abcccbad"));
    }
}
