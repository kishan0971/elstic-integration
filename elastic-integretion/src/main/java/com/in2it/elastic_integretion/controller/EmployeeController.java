package com.in2it.elastic_integretion.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.in2it.elastic_integretion.model.Employee;
import com.in2it.elastic_integretion.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	private final EmployeeService service;

	@Autowired
	public EmployeeController(EmployeeService service) {
		this.service = service;
	}

	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping
	public void createEmployee(@RequestBody Employee employee) {
		service.createEmployee(employee);
	}

	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/{id}")
	public Employee getEmployee(@PathVariable String id) {
		return service.getEmployeeById(String.valueOf(id));
	}

	@GetMapping
    public Iterable<Employee> getAllEmployees() {
        return service.getAllEmployees();
    }

/*	@GetMapping("/_search")
	public List<Employee> searchEmployees(@RequestParam(value = "query", required = false) String query) {
        return service.searchEmployees(query);
    }*/


}
