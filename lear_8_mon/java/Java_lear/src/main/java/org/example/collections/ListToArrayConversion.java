package org.example.collections;

import java.util.List;

public class ListToArrayConversion {

    public void test() {
       List<String> str = List.of("one", "two", "three");
       String[] strTest = str.toArray(String[]::new); // method reference to specify array of -> string to create
    }
}
