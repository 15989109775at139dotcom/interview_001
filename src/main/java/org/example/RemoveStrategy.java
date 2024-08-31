package org.example;

public class RemoveStrategy implements Strategy {

    @Override
    public void process(StringBuilder sb, int count, int lastIndex) {
        sb.delete(lastIndex - count + 1, lastIndex + 1);
    }
}
