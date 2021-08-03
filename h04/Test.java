/**
 * 
 */
package com.huawei.classroom.student.h04;

/**
 * 
 * 根据本类的要求，构建类并设置合适的方法和属性
 * 
 * @author Administrator
 *
 */
public class Test {

	/**
	 * 
	 */
	public Test() {
		// TODO Auto-generated constructor stub
	}

	// 苹果
	static class Apple {
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

	// 三角形
	static class Triangle {
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

	// 栈
	static class MyStack {
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

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String color = "yellow";
		int size = 10;
		Apple app1 = new Apple();

		if (app1.getColor().equals("red")) {
			// 正确
			System.out.println("苹果是红色的");
		}

		Apple app2 = new Apple(size, color);
		if (app2.getColor().equals(color) && app2.getSize() == size) {
			// 正确
			System.out.println("苹果是黄色的并且大小为10");
		}

		// 定义三角形类
		Triangle tr = new Triangle();
		// 分别设置三角形a,b,c边长
		tr.setA(3);
		tr.setB(4);
		tr.setC(5);
		// 计算面积
		double area = tr.getArea();
		if (Math.abs(area - 6) < 0.001) {
			// 正确
			System.out.println("三角形面积正确");
		}

		// 请实现栈(stack)这种数据结构用来存放int
		// 并实现如下操作
		// Stack(int size) 构造函数 size为这个栈的可以容纳元素个数
		// int pop()
		// void push(int e)
		// boolean isEmpty()
		// boolean isFull()
		// 构造函数中的正整数为这个stack最大的元素个数，如果stack中元素个数达到这个则stack.isFull()==true
		MyStack stack = new MyStack(3);
		// 正确
		if (stack.isEmpty()) {
			// 正确
			System.out.println("栈是空的");
		}
		stack.push(1);
		stack.push(4);
		stack.push(5);
		// push了3个元素，对应 stack=new MyStack(3)
		if (stack.isFull()) {
			// 正确
			System.out.println("栈是满的");
		}
		if (stack.pop() == 5) {
			// 正确
			System.out.println("栈返还了5");
		}
		if (!stack.isFull()) {
			// 正确
			System.out.println("栈不是满的");
		}
	}

}
