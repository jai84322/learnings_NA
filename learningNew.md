select cast(row_to_json(f.*) as text) from invoice_tracker.getfeeaccruedfilterkeys(cast(?1 as jsonb)) f;


cast(?1 as jsonb)  : converts string(input) to json and ?1 is a placeholder 

select cast(row_to_json(f.*) as text)  : converts rows coming from db to json and than that json to text

return query select * from invoice_tracker.fee_accrued fa where
			(products is null or array_length(products, 1) = 0 or fa.product_id = any(products)) and
			(orgIds is null or array_length(orgIds, 1) = 0 or fa.originator_id = any(orgIds)) and
			(fa.company_id=companyId)
			order by fa.last_modified_date desc;

cast(json_agg(row_to_json(c)) as text) : convert a row into json object and aggregate that object into json array. and you might have a question (c.*) OR (c) both are same if you write c.* it shows all columns and if you write c only it says include whole row.


Query : select * from xyz where join

function syntax : 
CREATE OR REPLACE FUNCTION invoice_tracker.testFunction(req jsonb)
RETURNS text
LANGUAGE plpgsql
AS $function$
declare result_set text;
begin
return result_set;
end;
$function$
;

postgre variables/declare : 
result_text text; --------- no limit 
bank_name varchar;  -------a limit to store string
resultData jsonb = null;
settlementDate date = null;
maturityDate date = null;
compliantCount int8 = null; --------- 8 byte 
VersionNumber int; ------- 4 byte  OR invoice_count bigint; 
originalFeeSum double precision;
is_live boolean;
orgId text[];  ---- array of text
iId text[];    
pId bigint[];  ---- array of int8
fTyp bigint[];
fCnt bigint;

from request object/simple object :- see below from invoice_tracker.getallfilteredfeedetails(req jsonb)
pageNo integer = ((req->>'pageNo')::integer);
pageSize integer = ((req->>'pageSize')::integer);
offsetValue bigint = (pageNo * pageSize);
isPageable boolean = ((req->>'pageable')::boolean);

from request array of object :- see below from invoice_tracker.getfilteredfeedetails(req jsonb)
orgIds text[] = (select array_agg(a)::text[] from jsonb_array_elements_text(req->'originatorIds') as a);
invIds text[] = (select array_agg(a)::text[] from jsonb_array_elements_text(req->'investorIds') as a);
fee_types bigint[] = (select array_agg(a)::bigint[] from jsonb_array_elements_text(req->'feeTypes') as a);
products bigint[] = (select array_agg(a)::bigint[] from jsonb_array_elements_text(req->'products') as a);
statusIds bigint[] = (select array_agg(a)::bigint[] from jsonb_array_elements_text(req->'statusId') as a);
companyId text = ((req->>'companyId')::text);

another :- from invoice_tracker.invoices(req jsonb)
orgIds text[] = (select array_agg(a)::text[] from jsonb_array_elements_text(req->'originatorIds') as a);
invIds text[] = (select array_agg(a)::text[] from jsonb_array_elements_text(req->'investorIds') as a);
fee_types bigint[] = (select array_agg(a)::bigint[] from jsonb_array_elements_text(req->'feeTypes') as a);
products bigint[] = (select array_agg(a)::bigint[] from jsonb_array_elements_text(req->'products') as a);
invoice_stage int = ((req->>'stage')::int);
from_date date = ((req->>'fromDate')::date);
to_search_date date = ((req->>'toDate')::date);
companyId text = ((req->>'companyId')::text);
from_settlement_date date = ((req->>'fromSettlementDate')::date);
to_settlement_date date = ((req->>'toSettlementDate')::date);


:- text, jsonb, date, int8, array, boolean

what can you RETURN from function : text, return table(), SETOF invoice_tracker.fee_accrued(custom), jsonb

java variables : char boolean float double byte short int long 
default store value ? :- 
types of variable : local : method only , instance : instance specific and is not shared among instances., static : can be access from all methods.

------------------------------------------------
groupBy in query left/right join ?  
json build object why ? 
sum(lp.quantum) as "quantum",
array_agg(lp.product_id) as "productId",
array_agg(lp.product_name) as "productName",
jsonb_build_object('lendersCount',lenderscount,'facilityCount',facilitycount);  :- treasury.getallcovenantscomplaince()
learn only get live liability as of now 
-------------------------------------------------

learn only treasury.get_liability_data() as of now + right join + normal join 

requirement :- you need to fetch all live liability that are in live and fetch their tranches and products and lender name 


Rest Syntax : 
entity table id sequence generated value column @entity package
controller -> service instance @restController requestMapping public void abc() {}
service -> repo instance @service @component public void xyz() {}
repo -> why this interface ? 


abstract class java :- it is declared with abstract keyword and it can have abstract and non abstract methods. the usecase is like there's a method which might be used in mutiple different classes so you will write a parent class and will write a child class (child extend parent)and in those methods will override this one. usecase is defining common behavior in a base class. 

abstract class Shape {
    abstract double area();
}

object has state and behaviour :- example car
attribute or properties (state) :- color, speed, fuelLevel, numberOfDoors
actions or operations (behaviour) :- start(), accelerate(), brake(), turnOnLights()

abstraction encapsulation inheritence polymorphism 

class extends class
class implements interface 
interface extends interface

@PathVariable("userId") Integer userId and @GetMapping("/getspecificuser/{userId}"):- inside paranthesis is for mapping the name.
@RequestParam(name = "age") Integer age and @GetMapping("/getspecificuser"):- age you need to put as key in postman and then enter age.
@RequestBody UserEntity userEntity

Optional -> used to handle positive and negetive cases on search automatically 

left join right join join/innerjoin :- alice and bob books 

GROUP BY
You are grouping the result set by lt.liability_tranche_name, lrp.liability_request_id, lrp.liability_request_product_id, and lr.investor_name. 
bro because it's part of the columns selected in the inner query, and it returns unique combination of those columns and you can try more with aggregate function 




***********************

controller
entity
service
repo
helper for validation 
pom.xml
properties
methods of java internship
postgre function

get all user api - done 
get specific user - done
post api - done
put api - done
delete api - done
filter api 
post+putapi
error handling and validations 

requestParam - done
pathvariable - done

giving error when trying to ch ange id in put api and how to handle error i don't know 
if email is unique and thne giving same will give error checked hwo to handle i don't knwo 


**************************
primary key and unique constraint are almost same they ensure uniqueness but the purpose is different PK is for giving an ID to each row to identify and unique constraint is to remove duplicacy like email now email is not for identifying the row thats why they serve different purpose also unique can be null but primary cant be null. 

