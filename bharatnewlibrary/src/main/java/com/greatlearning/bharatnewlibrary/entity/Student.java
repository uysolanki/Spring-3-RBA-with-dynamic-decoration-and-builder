package com.greatlearning.bharatnewlibrary.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
//@NoArgsConstructor
@Builder
public class Student {
	
	int rno;
	String sname;
	double per;
	
	double height;
	int weight;
	String bloodGroup;
	
	int houseNo;
	int pinCode;
	String city;
	
//	public Student(int rno, String sname, double per)
//	{
//		this.rno=rno;
//		this.sname=sname;
//		this.per=per;
//	}
	
	public Student(int rno)
	{
		this.rno=rno;
	}
}
