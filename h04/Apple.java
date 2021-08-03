package com.huawei.classroom.student.h04;

//苹果
public class Apple {
	private String color;
	private int size;

	public String getColor() {
		return this.color;
	}

	public int getSize() {
		return this.size;
	}

	public Apple() {
		this.color = "red";
	}

	public Apple(int size, String color) {
		this.color = color;
		this.size = size;
	}
}