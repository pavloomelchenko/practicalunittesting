package com.mycompany.put.other;

public class SystemPropsModifier {
	public static final String KEY = "myKey";

	public void modify() {
		System.getProperties().setProperty(KEY, "myNewValue");
	}
}
