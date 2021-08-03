package com.huawei.classroom.student.h61;


//新建Util类计算概率
public class myUtil {

	//模拟方法为
	/*
	 * 使用Math.random()函数生成随机数
	 * 知道这个数大于给定概率，则说明这个事件发生
	 * 反之不发生
	 */
	public static boolean getPossibility(double possibility) {
		return Math.random()<possibility;
	}
	//得到一个小于max的int型的随机数
	public static int getIntRandom(int max) {
		return (int)(Math.random()*max);
	}
}
