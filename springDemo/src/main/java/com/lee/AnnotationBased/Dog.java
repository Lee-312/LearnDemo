package com.lee.AnnotationBased;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dog {
	private String name;

	@Override
	public String toString() {
		return "dog~";
	}

}



