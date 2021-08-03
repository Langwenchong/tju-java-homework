package com.huawei.classroom.student.h08;

public class Dog {
	private int max = 0;

	public void feed() throws Exception {
		this.max++;
		if (this.max > 3) {
			throw new Exception("I can not eat more!");
		}
	}
}
