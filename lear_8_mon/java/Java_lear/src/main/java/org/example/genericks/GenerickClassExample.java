package org.example.genericks;

public class GenerickClassExample<T> implements Shape<T> {

    @Override
    public void draw(T data) {
        System.out.println("draw: " + data);
    }
}
