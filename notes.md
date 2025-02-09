q1- how to convert an static array to list ? 
a- 
String array[] = {1,2,3,4,5};
List<Integer> list = Arrays.asList(array);

q2- how to convert a list to static array ? 
a- 
List<String> list = Arrays.asList("a", "b", "c",);
List<String> list = List.of("a", "b", "c"); // another way of creating fixed/finite list 
String array[] = list.toArray(String[]::new);

ifPresent + lambda
orElseThrow
findById -> object or null (which you can handle using custom exception)
findAll -> array of list or empty array
customException 
existsById -> return boolean 
deleteById
deleteAll
map with update
map and filter with stream
@Transactional
save and saveAll
Integer.valueOf -> convert string to integer 
convert list to array and array to list -> stick to one syntax for now 
creating db, schema, and tables (data type -> varchar, text, int, unique, not null, BOOLEAN DEFAULT FALSE NOT NULL)


next will do collections and jackson methods then sql and it's procedures joins and operators cte's  and cross calls in java 




primitive and non primitives difference in java - awesome article below
https://medium.com/@AlexanderObregon/java-data-types-primitive-vs-non-primitive-417925cee746
reference based (non primitive) and value based (primitive)

streams practical 

and methods 

string -> 
arrays -> 
jackson library -> 
java collections methods 
third party api calls syntax 
exceptions name and their points of thrown 
also you make index type of thing in you revision file 


list down the name of method -> add-boolean, contains-boolean, get-return element on index, isEmpty(), sort, set, remove
method input and 
method return type
take revision or notes and revise everyday
do practical 


add
contains
set
isEmpty
sort
get
remove 
clear

Arrays.asList() -> to create a list
toArray -> to convert a list to array
Arrays.copyOf(arr, 90) -> pass the array you want to copy and pass the size of new array 


array list default size is 10 (0th to 9th index) and hashmap is 16

there is utility class Objects.equals()
there is string class equals
there is Integers class equals 
there is parents class equals
there is == comparator 

compare 2 objects of user 
compare 2 string will always use overridden
== and equals of parents will always do reference/memory based comparision
if you want to compare 2 objects you will always have to override equals method to do so 
utility wala method ko bhi override karna padega then it will comapre otherwise reference based only

Objects.equals()
String.equals()
Integer.equals()
Object.equals() (parent class)
== (reference comparison)


string methods in java
contains -> matches substring in sequence and returns boolean and it is case sensitive
concat -> str.concat(str2)
charAt
startsWith


map methods
map.put() -> put a new key value pair 
map.get() -> pass the key name and it will return value
map.containsKey -> pass the key and returns boolean according to presence
map.keySet()
map.values()
map.entrySet()
map.of()
3 ways to loop -> entry set and lambda and keySet and get(keySet)


set methods 
set.of() -> 
set.add()
set.contains
set.clear
set.isEmpty()
set.remove()



jackson 
convert a list to jsonNode and jsonNode to list 
convert a jsonNOde to user class 
and convert a userClass to jsonNode
retrieve the pointer 
retrieve the value
how to set value of perticular key in jsonNode
node.get(keyName)
node.put()
node.at() -> JsonNode bookNameNode = node.at("/book/details/bookName"); -> fetch nested values
how to update a value -> you need to knwo the key name and ressing its value -> node.put("abd", "def")


both works for converting value
UserEntity userObj = objectMapper.convertValue(jsonNodeInputPayload, UserEntity.Class);
UserEntity userObj = objectMapper.convertValue(jsonNodeInputPayload, new TypeReference<>() {});



enum -> id se value and value se id 
UNKNOWN.getId()
get(2) -> will return Unknown
and it provides consistnecy in whole code and restrains other values 
same using foreing key you can do in db also 

ngnix reverse proxy (load balancing) and routing helps in load balancing 
