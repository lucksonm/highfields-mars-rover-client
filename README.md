# highfields-mars-rover-client
Step 1: ssh into ec2-54-211-3-105.compute-1.amazonaws.com using src/resources/soskode.pem i.e ssh -i soskode.pem ubuntu@ec2-54-211-3-105.compute-1.amazonaws.com


Step 2: Start the Rover/Server by running this command: /school/no-gui-static$ ./server -p 8080 small-scatter.wrld


Step 3: Compile highfields-mars-rover-client and run the jar file by passing the IP address and port i.e java -jar highfiels-mars-rover-0.0.1-SNAPSHOT.jar  ec2-54-211-3-105.compute-1.amazonaws.com 8080
