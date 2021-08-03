package com.huawei.classroom.student.h57;

import java.io.File;

public class FileTool {

	/*
	 * 统计一个目录下所有文件大小的加和
	 */
	public long recursiveCalcFileSize(String homeDir) {
		int len = 0;
		File file = new File(homeDir);
		if (!file.isDirectory()) {
			// System.out.println(file.getName());
			len += file.length();
		} else {
			File[] list = file.listFiles();
			for (File f : list) {
				String s = f.getName();
				String path = homeDir + '/' + s;
				len += recursiveCalcFileSize(path);

			}
		}
		return len;
	}
}
