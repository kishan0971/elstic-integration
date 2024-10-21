package com.in2it.elasticdemoconsumer.kafka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.in2it.elasticdemoconsumer.model.User;
import com.in2it.elasticdemoconsumer.service.KafkaUserService;

@RestController
@Service
public class ConsumerController {
	
	@Autowired
    KafkaUserService kafkaUserService;
   
    
    @KafkaListener(topics = "demo-topic", groupId = "demo-group")
    public void listen(String user) {
        System.out.println("Received User information : " + user.getClass().getName());
        
        
        
//        try {
//            kafkaUserService.saveUser(user);
//        } catch (Exception e) {
//            e.printStackTrace();    
//        }
        
        ObjectMapper mapper = new ObjectMapper();
        
        

	    try {
			User value = mapper.readValue(user, User.class);
			System.out.println("successfully converted into dto class "+value.getClass().getSimpleName());
			
			kafkaUserService.saveUser(value);
			
			
			
			
		} catch (JsonProcessingException e) {
			System.out.println("Found error while converting it into string...");
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
        
        
    }
   
    @GetMapping("/getElasticUserFromKafka")
    public Iterable<User> findAllUser() {
        return kafkaUserService.findAllUsers();
    }

}
