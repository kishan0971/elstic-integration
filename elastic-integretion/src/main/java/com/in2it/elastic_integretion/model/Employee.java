package com.in2it.elastic_integretion.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Document(indexName = "employee")
@Getter
@Setter
@ToString
public class Employee {

	@Id
	private String id;

	@Field(type = FieldType.Text, analyzer = "standard")
	private String firstName;

	@Field(type = FieldType.Text, analyzer = "standard")
	private String lastName;

	@Field(type = FieldType.Double)
	private double salary;

}
