package com.huawei.classroom.student.h19.q02;

public class Test {

	public Test() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//在本包下增加合适的类，使得如下代码编译通过并正常运行
		// 本题目所有答案必须放在和本Test同级的目录下
		Person p=new Student("tom");
		if("tom".equals(p.getName())){
			System.out.println("ok q02");
		}
	}

}
