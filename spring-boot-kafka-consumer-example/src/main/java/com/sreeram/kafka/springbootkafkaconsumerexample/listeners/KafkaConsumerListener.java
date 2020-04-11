package com.sreeram.kafka.springbootkafkaconsumerexample.listeners;

import com.sreeram.kafka.springbootkafkaconsumerexample.models.User;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerListener {

    @KafkaListener(topics = "Kafka_Example",groupId = "group_id")
    public void consume(String message){
        System.out.println("Consumed the message "+ message);
    }

    @KafkaListener(topics = "Kafka_Example_json",groupId = "group_id",
            containerFactory = "userConcurrentKafkaListenerContainerFactory")
    public void consumeJson(User user){
        System.out.println("Consumed a Json message : "+ user);
    }

}
