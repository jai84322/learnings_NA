package org.example;

import org.example.collections.ArrayListExample;
import org.example.genericks.GenerickClassExample;
import org.example.genericks.GenericksMethodExample;
import org.example.inheritence.Animal;
import org.example.inheritence.Dog;
import org.example.rough.DefaultValuesDemo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        GenericksMethodExample example = new GenericksMethodExample();
        System.out.println(example.variableParameterAndVariableReturnType(10));         // Integer
        System.out.println(example.variableParameterAndVariableReturnType("Hello"));    // String
        System.out.println(example.variableParameterAndVariableReturnType(3.14));       // double

        example.variableParameterAndVoidReturnType("testing genericks");
        System.out.println(example.variableParameterAndFixedReturnType(" in string format " + 9 + 9 ));

        GenerickClassExample ex = new GenerickClassExample();
        ex.draw("Circle");
        ex.draw("Rectange");


        Animal animal = new Dog();
        animal.animalMethod();
        ((Dog) animal).dogMethod(); // reference is Animal so won't able to acces dog method until you cast

        Dog dog = new Dog();
        dog.dogMethod();
        dog.animalMethod();


        List<Object> list = new ArrayList<>();
        list.add("one");
        list.add("two");
        list.add("three");

        String item = (String) list.get(0); // casting is required

        System.out.println("-----------starts here-------------");

        ArrayListExample obj = new ArrayListExample();
        obj.add();
        obj.del();
        obj.checkIfExist();
        obj.setElement();
        obj.getElement();
        obj.checkIsEmpty();
        obj.sortAllElements();
        obj.clearList();

        // Create an instance of the class
        DefaultValuesDemo demo = new DefaultValuesDemo();
        // Print the default values
        System.out.println("Default value of byte: " + demo.defaultByte);
        System.out.println("Default value of str: " + demo.str);
        System.out.println("Default value of float: " + demo.defaultFloat);
        System.out.println("Default value of double: " + demo.defaultDouble);
        System.out.println("Default value of object double: " + demo.ClassObjectDouble);
        System.out.println("Default value of char: [" + demo.defaultChar + "]");
        System.out.println("Default value of bool: " + demo.defaultBoolean);

        System.out.println("check static variable before changing: " + DefaultValuesDemo.TRYING_STATIC_VARIABLE);
        DefaultValuesDemo.TRYING_STATIC_VARIABLE = "changged to something";
        System.out.println("check static variable after changing: " + DefaultValuesDemo.TRYING_STATIC_VARIABLE);

        System.out.println(demo.testing());






    }
}