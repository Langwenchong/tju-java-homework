package com.huawei.classroom.student.h08;

public class LoginUtil {
	public void login(String s1, String s2) throws InvalidUserExcetpion {
		if (s1.equals("a") && s2.equals("a")) {
			return;
		} else {
			throw new InvalidUserExcetpion();
		}
	}
}
