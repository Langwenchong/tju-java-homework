package com.huawei.classroom.student.h61;

public class Util {

	// 随机产生一个随机数，是否小于概率，如果小于那么很不幸
	// 实际上无论是哪个情况的计算模拟，都只是产生一个随机数....
	public static boolean getProbability(double probability) {
		return Math.random() < probability;
	}

	public static int getIntRand(int max) {
		return (int) (Math.random() * max);
	}
}
