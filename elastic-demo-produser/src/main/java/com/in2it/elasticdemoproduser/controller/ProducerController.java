package com.in2it.elasticdemoproduser.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.in2it.elasticdemoproduser.model.User;
import com.in2it.elasticdemoproduser.service.KafkaService;
 

 
@RestController
public class ProducerController {
    @Autowired
    KafkaService kafkaProducer;
   
    @PostMapping("/producer")
    public String sendMessage(@RequestBody User user) {
        kafkaProducer.send(user);
        return "Message sent successfully to the Kafka topic demo-topic";
    }
   
    @PostMapping("/producerlist")
    public String sendMessage(@RequestBody List<User> user) {
        kafkaProducer.sendList(user);
        return "Message sent successfully to the Kafka topic demo-topic";
    }
}