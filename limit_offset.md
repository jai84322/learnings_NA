Exactly!

OFFSET: Starting point (skip these rows).
LIMIT: Number of rows to retrieve from the OFFSET.


example:- 
SELECT personal_id, customer_name, loanEncryptJsonFields(kyc_details)
FROM nimbus_loan_system.customer_data.personal p 
LIMIT 100 OFFSET 33634;

-> this will retrieve 100 rows starting from the 33635th row.
