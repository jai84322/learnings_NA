there are 2 table user 2000 records and customer (main table) 1000 records 

there is left join -> since customer is main talbe so will keep customer on left side and user on right side and it will return null for remain 1000 user values that doesn't match for all columns 
there is right join -> wil keep customer on right 
there is inner join -> will only return matched rows in both and I will keep customer.id = user.id 
since customer having lesser records 

ddl -> schema and table level things
dml -> crud level things 
 