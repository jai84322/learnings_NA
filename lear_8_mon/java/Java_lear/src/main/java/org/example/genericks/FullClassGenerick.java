package org.example.genericks;

public class FullClassGenerick<T> {

    private T item;

    public <T> void printItem(T item) {
        System.out.println(item);
    };

    public void setItem(T data) {
        this.item = data;
    }

    public T getItem() {
        return item;
    }
}
