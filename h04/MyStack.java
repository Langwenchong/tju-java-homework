package com.huawei.classroom.student.h04;

// 栈
public class MyStack {
	private int size;
	private int i = 0;
	private int stack[];

	public MyStack(int size) {
		this.size = size;
		stack = new int[size];
	}

	public Boolean isEmpty() {
		if (i == 0)
			return true;
		else
			return false;
	}

	public Boolean isFull() {
		if (i == size)
			return true;
		else
			return false;
	}

	public int pop() {
		if (i == 0) {
			System.out.println("No element!");
			return -1;
		} else {
			i--;
			return stack[i];
		}
	}

	public void push(int e) {
		stack[i] = e;
		i++;
	}
}