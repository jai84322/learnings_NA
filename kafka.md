https://www.youtube.com/watch?v=ei6fK9StzMM
https://www.youtube.com/watch?v=hNDjd9I_VGA


An account with 1M followers posted a new post now you need to show it to his 1M followers once only
real time location update ola driver or zomato delivery boy food tracking

https://medium.com/@prayagbhatt2003/kafka-x-zomato-c07c02da09cd -> osm article by zomato 

fault tolerance ? (replication)

what does a broker/kafka-server do between producer and consumer ? 
and what is zookeeper doing there -> 

broker/kafka-server -> topics -> partition -> offsets

bin\windows\zookeeper-server-start.bat config\zookeeper.properties

bin\windows\kafka-server-start.bat config\server.properties

.\bin\windows\kafka-topics.bat --create --topic user-topic --bootstrap-server localhost:9092

.\bin\windows\kafka-topics.bat --list --bootstrap-server localhost:9092

producer
.\bin\windows\kafka-console-producer.bat --topic user-topic --bootstrap-server localhost:9092

consumer
PS C:\kafka> .\bin\windows\kafka-console-consumer.bat --topic user-topic --from-beginning --bootstrap-server localhost:9092

to check how many consumers are there currently 
.\bin\windows\kafka-consumer-groups.bat --list --bootstrap-server localhost:9092

specific topic I need to check 


topics -> partitions 
broker leader follower
consumer group 
consumer 
replicas
rebalancing 
zookeper 
why ksqldb 
parallaization and locality 
kafka logs 
what is kafka cluster 
what is kafka boot strap address ? 


topic is storing the data entity 
what is partitions -> based on the key of the message with data entity that message will be routed to that partition

commands:- 

docker exec -it <container_name> /usr/bin/kafka-topics --bootstrap-server localhost:9092 --list

docker exec: it runs the cmd inside the container 
-it: Combines two options:
-i: Keeps the input open for interactive mode.
-t: Allocates a pseudo-terminal for better output formatting.
<container_name>: The name or ID of your running Kafka container.
/usr/bin/kafka-topics: The path to the Kafka topics command inside the container (Kafka's CLI tool for managing topics).
--bootstrap-server localhost:9092: Specifies the Kafka broker to connect to (localhost:9092 in your case).
--list: A flag to list all available Kafka topics

kafka cluster -> kafka broker -> topics and partitions 

docker-compose ps -> To lists all the services along with their current status
docker-compose logs -> it will tell you logs since container were started
docker-compose logs | grep "search_term" -> this will work with search also 
docker-compose up -> to start all the services
docker-compose down ->  to stop all services 


docker exec -it <container_id> /usr/bin/kafka-topics --bootstrap-server localhost:9092 --list

what does bootstrap server mean ? host machine ? 

A bootstrap server is the initial Kafka broker that a client (like a producer or consumer) connects to in order to discover other brokers in the Kafka cluster. It doesn't need to be the full list of brokers, just one to start the connection. It could be a host machine or any broker in the cluster.

q- how to check brokers 

https://www.youtube.com/shorts/KYxnjH1RLIE -> kafka broker osm video 

imp -> kafka broker is group coordinator








