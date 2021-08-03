package com.huawei.classroom.student.h04;

// 三角形
public class Triangle {
	private double a, b, c;

	public void setA(double A) {
		this.a = A;
	}

	public void setB(double B) {
		this.b = B;
	}

	public void setC(double C) {
		this.c = C;
	}

	public double getArea() {
		double s = (a + b + c) / 2;
		return Math.sqrt(s * (s - a) * (s - b) * (s - c));
	}
}