package org.example.collections;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayListExample {
    private ArrayList arr = new ArrayList();
    public void add() {
//        ArrayList arr = new ArrayList(); // will behave like list of Object
        // return boolean
        // pass the argument as Object
        arr.add("str");
        arr.add(2);
        arr.add("hello");
        arr.add("mello");
        arr.add("whello");
        arr.add("testing");
        arr.add("munich");

        for (Object obj : arr) {
            System.out.println("obj: " + obj);
        }
    }

    // returns boolean
    // pass the argument as index or Object
    public void del() {
        arr.remove(1); // will always consider integer as index.
        arr.remove("mello");

//        for(Object obj:arr) {
            System.out.println("obj after deleting: " + arr);
//        }
    }

    public void checkIfExist() {
        // returns boolean
        // parameter is Object
        String str = arr.contains("hello") ? "yes" : "No";
        System.out.println(str);
    }

    public void setElement() {
        arr.set(1,"setelement");

        System.out.println("set Element: "+ arr);
    }

    public void getElement() {
        // parameter is index
        // returns element on that position
        System.out.println(arr.get(3));
    }

    public void checkIsEmpty() {
        System.out.println(arr.isEmpty()); // return boolean
    }

    public void sortAllElements() {
        Collections.sort(arr);
        System.out.println("sorted array: "+arr);
    }

    public void clearList() {
        arr.clear();
        System.out.println("clear: " + arr);
    }
}
