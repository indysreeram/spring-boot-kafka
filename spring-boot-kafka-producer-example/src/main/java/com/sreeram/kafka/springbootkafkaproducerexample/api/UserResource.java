package com.sreeram.kafka.springbootkafkaproducerexample.api;

import com.sreeram.kafka.springbootkafkaproducerexample.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/kafka")
public class UserResource {

    @Autowired
    private  KafkaTemplate<String, User> kafkaTemplate;

    private static final String TOPIC = "Kafka_Example";

    @RequestMapping(value="/publish/{name}",method = RequestMethod.GET)
    public String post(@PathVariable String name){
        System.out.println("I am here!!!");
        kafkaTemplate.send(TOPIC,new User(name,"Technology",2000L));
        return "Published Successfully!!!";
    }
}
