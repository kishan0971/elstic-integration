package com.in2it.elasticdemoconsumer.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "kafkauser")
public class User {
	
	@Id
    int id;
    @Field(type = FieldType.Text, name = "name")
    private String name;
    
    
    @Field(type = FieldType.Text, name = "pdate")
    private String pdate;
    
    @Field(type = FieldType.Date, name = "edate")
    Date edate;
    
    

}
