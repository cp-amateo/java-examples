# Example kafka
Example project to show how to use kafka with spring-boot and avro.
The application have an endpoint to produce events and a listener to retrieve the events from kafka.
Note that in a real application the producers and consumers should be in a different services as well as the event schema in an independent module.

## Prerequisites
* Maven
* Java 17
* Execute the following command to up and run kafka infrastructure
    ```bash
    docker-compose up -d
    ```

## Run the app
```bash
mvn spring-boot:run
```

## Produce and event
Send the follow request to create and event:
```
curl --location --request POST 'localhost:8080/customer/' \
--header 'Content-Type: application/json' \
--data-raw '{
    "firstName": "Alejandro",
    "lastName": "Mateo",
    "email": "amateo25@test.com"
}'
```

## Consume the event
In the logs we can see the consumer handling the event
```
2022-03-11 12:17:19.770  INFO 4032 --- [nio-8080-exec-1] o.a.kafka.common.utils.AppInfoParser     : Kafka version: 3.0.0
2022-03-11 12:17:19.770  INFO 4032 --- [nio-8080-exec-1] o.a.kafka.common.utils.AppInfoParser     : Kafka commitId: 8cb0a5e9d3441962
2022-03-11 12:17:19.770  INFO 4032 --- [nio-8080-exec-1] o.a.kafka.common.utils.AppInfoParser     : Kafka startTimeMs: 1646997439770
2022-03-11 12:17:19.777  INFO 4032 --- [ad | producer-1] org.apache.kafka.clients.Metadata        : [Producer clientId=producer-1] Cluster ID: lGyvNSElRva9tdQVJsvYtw
2022-03-11 12:17:19.821  INFO 4032 --- [nio-8080-exec-1] c.a.j.e.m.k.a.p.CustomerEventProducer    : Send event to 'customer-creation-topic' topic with id '4028702097109663441'
2022-03-11 12:17:19.874  INFO 4032 --- [ntainer#0-0-C-1] c.a.j.e.m.k.a.c.CustomerEventConsumer    : Consume costumer id: '4028702097109663441'

```
