package com.huawei.classroom.student.h08;

/**
 * 在本包下增加合适的类和方法,并完善TypeValidator类，使得Test类能够测试通过 不能通过修改Test的代码使得测试通过
 * 
 * 不要引用jdk1.8以外第三方的包
 * 
 * @author cjy
 *
 */
public class Test5 {

	public Test5() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		TypeValidator v = new TypeValidator();
		// 完成TypeValidatord 的 validate方法
		// 如果validate输入参数是字符串类型，则不报任何异常
		// 如果输入参数不是字符串类型，必须抛出异常
		v.validate("abc");
		System.out.println("做对了第1步");
		// 做对第1步
		try {
			// 非字符串类型， 抛出异常
			v.validate(123);

		} catch (Exception e) {
			System.out.println("做对了第2步");
			// 做对第2步
		}
	}
}
