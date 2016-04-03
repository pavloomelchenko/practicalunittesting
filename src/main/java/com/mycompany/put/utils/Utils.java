package com.mycompany.put.utils;

import org.apache.commons.lang3.StringUtils;

public class Utils {
	public static String name(String input){
		String[] arr = input.split(" ");
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < arr.length; i++) {
			String s = arr[i];
			if (i != 0){
				s = StringUtils.capitalize(s);
			}
		    builder.append(s);
		}
		return builder.toString();
	}
}
