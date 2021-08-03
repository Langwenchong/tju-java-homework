package com.huawei.classroom.student.h59;

import java.util.HashSet;
import java.util.Set;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 本文件中存放了若干的化学反应方程式（总数量不会超过1000个）
		String reactionFilename = "D://javacode/my_test/src/com/huawei/classroom/student/h59/reactions.txt";
		ReactionTools tool = new ReactionTools();
		Set<String> init = new HashSet<String>();
		init.add("HCl");
		init.add("NaOH");
		// init.add("Ca2+");
		Set<String> result = tool.findAllComponents(reactionFilename, init);
		Set<String> target = new HashSet<String>();
		target.add("HCl");
		target.add("NaOH");
		target.add("H+");
		target.add("OH-");
		target.add("H2O");
		target.add("Cl-");
		target.add("Na+");
		target.add("NaCl");
		// target.add("Ca2+");
		if (target.equals(result)) {
			System.out.println("pass!");
		}
		System.out.println(result);
	}

}
