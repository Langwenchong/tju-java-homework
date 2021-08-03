/**
 * 
 */
package com.huawei.classroom.student.h19.q05;

import java.util.Arrays;
import java.util.List;

/**
 * @author cjy
 *
 */
public class Test {

	public static void main(String[] args) {
		// 本题目所有答案必须放在和本Test同级的目录下
		/**
		 * 完成StudentUtilB ，使其具有如下功能
		 * 
		 * 一个文本文件中学生姓名,科目,单科成绩;(见score.txt) (这个文件肯定是UTF-8编码)
		 * 将所有学生按总成绩从高到低排名，总成绩不会出现相同的情况
		 */
		// 本地测试的时候要根据情况修改这个文件名
		// String fileName =
		// "D:\\javacode\\my_test\\src\\com\\huawei\\classroom\\student\\h19\\q05\\score.txt";
		String fileName = "D:\\javacode\\my_test\\src\\com\\huawei\\classroom\\student\\h19\\q05\\score.txt";
		// String fileName2 =
		// "D:\\javacode\\my_test\\src\\com\\huawei\\classroom\\student\\h19\\q05\\score2.txt";
		StudentUtil util = new StudentUtil();
		// StudentUtil util2 = new StudentUtil();
		// 将所有学生姓名按总成绩从高到低排名，如果成绩并列则按语文从高到低排列，
		// 如果语文成绩也相同，则按数学由高到低排列，如果数学成绩也相同，则按英语由高到低排列（不会出现总分相同&&语文相同&&数学相同&&英语相同情况)

		List<String> list = util.sort(fileName);
		List result = Arrays.asList("张三", "李四", "赵六", "王五");
		if (result.equals(list)) {
			System.out.println("测试1 通过");
		}
		// System.out.println(util.sort(fileName));
		// list = util.sort(fileName2);
		// List result2 = Arrays.asList("zhangsan", "lisi", "wangwu", "zhaoliu");
		// if (result2.equals(list)) {
		// System.out.println("测试2 通过");
		// }
		// System.out.println(util.sort(fileName2));
	}

}
