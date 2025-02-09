Basics of Generics:- 

Generic Methods: method level par hi you need to define generick type (what parameter data type that will be defined later)

public <T> void print(T data) {
System.out.println(data);
}


Generic Classes:class level par define generick type and all methods/fields in it will inherit the saem

public class Box<T> {
private T item;
public void setItem(T item) { this.item = item; }
public T getItem() { return item; }
}


Generic Interfaces: subclass me overridden methods will inherit the same generick type no need to define there

public interface Container<T> {
void add(T item);
T get();
}

-> <T> is a place holder for a type that will be specified later for the parameter

Next:- Bounded Types in Generics

1. extends (Upper Bound)
   class Animal { }
   class Dog extends Animal { }

public class Box<T extends Animal> {  // T can be Animal or any subclass of Animal
private T item;
public T getItem() { return item; }
}

// Usage
Box<Dog> dogBox = new Box<>();   // Valid because Dog extends Animal
Box<Animal> animalBox = new Box<>();  // Valid
// Box<String> stringBox = new Box<>(); // Invalid, String doesn't extend Animal


2. super (Lower Bound)
public class Box<T> {
   public void addItem(T item) { }
   }

public class Animal { }
public class Dog extends Animal { }

public class Main {
public static void main(String[] args) {
Box<? super Dog> box = new Box<>();  // Can accept Dog or any superclass of Dog
box.addItem(new Dog());  // Valid, because Dog is a subclass of Animal
// box.addItem(new Animal()); // Invalid, Animal is not a superclass of Dog
}
}

Summary of Wildcards:
?: Any type.
? extends T: Any subclass of T.
? super T: Any superclass of T.

? is used specifically with collections or generic types, while T is for generic methods.

Next:- Type Erasure
Type Erasure is how Java handles generics at runtime. Even though generics are used at compile time, Java removes all the generic type information when the code is compiled. This is known as "type erasure."

Key Points:
Generics Are Compile-Time Only:
Java uses generics to enforce type safety at compile time, but it removes the actual type information at runtime. At runtime, all generic types are replaced by their raw types (e.g., T becomes Object).

Why It's Done:
This allows Java to maintain backward compatibility with older versions of Java that didn't have generics.

public class Box<T> {
private T item;

    public void setItem(T item) {
        this.item = item;
    }

    public T getItem() {
        return item;
    }
}

public class Main {
public static void main(String[] args) {
Box<String> box = new Box<>();
box.setItem("Hello");

        // At compile time: Box<String>
        // At runtime: Box<Object> because of type erasure
    }
}

What Happens at Runtime:
At compile time, Box<String> ensures that only a String can be passed into the Box object.
However, at runtime, the type information (String) is erased, and it becomes a Box<Object>.
The JVM doesn't know that the box was originally intended for String; it just knows it's a Box that holds Object.

Type erasure removes the specific generic type information at runtime, leaving only the raw type. This ensures compatibility with older Java code that didn’t use generics.

you can't create generick array and List<String> is a generick collection so it's possible 
