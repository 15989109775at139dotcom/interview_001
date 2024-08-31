package org.example;

public class ReplaceWithCharStrategy implements Strategy {

    @Override
    public void process(StringBuilder sb, int duplicateCount, int lastIndex) {
        char c = (char) (sb.charAt(lastIndex) - 1);
        String replacement = c >= 'a' ? String.valueOf(c) : "";
        sb.replace(lastIndex - duplicateCount + 1, lastIndex + 1, replacement);
    }
}
