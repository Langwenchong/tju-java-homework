package com.huawei.classroom.student.h19.q04;

public class Test {

	public Test() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		//完成StrUtil类，其中的removeDulpicatedChar()方法可以去掉一个字符串中的重复字符，重复出现的字符只保留一个，并仍然按原来的顺序输出
		// 本题目所有答案必须放在和本Test同级的目录下
		StrUtil util=new StrUtil();
		if(util.removeDulpicatedChar("aabbac").equals("abc")) {
			System.out.println("test case1 ok!");
		}
	}
}
