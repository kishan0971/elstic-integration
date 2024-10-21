package com.in2it.elasticdemoproduser.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
	
	int id;
    String name;
    String pdate;
    Date edate;

}
