https://chatgpt.com/c/66fa9089-a188-8007-9314-3cd53860989d and  
https://chatgpt.com/c/66fa985a-0fc8-8007-9319-8c4d832c2c49
annotations -> not for now keep it all handy
SQL -> not now
mapper -> not now
refer to eclipse ja_learning project for code in foler  -> C:\Users\Jai.sharma\eclipse-workspace




A) ClassSyntax (same class in eclipse) :- 

q- what is class ? :-  class is a blueprint to create the object
q- why can't we declare class as private or protected ? :- they are supposed to be used by members (fields and methods) of the class
- I have checked decalring a class without any keyword it will not be accesible from other package class.
- also I have checked accessing default class methods from other class from same package its working

Here’s a concise summary of learning:

1) Package Declaration: 

- Always declare the package at the top of the class file (e.g., package test_package;). so that compiler knows that this class belongs to this package.

2) mporting Packages:

- To import all classes: import package_name.*;
- To import a specific class: import package_name.ClassName;

3) Class Access Modifiers:

- Public: Accessible from any package (e.g., public class ABC {}).
- Default: No keyword needed; accessible only within the same package (e.g., class ABC {}).
- Private & Protected: Not applicable for classes.


B) public static void main :- 

1) Access Modifiers:
- public: Accessible from anywhere.
- protected: Accessible within the same package and by subclasses. so protected keywords methods can be accessed by subclass and within the package. 
- private: Accessible only within the class itself. Checked if it's a method with private keyword then you can't access it in other class be it of same package then. 
- default (no modifier): No keyword needed; Accessible only within the same package. Checked.

NOTE: if a method is public or protected it can be accessed by subclass but it's a private or default method it cannot be accessed by subclass.


2) NON access modifiers: 
static and final :-

3) what is subclass : subclass extends superClass OR child extends parents

*general :- in a class there is a class, there is fields, there is methods






