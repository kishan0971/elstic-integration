package com.in2it.elastic_integretion.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.in2it.elastic_integretion.model.Employee;
import com.in2it.elastic_integretion.repository.EmployeeRepository;

@Service
public class EmployeeService {

	private final EmployeeRepository repo;

	@Autowired
	public EmployeeService(EmployeeRepository repo) {
		this.repo = repo;
	}

	public void createEmployee(Employee employee) {
		repo.save(employee);
	}

	public Employee getEmployeeById(String id) {
		Optional<Employee> result = repo.findById(id);
		return result.isPresent() ? result.get() : null;
	}

	public Optional<Employee> getEmployee(String id) {
		return repo.findById(id);
		// or return null if not found
		// return repo.findById(id).orElse(null);
		// or throw an exception if not found
        // return repo.findById(id).orElseThrow(() -> new RuntimeException("Employee not found"));
		// or use Spring Data's Query By Example feature
        // return repo.findOne(Example.of(new Employee(id)));
	}
	public Iterable<Employee> getAllEmployees() {
        return repo.findAll();
    }
}