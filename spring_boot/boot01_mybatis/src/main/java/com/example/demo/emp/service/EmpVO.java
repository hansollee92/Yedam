package com.example.demo.emp.service;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EmpVO {
    
    String employeeId;
    
	String firstName;
	String lastName;
	String email;
	
	@JsonFormat(pattern = "yyyy-MM-dd HH")
	String hireDate;   //LocalDateTime  , Date
	
	String jobId;
	
	String departmentId;
	 
	Integer salary;
	
	@JsonIgnore
	Integer[] employeeIds;
}
