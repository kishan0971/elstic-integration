package com.in2it.elasticdemoconsumer.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.in2it.elasticdemoconsumer.model.User;

 
@Repository
//@EnableElasticsearchRepositories
public interface KafkaUserRepository extends ElasticsearchRepository<User,Integer> {
   
}
