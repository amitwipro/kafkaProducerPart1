To run this application, do the following:

1. Download Kafka https://kafka.apache.org/downloads and unzip
2. Go to "server.properties" in "conf" folder of Kafka
3. Add the following:
     listeners=PLAINTEXT://localhost:9092
     auto.create.topics.enable=false
4. Go to the "bin" directory of Kafka folder
5. Start zookeeper: 
    ./zookeeper-server-start.sh ../config/zookeeper.properties
6. Start kafka broker
    ./kafka-server-start.sh ../config/server.properties
7. Run "mvn clean install -DskipTests" to run the application
8. Run "KafkaproducerApplication.java"
9. Refer the console log. You will get a message like 
   Message has been sent successfully , 
   key: 0 and the value is {"orderEventId":0,
   "order":{"orderId":12,"orderCode":"AD_DIGI"}} and partition is 1
10. Now refer the consumer application in github 
    https://github.com/amitwipro/kafkaConsumerPart1.git and follow the instruction there
