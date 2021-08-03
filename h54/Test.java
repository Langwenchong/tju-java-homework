package com.huawei.classroom.student.h54;

/**
 * 判断复杂口令
 * @author Administrator
 *
 */
public class Test {
	public static void main(String[] args) {
		PasswordChecker home = new PasswordChecker();
		//判断一个字符串是否是一个合法的口令，合法口令要求见 isValidPassword 方法
		//此题目要求精确匹配答案
		if(!home.isValidPassword("qwert12345")) {
			System.out.println("pass 1");
		}
		if( home.isValidPassword("Qwer%t12345")) {
			System.out.println("pass 2");
		}
	}
}
