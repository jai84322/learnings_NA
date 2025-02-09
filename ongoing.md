String fieldName
if(Objects.isNull(fieldData)|| fieldData.isBlank())
{
    return "";
}


Q- Objects.isNull(fieldData) -> to check whether the variable is null 

Q- fieldData.isBlank() -> 
- available in Java 11 and later.
ex:- String str1 = "";
String str2 = "   ";
String str3 = "abc";

System.out.println(str1.isBlank()); // true
System.out.println(str2.isBlank()); // true
System.out.println(str3.isBlank()); // false

Q- fieldData.isEmpty() -> available in Java starting from Java 6.
String str1 = "";
String str2 = "   ";
String str3 = "abc";

System.out.println(str1.isEmpty()); // true
System.out.println(str2.isEmpty()); // false
System.out.println(str3.isEmpty()); // false


Q- Optional.ofNullable() - works with DB calls where It might return null so to handle senerios it is used.
ex:- 
String name = null;

// Using Optional.ofNullable to handle a possible null value
String result = Optional.ofNullable(name).orElse("Default Name");

System.out.println(result);  // Output: Default Name


Q- string comparisions

String str1 = "hello";
String str2 = "hello";
String str3 = new String("hello");

System.out.println(str1 == str2);   // true (both point to the same string literal in the string pool)
System.out.println(str1 == str3);   // false (str1 is in the string pool, str3 is a new object in the heap)
System.out.println(str1.equals(str3));  // true (checks content equality using equals() method)

String str1 = "hello";
String str2 = "hello";
String str3 = new String("hello");

System.out.println(Objects.equals(str1, str2));  // true (content is equal)
System.out.println(Objects.equals(str1, str3));  // true (content is equal)

Q- if (Objects.nonNull(str)) -> it checks if the object is not null (means some value is present) then returns true

example where used -> 
List<String> strings = Arrays.asList("a", null, "b", "c");
List<String> nonNullStrings = strings.stream()
                                     .filter(Objects.nonNull)
                                     .collect(Collectors.toList());
System.out.println(nonNullStrings); // Output: [a, b, c]


Q- what is parent object class -> every class in java is implicity (including user defind) inheriting parent class 
- this class has total 11 methods but mainly are toString, hashCode(), equals()
- I just learned that there are 2 types of variables instance variables and static variables :- instance are instance specific means object specific means each object has it's own variables. But static variables are shared among whole class. 
- I learned about toString() parent method default implementation which is getting class name and concating hash code number in hex format. so when I createed as User class object and set it's name age and country and tried printing I got this output -> ToStringAndHashCode@6f2b958e. Then later I overrode the toString method in my User class where I wrote a custom string concating variables like name, age and country then it printed the output as per custom implementation. so it does nothing but will print the string representation of the object,
- equals method of parent by default implementation do "value" comparision of PRIMITIVE types. But it will do reference comparision for non primitive types. and same happens with "==" in java. To solve this problem you can override equals method to compare non primitive types by writing your custom implementation. 
- One awesome stuff I got to know is that there is equals method of String class which check value similarly for Integer class and the equals method of parent object class is checking reference. also string and integer both are overriding this parent only. Then comes Objects.equals(str1, str2) which is utility method NOT THE PARENT ONE and it checks content/value.
- objects.equals automatically while comparing object checks internally if there is any overriden equals method written in the class of object then it will use that other wise it will go for the default parent object class equals method which does reference/memory comparision.
- and also to tell you that string and integer classes have their equals method already overridden and prewritten in their respective class by java developers 
- below is the example of parent class equals method 
        MyClass obj1 = new MyClass(10);
        MyClass obj2 = new MyClass(10);
        MyClass obj3 = obj1;

        // Reference equality check
        System.out.println(obj1.equals(obj2)); // Output: false (different objects in memory)
        System.out.println(obj1.equals(obj3)); 

- this utility method is also internally using my overridden equals method (written in custom class of object for ex: User class) only to compare two objects.
- All of these methods (equals in String, Integer, and Objects.equals) override the equals method from the Object class.

Q- instanse variable/methods and static variable/methods is a way to think of seggeregating what common and same in class and what is instanse specific.

Q- try catch is to handle to unexpected errors or you can use it for displaying a message to the user, retrying an operation etc. also if the error is not handled then it will forcely abort the application causing execution failure for further code lines, if not handled. 


saturday 17 august

- learning about object mapper class 

Q- how to convert a var variable me store object of any class in JsonNode class object
ans- there are 2 ways to do that 
a) Using valueToTree Method:
- Usage: Used when you have a Java object (like a list, map, or custom class instance) and you want to convert it to a JsonNode.
- JsonNode jsonNode = objectMapper.valueToTree(myList);

b) Using convertValue Method:
JsonNode jsonNode = objectMapper.convertValue(paymentTransactionRequest, JsonNode.class);

Q- how to make a JsonNode object into json string ? 
ans- String str = mapper.writeValueAsString(jsonNode);

Q- how to convert json string to JsonNode
- Usage: Used when you have a JSON-formatted string or input stream and you want to parse it into a JsonNode.
- JsonNode jsonNode = objectMapper.readTree(jsonString);


wednesday 21 august : regarding exception handling 

why handling ? so that we can identify what is the error by handling it 

- array out of bounds -> trying to access index that is not 
- String str = null; => str.length(); // Throws NullPointerException

- trying to call lengthI() method on null string is 1st time exception is thrown
- then we catch it and then handling means logging it or throwing it again (rethrow) as shown below

try {
    String str = null;
    str.length(); // Throws NullPointerException (1st throw)
} catch (NullPointerException e) {
    System.out.println("Caught in method1: " + e.getMessage());
    throw e; // Rethrowing the same exception (2nd throw / rethrow)
}

- if you are throwing and not handling anywhere in any method then it will cause application to terminate
- handling means -> sout or log.info or log.error() BUT NOT THROW as that will cause termination 

custom exception : 

class CustomException extends Exception {
    public CustomException(String message) {
        super(message);
    }
}

try {
    throw new CustomException("This is a custom exception.");
} catch (CustomException e) {
    System.out.println(e.getMessage());
}
// Code continues here

- it is helpfull when you want to response specific error message -> like one failure is usernot found and other is data base connection failed 

Real-World Scenario: Banking Application
Scenario: A banking application needs to handle various errors related to account transactions.

Example Without Custom Exceptions:

If you use generic exceptions like RuntimeException or IOException for all types of errors (e.g., insufficient funds, account not found), it becomes hard to determine exactly what went wrong when handling the exception.
Example With Custom Exceptions:

Instead, you create custom exceptions to represent specific error conditions, such as InsufficientFundsException or AccountNotFoundException.


Real-World Scenario: Online E-commerce Platform
Scenario: An online e-commerce platform handles various operations related to user orders, including processing payments, updating inventory, and managing customer accounts.

Example: Handling Payment Failures
Situation:

When a user attempts to make a payment, the system needs to handle different types of errors that can occur, such as invalid payment details, insufficient funds, or network issues.
Using Custom Exceptions:

Custom Exceptions: you need to create class and extend accordingly 
InvalidPaymentDetailsException
InsufficientFundsException
PaymentGatewayException


q- checked exception are compile time errors and unchecked expection are runtime errors 
ans- Yes, checked exceptions are compile-time errors, requiring explicit handling ex- file not found and ioexception. Unchecked exceptions are runtime errors and do not need to be explicitly handled.

- rather then throwing all error under runtime we can create the specific custom class and use it specific 

- refer this whole chat: https://chatgpt.com/c/21d4762c-6e6d-4b70-aaa6-4a58cc7b7f27

date -> 6 sept 2024

- I learned about jmeter and there are 3 main options in it 
a) threads/users: lets say I am hitting www.google.com and I plan to send 20 users to the website so that will be 20 threads/users  
b) ramp up period: now I give ramp up period as 10 seconds so that will be like within 10 seconds all 20 users will be active on web page i.e. perseconds 2 users will hit
c) loop count: 1 means each user will hit 1 time the web page if 2 means each users will hit 2 times 


- also I learned about stack and heap 

=> String str = "hello";
=> here str is reference variable ---> this is stored in stack and holds the reference (address) to the heap location where "Hello" is stored.
=> and value is "hello" ---> this is stored in heap 

=> Instance Variables: The fields of objects are stored in heap memory.
ex: public class Example {
    int value;  // Instance variable

    public static void main(String[] args) {
        Example obj = new Example();  // Object is stored in heap memory
        obj.value = 10;  // Instance variable of the object
    }
}

=> method calls are stored in stack memory 

- lets try to figure out what all is there in class 

class itself 
fields 
methods- parameters and their returns 
dependency injection of other class -> constructor injection, field injection, setter injection 
extends or implements
static/non static and instance and local variables 
getters and setters method


ENUMS :----------start
- prevent invalid values 
- improve code readability and makes it understandable to new ones 

EX- 
@AllArgsConstructor
@Getter
public enum LoanSystemFileType {

    CSV(1), XLSX(2), JSON(3);

    private final Integer id;

}

- this integer is not necessary it's additional for referencing in Database 
- LoanSystemFileType.CSV.name() // CSV and LoanSystemFileType.CSV.getId() // 1 so these are the default methods that comes with java enum 


TO GENERATE RANDOM STRING:
- to generate a random string like this -> 123e4567-e89b-12d3-a456-426614174000

    public static String getString() {
        return UUID.randomUUID().toString();
    }

2 METHODS: ----------start ()
a) - int lastIndexOf = fileName.lastIndexOf(".");
- The method fileName.lastIndexOf(".") is used to find the position of the last occurrence of the period (.) in a string
- fileName: A string that represents the name of a file.
- lastIndexOf("."): Returns the index (position) of the last dot in the string. If the dot is not found, it returns -1.
- String fileName = "document.pdf";
int index = fileName.lastIndexOf("."); // index will be 8

b) 
- Set<String> mandatoryHeadersInFile
Set<String> mandatoryHeadersNeeded
mandatoryHeadersNeeded.removeAll(mandatoryHeadersInFile);  
mandatoryHeadersNeeded.isEmpty();

Short Example:
Imagine you have two lists of headers:

mandatoryHeadersNeeded: ["A", "B", "C", "D"] (Headers you need)
mandatoryHeadersInFile: ["B", "D"] (Headers already in the file)
When you call mandatoryHeadersNeeded.removeAll(mandatoryHeadersInFile), it removes the headers "B" and "D" from mandatoryHeadersNeeded, leaving you with:

After removing: ["A", "C"] (Headers that are still missing)

The removeAll() method will return true even if just one element is removed. It doesn't require all elements to be removed; as long as it successfully removes at least one matching element, it returns true.

If no elements are removed (i.e., there were no matches), then it returns false.

true: If the set is empty (i.e., it contains no elements).
false: If the set has one or more elements.

The method mandatoryHeadersNeeded.isEmpty() checks whether the mandatoryHeadersNeeded set is empty or not.

If mandatoryHeadersNeeded contains ["A", "B"], then isEmpty() will return false because the set is not empty.

If mandatoryHeadersNeeded is [] (empty), then isEmpty() will return true.

----------------- end

date 27 oct -> learning about custom exception and super shit ----------start

q- why are we directly not using runtimeException and extending functionException to runtime or CustomerAccountNotFoundException extends to functionException which further extends to runtime... why ?

ans- 
1 use is -> you create centralized function exception with super and log.error(message) and you are extending it to lets say fldgException where in message you are passing as super and log.error("error in fldg exception: " + message) -> so it's logging at 2 levels one in loanfldg and another in function class

2nd use is -> customized error codes. like you can create a class 

    public FunctionException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public class CustomerAccountNotFoundException extends FunctionException {
    public CustomerAccountNotFoundException(String accountId) {
        super("Account not found: " + accountId, "ERR_ACCOUNT_NOT_FOUND");
    }
}

ERR_ACCOUNT_NOT_FOUND is the customized error code here 

3rd use is -> reusability of code or centralized class like functionexception 

4th use is (very imp) -> clarity in understanding as if error is thrown by usernotfound class then it will be thrown for this class if it came in account not found then it will be thrown from that class so you can identify specifically that error is of usernotfound or accountnotfound or whatever. if you use runtime then everytime in the console you wil have an error from runtime only nothing specific.



