package com.lee;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.StringJoiner;

public class ReverseWords {

	public static void main(String[] args) {
		System.out.println(reverseWords("Let's take LeetCode contest"));
	}

	public static String reverseWords(String s) {
		StringBuffer str = new StringBuffer();
		String[] split = s.split(" ");
		for (int i = 0; i < split.length; i++) {
			str.append(new StringBuffer(split[i]).reverse());
			if(i != split.length-1){
				str.append(" ");
			}
		}
		return str.toString();
	}

}
