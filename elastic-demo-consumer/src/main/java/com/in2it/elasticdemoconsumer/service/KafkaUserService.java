package com.in2it.elasticdemoconsumer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.in2it.elasticdemoconsumer.model.User;
import com.in2it.elasticdemoconsumer.repository.KafkaUserRepository;


@Service
public class KafkaUserService {
	@Autowired
    private KafkaUserRepository edao;
   
    public void saveUser(User user) {
        edao.save(user);
    }
   
    public Iterable<User> findAllUsers() {
    return edao.findAll();
    }   

}
