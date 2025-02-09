https://chatgpt.com/c/675b4128-a66c-8007-adc4-cf247ff3c533

https://www.youtube.com/watch?v=i53Gi_K3o7I
https://www.youtube.com/watch?v=F2FmTdLtb_4

cap theorem -> consistency, availability, partition tolerence 

avaiability -> uptime and downtime 
uptime -> SLO -> service level objectives
downtime -> SLA -> service level agreements 

speed of system -> throuput and latency
throuput -> how much data our system can handle over a period of time || 
server throughput -> RPS (req per sec) 
DB throuput -> queries per second
data throuput -> bytes/sec -> data transfered over network in given period of time

latency -> time it takes for a request to get the response 

db thorugput -> SELECT sum(xact_commit + xact_rollback) FROM pg_stat_database;
divide it by time measured will give persecond queries handle number

refer to preethi kasireddy blog also on how this whole web working 

write back asynchronously

