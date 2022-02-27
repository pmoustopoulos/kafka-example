# kafka-example
Download Kafka https://kafka.apache.org/quickstart

Unzip the download file and use ```cd``` command to go inside the folder.
1. Open a terminal and run ```bin/zookeeper-server-start.sh config/zookeeper.properties``` to start zookeeper
2. Open another tab inside the terminal and run ```bin/kafka-server-start.sh config/server.properties``` to start Kafka
3. With the following command ```bin/kafka-console-consumer.sh --topic ainigma100 --from-beginning --bootstrap-server localhost:9092``` you can start a consumer which will receive any messages sent to kafka
