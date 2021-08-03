/**
 * 
 */
package com.huawei.classroom.student.h53;

/**
 * @author Administrator
 *
 */
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 兔子繁殖问题
		// 此题目结果不要求精确匹配
		// 兔子早上生 还是晚上生  对结果会有影响,此题目要求误差不超过20% 
		//result.txt供参考，不需要同学们输出result.txt
		RabbitCount  home = new RabbitCount ();
		int target=41324;
		//日期不会超过2000
		//要求1对兔子 日期不超过2000的时候，计算时间不超过5000ms
		  
		int count = home.getLivingRabbit(1, 1500);
		System.out.println(count);
		if(Math.abs( 1-count*1.0/target)<0.2) {
			System.out.println("pass ");
		}
		 
		 
	}

}
