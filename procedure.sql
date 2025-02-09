-- RETURN STRING DIRECTLY 

create or replace function public.testFunction(test text)
RETURNS text
LANGUAGE plpgsql as $function$

BEGIN
    RETURN 'Hello, PostgreSQL!';
END;
$function$;


-- RETURN FROM A VARIABLE

create of replace function public.testFunctionOne()
RETURNS text
LANGUAGE plpgsql as $function$
declare
    message text;
BEGIN
    return message := 'Hello from DECLARE!';
END;
$function$;


-- return a boolean and declare boolean variable 

create or replace function public.testFunctionOne()
RETURNS BOOLEAN
LANGUAGE plpgsql as $function$
declare
    message BOOL;
BEGIN
     message := TRUE;
	return message;
END;
$function$;


select public.testFunctionOne();



-- a function can return these data types -> TEXT, BOOLEAN, INTEGER, JSONB, 
-- you can't change the return data type of a function you need to create new one  

-- a function that returns an integer 

create or replace function public.testFunctionOne()
RETURNS INTEGER
LANGUAGE plpgsql as $function$
declare
    message INT;
BEGIN
     message := 1;
	return message;
END;
$function$;

select public.testFunctionOne();

drop function public.testFunctionOne();


-- A FUNCTION THAT RETURN JSON

create of replace function public.testFunctionThree()
RETURNS JSONB
LANGUAGE plpgsql as $function$ 
declare
    result jsonb;

BEGIN
    result := '{
    "key1": "jhello",
    "key2": "testing",
    "key3": false,
    "key4": 4
}'::JSONB;
    return result;
END;
$function$;


-- a function that fetches data from other tables and builds the object and returns it in jsonb

create or replace function public.testFunctionFour(customerAccount TEXT)
RETURNS jsonb
LANGUAGE plpgsql AS $function$
DECLARE 
    result JSONB;
BEGIN
    select json_build_object(
     'customerName', cd.customer_name,
     'sanctionedLimit', cd.customer_approved_limit,
     'availableLimit', cd.customer_available_limit,
     'partnerName', pi.partner_name,
     'partnerCode', pi.partner_code
    ) INTO result
    from customer_data.customer_details cd
    left join partner.partner_info pi on cd.partner_id = pi.partner_id
    where cd.customer_account_number = customerAccount;
    return result;
END;
$function$;


select public.testFunctionFour('b8d773bf-996d-4165-ab9f-b6d5b1c5567d');

-- returns this object 
{"partnerCode": "UNICARD", "partnerName": "UNICARD", "customerName": "Jennifer", "availableLimit": 40000.00, "sanctionedLimit": 40000.00}


-- if I wnat to return in into text format and also extract some fields from json field in table 

create or replace function public.testFunctionSix(customerAccount text)
returns text
LANGUAGE plpgsql as $function$
declare 
    result text;
BEGIN
    SELECT cast(json_agg(json_build_object(
     'customerName', cd.customer_name,
     'sanctionedLimit', cd.customer_approved_limit,
     'availableLimit', cd.customer_available_limit,
     'partnerName', pi.partner_name,
     'partnerCode', pi.partner_code,
     'addressProof', cd.other_customer_details ->> 'addressProof' 
    )) as text) INTO result
    from customer_data.customer_details cd
    left join partner.partner_info pi on cd.partner_id = pi.partner_id
    where cd.customer_account_number = customerAccount;

    return result;
END;
$function$; 

select public.testFunctionSix('PC065');