https://chatgpt.com/c/6759fbdb-1acc-8007-9c5a-e7d5868d3149 -> check bottom

What Are Java Generics?
Generics in Java allow you to write classes, interfaces, and methods that work with any data type. They enable type safety and eliminate the need for casting, making code more flexible, reusable, and less error-prone.

Theoretical Use Cases:
Collections: Use generics to create type-safe collections (e.g., List<T>, Map<K, V>).
Algorithms: Write algorithms that can work with different data types (e.g., sorting or searching).
Type Safety: Prevent type mismatches at compile time instead of runtime (e.g., ensuring you don’t insert a String into a List<Integer>).
Simple Code Example:
java
Copy code
// Generic Method
public class GenericExample {
    
    // Generic method to print any type
    public <T> void print(T data) {
        System.out.println(data);
    }

    public static void main(String[] args) {
        GenericExample example = new GenericExample();

        // Using print method for different types
        example.print(10);         // Integer
        example.print("Hello");    // String
        example.print(3.14);       // Double
    }
}
Key Points:
<T>: Represents a type parameter. You can use any name like T, E, or K for type parameters.
Type Safety: The compiler ensures that you only insert valid types into the generic class or method.
This makes the code reusable and type-safe while maintaining flexibility for different data types.


it helps in type safety 

what is difference in List<T> and List<Object> 
may be still in List<Object> i will require casting 
but in List<T> i won't right 

