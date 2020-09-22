package com.lee.AnnotationBased;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {

	@Autowired
	private Cat cat;
	@Autowired
	private Dog dog;
	private String name;

	@Override
	public String toString(){
		return "I have a Cat  "+cat.toString()+" and I have a Dog  "+ dog.toString();
	}

}
