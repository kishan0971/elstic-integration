package com.in2it.elastic_integretion.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.in2it.elastic_integretion.model.Employee;



@Repository
public interface EmployeeRepository extends ElasticsearchRepository<Employee, String> {

}