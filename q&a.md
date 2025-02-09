Q1- what are all the programming paradigm supported by java ? 
A1- 
1. Object-Oriented Programming (OOP): Java emphasizes classes and objects, with support for inheritance, encapsulation, polymorphism, and abstraction.

class Dog {
    String name;
    void bark() {
        System.out.println(name + " says woof!");
    }
}

public class OOPExample {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.name = "Buddy";
        dog.bark();
    }
}

each instance has access to fields and methods and you can controll access using modifiers

2. Imperative Programming: Java allows for programming
with explicit statements and commands to change program
state, using constructs like loops and conditionals.

public class ImperativeExample {
    public static void main(String[] args) {
        int sum = 0;
        for (int i = 1; i <= 5; i++) {
            sum += i;
        }
        System.out.println("Sum: " + sum);
    }
}
change the program state ? 
"Changing the program state" refers to modifying the values of variables or data during program execution. In your example, the sum variable is updated in each iteration of the loop, changing the program's state as it accumulates the sum.

3. Procedural Programming: Java supports procedural code
organization, where functions or methods operate on data
and control program flow.

public class ProceduralExample {
    public static void main(String[] args) {
        int result = add(5, 3);
        System.out.println("Result: " + result);
    }

    static int add(int a, int b) {
        return a + b;
    }
}

based on procedures or functions that operate on data.
In procedural programming, the logic is organized into procedures (or functions) that perform actions on data. In your example, the add() method is a procedure that operates on the input data (a and b) and returns a result. The focus is on calling these functions to process data, rather than organizing everything into objects.

4. Concurrent Programming: Java provides built-in support
for multithreading and concurrency, using classes from the
`java.util.concurrent` package.

class MyThread extends Thread {
    public void run() {
        System.out.println("Thread is running");
    }
}

public class ConcurrentExample {
    public static void main(String[] args) {
        MyThread thread = new MyThread();
        thread.start();  // Starts the thread
    }
}

In concurrent programming, multiple tasks run simultaneously or in parallel, often in multi-threaded environments.

5. Functional Programming: Introduced in Java 8, Java supports functional programming with lambda expressions, the Stream API, and functional interfaces.

Functional programming treats computation as the evaluation of mathematical functions and avoids changing state or mutable data.

import java.util.function.IntPredicate;

public class FunctionalExample {
    public static void main(String[] args) {
        IntPredicate isEven = x -> x % 2 == 0;
        System.out.println(isEven.test(4));  // true
    }
}


6. Generic Programming: Java enables type-safe operations
on objects through generics, allowing classes and methods
to operate on specified types.

class Box<T> {
    private T value;
    public void setValue(T value) {
        this.value = value;
    }
    public T getValue() {
        return value;
    }
}

public class GenericExample {
    public static void main(String[] args) {
        Box<Integer> intBox = new Box<>();
        intBox.setValue(42);
        System.out.println(intBox.getValue());
    }
}


Q2- why is composition preferred over inheritence ? 
A2- reusability, flexibility, loose coupling, easier runtime class behavious change, makes code maintainable

Q3- is java pure object oriented 
A3- no static methods do not require objects and primitive types also not objects in java  

Q4- what is method hiding in java ?  
A4- 

class Parent {
    // Static method in parent class
    static void display() {
        System.out.println("Parent class static display method");
    }
}

class Child extends Parent {
    // Static method in subclass hides the parent method
    static void display() {
        System.out.println("Child class static display method");
    }
}

public class MethodHidingExample {
    public static void main(String[] args) {
        Parent parent = new Parent();
        Parent childAsParent = new Child(); // Upcasting 
        // you see the object type is child but variable reference type is Parent only
        // so compile time it will check the reference type only 

        parent.display();          // Calls Parent class method
        childAsParent.display();   // Calls Parent class method, not Child class
    }
}




Q5- can you override static emthod in java ? 
A5- No

