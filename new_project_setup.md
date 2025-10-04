1- download from spring intializer and run- mvn install -DskipTests
 1-a = download below dependencies intially
 - spring web starter
 - spring data jpa
 - spring starter validation
 - Lombok
 - postgresql driver
 - swagger dependency
 
 
 order of dependency matters (keep web at top then data jpa )
 
 
 2- learn to write pom.xml -> chapp jani chiye mind me 
 - artifact id and version se jar ka naam banta hai 
 - java version is imp and springboot parent also both should be compatible 
 - name and desc is non mandatory but for human reading 
 - dependency and iske andar ke tino tag sikhle 
 - model version and xml project is imp likhna sikh le and what it is doing understand that 
 - parent tag
 
 
 3- learn to write yaml -> you should know chapp jana chiye mind me all -> hogya kaam chalau to
 
 4- see what all is pending to do bare minimum in writing app -> bas controller likh de chal jayega
 
 5- custom object return with proper error handling like hashim did -> hogya ye done (custom exception baad me dekhenge)
 - generic response DTO class
 - util clas which will construct error succes response
 - service method will return generic object
 
 6- sql and procedures likhna sikh normal ones ddl and dml -> write remaining CRUD api's and native query for them 
 
 7- iske baad blogging website bna le 
 
 8-enums
 <!-- aaj ka bs dependency and pom xml krle -->