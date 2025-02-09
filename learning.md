INDEX :- 
A) TREASURY-START and TREASURY-END ---> cancel
B) JAVA-LEARNING-START and JAVA-LEARNING-END ---> CURRENT 
C) SQL-START and SQL-END ---> cancel
D) JAVA-OBJECT-MAPPER-START and JAVA-OBJECT-MAPPER-END ---> CURRENT
E) ECON-START and ECON-END ---> cancel
F) POSTGRE-FUNCTION-START and POSTGRE-FUNCTION-END
G) RANDOM-START and RANDOM-END ---> cancel
H) FINAN-START and FINAN-END ---> cancel
I) NA-LEARNING-START and NA-LEARNING-END  :- has sundar-sir portal info ---> cancel
J) BALAN-START and BALAN-END ---> cancel
K) BEFORE-COMMIT-PREP 
L) BEFORE-CALL-PREP    (to senior's for doubts and questions)
M) SHORTCUTS
I) Learn about custom exception and implement them





===================================== JAVA-OBJECT-MAPPER-START =========================================

1) to create ArrayNode  = 
ex:- 
        ObjectMapper objectMapper = new ObjectMapper();

        // Create an empty ArrayNode
        ArrayNode arrayNode = objectMapper.createArrayNode();

        // Add some elements to the ArrayNode
        arrayNode.add("Item 1");
        arrayNode.add("Item 2");
        arrayNode.add("Item 3");

        // Print the ArrayNode using System.out
        System.out.println(arrayNode);

                // You can also convert ArrayNode to a JSON string
        String json = arrayNode.toString();
        System.out.println(json);

output :- ["Item 1","Item 2","Item 3"]


2) to create Objectnode = 
ex:- 
        // Create an ObjectMapper
        ObjectMapper objectMapper = new ObjectMapper();

        // Create an empty ObjectNode
        ObjectNode objectNode = objectMapper.createObjectNode();

        // Add key-value pairs to the ObjectNode
        objectNode.put("name", "John Doe");
        objectNode.put("age", 30);
        objectNode.put("email", "johndoe@example.com");

        // Print the ObjectNode using System.out
        System.out.println(objectNode);

        // You can also convert ObjectNode to a JSON string
        String json = objectNode.toString();
        System.out.println(json);

output :- 
{
  "name" : "John Doe",
  "age" : 30,
  "email" : "johndoe@example.com"
}




3) convert a list of objects to jsonNode node = 
ex:- 
  ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.valueToTree(myList);


4) convert the jsonNode to list again = 
ex:- 
        JsonNode jsonNode = objectMapper.readTree(json); // reading the json string and deserializing it to JsonNode to work with it 

        // Define the target type using a TypeReference
        TypeReference<List<MyObject>> typeReference = new TypeReference<List<MyObject>>() {};

        // Convert the JsonNode to a list directly
        List<MyObject> myList = objectMapper.convertValue(jsonNode, typeReference);




question : convert a list of objects to jsonNode and create a copy of it and convert that copy back to list of objects

ex:- 
                // list to JsonNode
JsonNode jsonNode = objectMapper.valueToTree(subventionSheetList);
                // copy the jsonNode 
JsonNode copiedNode =  copiedNode = mapper.readTree(mapper.writeValueAsString(jsonNode));
                // convert the jsonNode back to list of class 
List<TenorInstitutionDAO> copiedList = objectMapper.convertValue(copiedNode, objectMapper.getTypeFactory().constructCollectionType(List.class, TenorInstitutionDAO.class));
 
            
5) please create a copy of jsonNode 
        JsonNode originalNode = mapper.readTree(jsonData); // jsonData coming from db 

        // Serialize the original JsonNode to a JSON string
        JsonNode copiedNode = mapper.writeValueAsString(originalNode);
        JsonNode copiedNode = mapper.readTree(jsonString);

understanding :- see you know in node js I used to hit the request body in postman and that used to send the data in the form of json String right then in the index js file of node js we had body parser over there which used to convert the data format from json string to json object so that you can perform method on it. SIMILARLY over here lets say you got the JSON data from db and you store it in the Json variable fine. now you writevalueasstring so this will serialize/data-format-change json object to json string using "mapper.writeValueAsString(jsonNode)" this method will do the data format change and then when you convert it back from json string to jsonNode you effectively create a new, independent copy of the original JsonNode. so it helps you deep copy 


6) Convert Java Object to JsonNode (Serialization): lets say you have User class and you want to convert one object of User class to jsonNode 
NOTE :- if it's single object than jsonNode will be object node inside and if it's list than jsonNode will be array node inside 
ex:-
        ObjectMapper mapper = new ObjectMapper();
        
        // Create a User object
        User user = new User("Alice", 30);
        
        // Serialize the User object to a JsonNode
        JsonNode jsonNode = mapper.convertValue(user, JsonNode.class);
        

7) Convert JsonNode to Java Object (Deserialization): lets say you have a jsonNode of User object stored in the DB so you call DB and retrieve it now you want to convert that into User class object
ex:- 
        ObjectMapper mapper = new ObjectMapper();
        
        // Create a JsonNode
        JsonNode jsonNode = mapper.readTree("{\"name\":\"Alice\",\"age\":30}"); // userObj directly from db 
        
        // Deserialize the JsonNode to a User object
        User user = mapper.convertValue(jsonNode, User.class);
        

8) YOU CAN convert a hash map into java class object 
ex:- 
ObjectMapper mapper = new ObjectMapper();
Map<String, Object> dataMap = new HashMap<>();
dataMap.put("name", "Alice");
dataMap.put("age", 30);
MyObject myObject = mapper.convertValue(dataMap, MyObject.class); // replace MyObject with class name 


9) how to run for loop in java on jsonNode objects covering all key values pairs 













================================ TREASURY-START ==============================================





18) earlier it was bplr(lack of transparency) till 2010 -> base rate(avg cost of funds) till 2016 -> mclr(marginal cost of funds) 
and then there is repo rate
- there is something called as fixed and floating interest rate 
- spread
- repo rate one is of RBI and another mean is from banks repo rate mean they are linking the interest to rbi repo rate which is nothing but benchmark+spread. This is the new system. this was done to become increase more transparency within the system. 
- 

17) got to know an amazing stuff
I checked axis bank website and here's the link https://www.axisbank.com/retail/loans/education-loan/interest-rates-charges
you go there won't be able to copy the content or will be able to even right click and go to inspect the page 
so I used chat gpt and he told disable the Javascript and I did that and it worked 

tranche -> a part of the whole (like a branch)










================================= POSTGRE-FUNCTION-START ================================

- like, ilike, not like
* like :- LIKE is case-sensitive, so if you use LIKE to search for a pattern, it will only match strings that have the same case (e.g., it won't match "apple" to "Apple").
* ilike :- ilike, on the other hand, is case-insensitive. It will match patterns regardless of the case of the characters. For example, it will match "apple" to "Apple" as well as to "aPpLe."
* not like :- column NOT LIKE '%apple%': This will return rows where the column does not contain 'apple' anywhere within the string.




l.created_date >= date_trunc('month', current_date - interval '1 day')
- this is saying that if created date is larger than trunc date than filter that include it and date_trunc is 1oct to 16 oct (considering today is 17 oct)


query param in java = 
(@RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate)

path param in java = @PathVariable 
(@PathVariable final String pincode)


select cast(json_agg(row_to_json(c)) as text): This part collects all the rows (c) and converts them into a JSON array using json_agg. The result is then cast to text.



16) basic function syntax 
ans- 
CREATE OR REPLACE FUNCTION treasury.get_Live_Liability_Requests()
RETURNS text
 LANGUAGE plpgsql
AS $function$
declare

begin

return 
end;
$function$;


11) how to create new function ?
ans- go to function in dbeaver right click on it and -> create new function -> select plpgsql lang



======================= ECON-START =========================================================

- RBI controlling money means making easier and harder to borrow money. cost of borrowing that money. 
- Easy to Get Money (Lower Repo Rate) and Harder to Get Money (Higher Repo Rate)
- govt want money they will sell their securities to banks and get the money and when banks want money they will sell those securites to RBI and will get the money 
- In the simplest practical way, when we say the Reserve Bank of India (RBI) is "controlling money," it means the RBI is managing the amount of money circulating in the economy.
- does a country knows how much cash is rotating in the country ? Yes, countries have mechanisms in place to track and measure the amount of cash circulating within their borders.
- what is Money Supply ?
ans- there are m0 m1 m2 kind of things you go through the below article  
https://testbook.com/ias-preparation/money-supply#:~:text=The%20Reserve%20Bank%20of%20India,money%20circulation%20in%20the%20economy. 

https://www.statista.com/statistics/1028099/india-currency-in-circulation-value/#:~:text=After%20India%20declared%20demonetization%20of,as%20of%20financial%20year%202023.

- this only rbi attacks on through repo rate to manage inflation and growth too 
- if rbi prints excessive/infinite money then :- 
Yes, printing an excessive amount of currency, without a corresponding increase in the value of goods and services in the economy, can lead to a decrease in the value of the currency.
- what is increase in the value of goods and services in the economy ?
ans - 













===================================== SQL-START ==========================================

10) Left join and Right join 

12) how to delete a function ? 
ans- DROP FUNCTION IF exists treasury.get_liability_data();
DROP FUNCTION IF EXISTS nimbus.treasury.get_liability_data;

13) how to call a function ? 
ans- SELECT * FROM treasury.get_liability_data();
ex2- SELECT * FROM treasury.get_liability_data(param1, param2, ...);


14) how can you explicity cast a string data returned from function to a json data in the cmd palate
ans- SELECT treasury.get_liability_data()::json;

15) how to call that method from repo layer ? 
ans- select * from treasury.fn_fetch_all_static_data()


SELECT ii.*, cci.is_deleted FROM el.institution_info ii 
JOIN el.coaching_center_info cci ON ii.institute_code = cci.id 
WHERE cci.is_deleted = false 
order by ii.created_date;


select institute_code, jsonb_build_object(
    'to', jsonb_build_array('c.jaisharma@northernarc.com'),
    'cc', jsonb_build_array('jai.s@refactor.academy')
) as institute_email from public.institution_email;



UPDATE el.institution_info 
SET institute_email = jsonb_build_object(
    'to', jsonb_build_array('c.jaisharma@northernarc.com'),
    'cc', jsonb_build_array('jai.s@refactor.academy')
)



select institute_code, jsonb_build_object(
    'to', (
        SELECT jsonb_agg(email)
        FROM unnest(string_to_array(emails, ', ')) AS email
    ),
    'cc', jsonb_build_array('RetailEL&PL@NorthernARC.com')
) as institute_email from public.institution_email;



SELECT course_id
FROM el.coaching_center_fee
ORDER BY course_id::integer DESC
LIMIT 1;


UPDATE el.institution_info
SET institute_email = null
where institute_code = 'EL_CI_0040'



1) select statement 
a) if you have a public schema and inside that you have institution_email named table and if you want to fetch all columns in one command than use this below 
- select * from public.institution_email ie;

b) if you want to retrieve specific columns only than you can use below cmd 
- select institute_code, institute_name from public.institution_email ie;

2) where statement 
a) if you want to fetch all columns for institution_email whose branch_code is "Kolkata-EL"
- select * from public.institution_email ie where branch_name = 'Kolkata-EL';

b) to get customers who made purchases over $100 
- SELECT * FROM user.customer WHERE total_purchases > 100;

c) You can also combine conditions using logical operators like AND and OR
- SELECT * FROM user.customer WHERE city = 'New York' AND total_purchases > 100;

ALIAS : An alias is a way to provide a temporary name for a table or a column in a query. 
ie is The "ie" is an alias for the public.institution_email table  = in simple it's a temperory name for table

USE CASE OF ALIAS 
- they are often used when you join multiple tables together or when you reference the same table multiple times in a single query.

ex query :- 
SELECT c.first_name, o.order_date
FROM user.customer c
JOIN user.orders o ON c.customer_id = o.customer_id;

- in SQL, you can use aliases in your query before defining them later in the query


QUE : IN  "customer" Table: user_id is foreign key right ?












====================================== SQL-END ================================================





===================================== RANDOM-START ==========================================

19) 
don't forget about the broken bucket 
sql postgreSQL function and java
DS and CP 
frontend 







===================================== JAVA-LEARNING-START ==========================================

data types in java :- 
primitive :- byte short int long float double char bool 
non primitve :- array, class, object, interface, string


- @Id annotation :- you can use it make some column as primary key 
- @SequenceGenerator :- you say allocation size ke bhai 1 then increment then further and you give name to refer for springboot
- @GeneratedValue :- here you tell the strategy like GenerationType.SEQUENCE ke bhai sequence me generate krna hai 
- @Column(name = "fname") private String name; 
- @Table :- here you can tell the name and schema 








====================================== FINAN-START ================================================






===================================== NA-LEARNING-START ============================================

 
liability request 
payment memo 
draw-down request 
repayment schedule

check nimbus>treasury>status => for knowing all the status that a loan go through 

WCDL -> working capital demand loan 
TL -> term loan 
ECB -> external commercial borrowings
CP -> commercial paper 
LAS -> loan against securities
LAP -> loan against property
MLD -> Market Linked Debentures 
TL Syn -> Term Loan Syndication
NCD -> Non-Convertible Debentures
PBI -> Pooled Bond Issuance
PLI -> Pooled Loan Issuance
PTC -> Pass through Certificate
DA -> Direct Assignment

tranche -> a part of the whole (like a branch)

XIRR -> 



Mortgages are used to purchase homes.
Loans can be used for a variety of purposes.
Trade receivables are invoices that businesses send to their customers for goods or services that have been delivered.


PORTAL-KNOWLEDGE-KT BY SUNDAR SIR

lending business 
our own money 
or arrange money 
FI -> financial institution -> public prive bank nbfc = originators = reach out to customers => fund + arrange money by NA 
end borrower 

FI -> originator and investor also 
investor -> public private other nbfc 
nA can arrange money to borrower 

originator => who is finding customer and giving money 
NA will arrange or will give 

for a trasaction a protocol needs to be followed 
financial legality when a transaction change takes place like ggl pay screenshot 

loan paper will be verified  by legal people => legal council 

rating agency -> will rate will audit and will rate a transaction 
ranking order for financial trasaction s = for credibility of trasaction 

investor originator stakeholder -> 
can you give one example of how it took place practically and who were originator investor and stakeholder 

helping hands -> sponser or non sponser transaction - stakeholder 
bluetooth many legal documen signing -> muthooth legac doc -> they are helping us to to execute the doc so legal is stakeholder here 

investor portal 

internal module -> nimbus => this do underwriting 
underwriting procees -> check eligibility and decide how much we can give 

RM for muthooht ashirvaad 
CIN and MCA ministry of corporate affairs 
cin will chagne from one state to another state 

northern arc will collect(askers data) and scrutnize and check balalnce sheet 
credit commitee approve financial transaction top most authority 
RM will collect doc from entity -> will give to credit origincation team -> CA people 

finanly credit team prep due deligance report 
that will be given to credit comittee 
onboard entity into our list to credit comitte 
credit team will sanctioned the amount 
that process is limit proposal will say(credit comit) how much we can give for now lets see than 

now risk will analyse risk in thath 
ex:- 
promoters are family members 
no intervention 
risk will say how can we trust family 
risk will do risk analysis final -> after risk suggestion -> call by credit comittee only 

for any financial transaction there will be term sheet signing -> terms and conditions 
will have who is bororower what is interest rate who is promoter 
convinience -> rules and regulations -> what you can't do 
security guarantee -> give me the gurantee to pay back -> secured or unsecured 
interest rate will differ for secured and unsecured 
urgent money -> security 

term sheet will be prepared from both sides 
power of attorney 
origination -> underwriting -> credit commit -> risk -> credit commit -> approv money -> business -> NA will prep term sheet -> signing term sheet -> document execution -> NA will receive a disbursement request 

will create a payment memo -> notice -> to release money and get it approved 
in LMS -> will create the record of this and will generate future repayment schedule 
on fixed date will have to give it back 

orginater ask for money NA will prep term sheet 
repayment schedule 

muthooth geting money from NA -> has to be reported to RBI saying muthoth got money from NA 
so a doccument needs to be signed and aknowledgment from RBI 

are these securitization trasactions 

term loan 
working capital = SCL = role over credit = credit card kind of stuff 
principal outstanding = exposure = POS 
exposures = 

AUM -> asset -> loan which are given to borrowers 
gold shop -> gold is asset 
carpenter -> wood is asset 

AUM -> will keep increase 

mid corporate 
every originator can't be a financial institution 

naveen then sundar sir 
functional clarification by naveen only then sir 
clarification on requirement - naveen 
jira work log start date -> madhu 
bhuvana -> test cases demo to stakeholders 
mohammed/aashiq -> fast api PR review technical ccode review test cases 
bharat and harshit -> 
connect with aashiq -> for treasury download and setup 

IT'S TOTALY YOUR RESPONSIBILITY YOUR ACCOUNTABLITY 

https://collaborate365-my.sharepoint.com/:v:/g/personal/sundararajan_r_northernarc_com/Eex5q18NcXpAjzkHqbKvUp8BmPvi36Tfc_z8hQXhi7AjGQ

https://collaborate365-my.sharepoint.com/:v:/g/personal/sundararajan_r_northernarc_com/EUJeqac_0RpKrW1JWo2DKZUByj7AfsSl1JKvbHEoe9RsHQ

Originator Portal QA Likk: https://originatorqav2.northernarc.com/

Username: demo.user@portal.com

Password: Welcome@123

https://nimbusqav2.northernarc.com:8443/nimbus/index.html

financial transactions :- on balance sheet and off balance sheet 
on balance :- term loan and working capital loan 
off balance :- 
guarantee products :- PBI and PLI :- pool bond issuance and pool loan issuance 
placements :- no guarantee but we facilitate the trasaction and take arranger fee (brocker)
like facilitating the originator and investor and than take the money in between 
PTC
DA -> may do complete or may arrange 
NCD
MLD
Spiced bonds 
in all these above 5 NA can be complete investor one of the investor OR arranger also 

term loan and working capital product 
securitization product -> PTC, DA, NCD, MLD, spiced bonds 
gurantee product -> if originator goes on default -> then will pay back the amount 

capital markets -> stocks, bonds, debentures = long term money raising 

money markets -> t-bills, certificate of deposit, commercial papers, commercial bills 

equity and debt financing 

Debt: Refers to issuing bonds to finance the business.
Equity: Refers to issuing stock to finance the business.

equity financing = private placement of stock




MCLR -> minimum rate of interest benchmarked by the bank below which the bank cannot lend to the customers
MCLR -> Marginal Cost of Funds-based Lending Rate -> For short-term loans, the State Bank of India has hiked its Marginal Cost of Funds-based Lending Rate (MCLR) by ten basis points (bps).

what is FBLR -> 
what is HBLR -> 

EBLR -> External Benchmark based Lending Rate 
BPLR -> Benchmark Prime Lending Rate

documentation 
jira tickets 
log hours 
start date due date 
test cases 
tested 
fast api's 
ask for help 
akhil mehra 






===================================== BALAN-START ============================================

current assets = which is much more liquid || short term || ex :- expected trade receivables(baad me de dena mujhe), inventory, current assets, loans and advance(interest per de diya for short term), goodwill and Intangibles (paid extra during valuation is good will amount)    
and non current assets = not much liquid || long term 


current liabilities || ex:- trade payable(baad me de dunga tujhe), 
non current liabilities || ex:- shareholder fund(reserve and surplus)

deffered tax liabilities :- kisi saal ka tax nahi bhara and ITR now asking for that year TAX and case going on company saying NO TAX but ITR saying give TAX 

https://www.youtube.com/watch?v=7Q-nFRn7fIQ


debt to equity ratio :- 
pledged promoter holdings 


Balance sheet has three things :- shareholders fund, liabilities, assets 
profit and loss statement :- 
cash flow statement :- 



=================================== BEFORE-COMMIT-PREP ========================================

check the comments 
check System.Out.Println();
check your changes one by one 
take the latest pull -> put changes files in shelf 
db commit pipeline failed because 1) data type of adding column is wrong 2) did not change the file name while reuploading in db 





====================================== BEFORE-CALL-PREP =======================================

get the application ready 
get the swagger ready with token and payload 
get the db tables open and ready
GET THE QUESTIONS READY and keep them short and easy to understand NOT LONGER STATEMENTS 



============================= SHORTCUTS =======================================

CTRL + SHIFT + I -> open inspect element and close it with the same 
















BOTTOM