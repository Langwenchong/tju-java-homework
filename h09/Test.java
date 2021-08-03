package com.huawei.classroom.student.h09;

/**
 * 
 * 
 * 不要引用jdk1.8以外第三方的包
 * 
 * @author cjy
 *
 */
public class Test {

	public Test() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {

		// TODO Auto-generated method stub
		// 完成Home09的代码 使得下列代码能够编译 并且通过测试用例
		Home09 util = new Home09();
		if (util.getDistinctCharCount("天津市天津大学") == 5) {
			// getDistinctCharCount ok
			System.out.println("ok1");
		}
		if (util.getFrequentChar("我是天津大学软件学院学生") == '学') {
			// getFrequentChar ok
			System.out.println("ok2");
		}

		if (util.getFrequentWord("天津市天津大学").equals("天津")) {
			// getFrequentWord ok
			System.out.println("ok3");
		}

		StringBuffer buf = new StringBuffer("a b c ");
		util.zipStringBufer(buf);
		if (buf.toString().equals("abc")) {
			// zipStringBufer ok
			System.out.println("ok4");
		}
	}

}
