package com.huawei.classroom.student.h56;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileTool home = new FileTool();
		String homeDir = "D://javacode/my_test/src/com/huawei/classroom/student/h56/test_dir/";
		// 将一根目录下所有文本文件内容做替换，具体要求见 replaceTxtFileContent 方法
		// 此题目要求精确匹配答案
		home.replaceTxtFileContent(homeDir, "南开大学", "天津大学");
	}
}
