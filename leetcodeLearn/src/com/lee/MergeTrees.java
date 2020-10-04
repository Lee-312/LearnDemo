package com.lee;

import java.util.HashMap;
import java.util.Map;

public class MergeTrees {
	public static void main(String[] args) {
		System.out.println(numJewelsInStones("z", "ZZ"));
	}

	public static int numJewelsInStones(String J, String S) {
		Map<Character, Integer> map = new HashMap();
		char[] chars = S.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			map.put(chars[i], map.getOrDefault(chars[i], 0) + 1);
		}
		int count =0;
		char[] chars1 = J.toCharArray();
		for (int i = 0; i < chars1.length; i++) {
			if(map.get(chars1[i]) != null){
				count += map.get(chars1[i]);
			}
		}
		return count;
	}

}
