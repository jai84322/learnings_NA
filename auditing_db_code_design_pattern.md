pass any class dto new and old object
it will match whole object string by string and check equals and if there's change then
in summary table you will keep audit summary id entity type (class reference) and reference id is unique reference of that Object @id field 
and then in audit table will have new @Id and summary reference then property name and then old value and new value 
this is not json level audit but whole object level audit bro 


refer to this class of n-collect-api -> AdminAuditService
and tables here -> n_collect > audit > admin_audit_summary and admin_audit

just one thing that nothing is jsonNode in that field -> but you can handle this in case if some class is having jsonNode so accorndingly you can get into finding the changes 