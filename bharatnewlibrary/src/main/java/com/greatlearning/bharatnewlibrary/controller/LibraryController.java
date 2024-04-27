package com.greatlearning.bharatnewlibrary.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.greatlearning.bharatnewlibrary.entity.Student;

@RestController
public class LibraryController {
	
	@RequestMapping("/home")  //localhost:8084 enter
	public String greet()
	{
		return "Welcome to Bharat Library";
	}
	
	@GetMapping("/createApi")  //localhost:8084 enter
	public String createApi()
	{
		return "You have access to Create";
	}
	
	@GetMapping("/readApi")  //localhost:8084 enter
	public String getApi()
	{
		return "You have access to Read";
	}
	
	@GetMapping("/updateApi")  //localhost:8084 enter
	public String updateApi()
	{
		return "You have access to Update";
	}
	
	@GetMapping("/deleteApi")  //localhost:8084 enter
	public String deleteApi()
	{
		return "You have access to Delete";
	}
	
	@RequestMapping("/403")  //localhost:8084 enter
	public String forbiddenAccess()
	{
		return "You do have access to this service";
	}
	
	@RequestMapping("/testBuilder")  //localhost:8084 enter
	public Student testBuilder()
	{
//		Student s1=new Student(101,"Alice",78.5);
//		return s1;
		
		
//		Student s2=new Student();
//		s2.setRno(102);
//		s2.setSname("Ben");
//		s2.setPer(78.9);
//		
//		return s2;
		
		Student s3=Student.builder()
				.rno(103)
				.sname("Chris")
				.per(86.7)
				.bloodGroup("A+")
				.city("Pune")
				.build();
		
		return s3;
		
	}
	

}
