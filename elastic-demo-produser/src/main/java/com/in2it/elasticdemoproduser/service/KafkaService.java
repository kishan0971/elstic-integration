package com.in2it.elasticdemoproduser.service;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.in2it.elasticdemoproduser.model.User;

 
@Service
public class KafkaService {
    private final Logger LOG = LoggerFactory.getLogger(KafkaService.class);
    @Autowired
    private KafkaTemplate<String, User> kafkaTemplate;
    String kafkaTopic = "demo-topic";
    public void send(User user) {
        LOG.info("Sending User Json Serializer : {}", user);
        kafkaTemplate.send(kafkaTopic, user);
    }
    public void sendList(List<User> userList) {
        LOG.info("Sending UserList Json Serializer : {}", userList);
        for (User user : userList) {
            kafkaTemplate.send(kafkaTopic, user);
        }
    }
}