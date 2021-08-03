package com.huawei.classroom.student.h08;

/**
 * 在本包下增加合适的类和方法,使得Test类能够测试通过
 * 不能通过修改Test的代码使得测试通过,不能修改AgeCheckInterface中的任何代码
 *  
 * 不要引用jdk1.8以外第三方的包
 * 
 * @author cjy
 *
 */

public class Test4 {

	public Test4() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		 
		// 构造一个 AgeCheck类，实现AgeCheckInterface接口，
		// 当checkAge中的参数<0或者>200的时候抛出异常，
		// 注意，不许对AgeCheckInterface做任何修改
		//交作业的时候 AgeCheckInterface 也一并交上来
		AgeCheckInterface ageCheck = new AgeCheck();
		ageCheck.checkAge(10); 
			// 做对了 第一步
		System.out.println("做对了第1步");
		try {
			ageCheck.checkAge(-10);
		} catch (Exception e) {
			// 做对了第二步
			System.out.println("做对了第2步");
		}
	}

}
