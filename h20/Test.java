package com.huawei.classroom.student.h20;

/**定义合适的类、接口，使得下面的代码编译并能正确运行*/
public class Test {

	public Test() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		A a = new D();
		C c = new D();
		D d = new D();
		 
		System.out.println("pass 1");
		
		B b = c;
		System.out.println("pass 2");
		
		a = d;
		System.out.println("pass 3");
		
		c=new E();
		System.out.println("pass 4");
		
		a=new A();
		if (!(a instanceof B)) {
			System.out.println("pass 5");
		}
		
		if (!(c instanceof A)) {
			System.out.println("pass 6");
		}
		if (!(c instanceof D)) {
			System.out.println("pass 7");
		}

	}
}
