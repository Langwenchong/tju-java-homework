package com.huawei.classroom.student.h08;

public class AgeCheck implements AgeCheckInterface {

	public void checkAge(int age) {
		if (age < 0 || age > 200) {
			throw new RuntimeException();
		}
	}

}
