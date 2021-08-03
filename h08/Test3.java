package com.huawei.classroom.student.h08;

/**
 * 在本包下增加合适的类和方法,并完善Bank类，使得Test类能够测试通过 不能通过修改Test的代码使得测试通过 不要引用jdk1.8以外第三方的包
 * 
 * @author cjy
 *
 */

public class Test3 {

	public Test3() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Bank bank = new Bank();
		try {
			// 完成此操作后余额100
			bank.save(100);
			// 完成此操作后余额400
			bank.save(300);

			// 完成此操作后余额200
			bank.get(200);
			// 作对第1步
			System.out.println("做对了第1步");
			// 余额不足，应该抛出异常了
			bank.get(300);

		} catch (NoMoneyException e) {
			System.out.println("做对了第2步");
			// 做对了第2步

		}
	}
}
