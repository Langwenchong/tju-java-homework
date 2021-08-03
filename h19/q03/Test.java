package com.huawei.classroom.student.h19.q03;

public class Test {
 

	/**
	 * 
	 */
	public Test() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 完成ArrayUtil，使得下面的测试用例通过
		// 本题目所有答案必须放在和本Test同级的目录下
		ArrayUtil util=new ArrayUtil();
		int[] case1= {11,34,1,56,9};
		//getMin 返回整数数组中 中最小的数值
		if(util.getMin(case1)==1) {
			System.out.println("test case1 ok!");
		} 
	}

}
