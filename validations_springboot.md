springboot starter validation dependency 
 this gives all this 
 
 | Annotation | Purpose |
 | ------------------------------ | ----------------------------------- |
 | @NotNull | Field must not be null |
 | @NotBlank | String must not be null or empty |
 | @NotEmpty | Collection/String must not be empty |
 | @Size(min, max) | Length or size limits |
 | @Min / @Max | Numeric range |
 | @Email | Must be a valid email format |
 | @Pattern | Regex pattern match |
 | @Positive / @Negative | Positive/negative number |
 | @Past / @Future | Date must be in past/future |
 | @AssertTrue / @AssertFalse | Must be true/false |
 
 
 - i got to know this @notnull wont work without @valid in controller method (actual request level validation)
 - Column(nullable=false) = this is coming from spring-boot-starter-data-jpa and it's jpa/hibernate level validation but ye tabhi kaam kaarega jab DB table creation ya to auto ho ya manual me you given not null constraint
 - 3rd is database level validation while creating table we give (then nullable false anyways does not make sense jab db eerror throw karega hi then iska sirf readability ke liye accha hai)
 
 and this is why one dependency is clearly validation and other is data jpa dependency and so different level validation layers
 
 @NonNull in entity is for lombok class so that in rquired args constructor you can't send null
