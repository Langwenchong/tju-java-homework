package com.huawei.classroom.student.h08;

/**
 * 在本包下增加合适的类和方法，使得Test类能够测试通过
 * 不能通过修改Test的代码使得测试通过
 * 不要引用jdk1.8以外第三方的包
 * 
 * @author cjy
 *
 */
 
public class Test2 {

	public Test2() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LoginUtil loginUtil = new LoginUtil();
		try {
			// LoginUtil是一个登录的类，分别输入用户口令，当用户名为"a",口令为"a",不抛出异常，否则抛出InvalidUserExcetpion(InvalidUserExcetpion需要你自己定义)
			loginUtil.login("a", "a");
			System.out.println("做对了第1步");
			// 作对第1步
			loginUtil.login("b", "b");
			// 如果程序还能执行到这里 就要扣分了

		} catch (InvalidUserExcetpion e) {
			System.out.println("做对了第2步");
			// 做对了第2步

		}
	}

}
