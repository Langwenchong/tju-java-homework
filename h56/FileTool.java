/**
 * 
 */
package com.huawei.classroom.student.h56;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;

/**
 * @author Administrator
 *
 */
public class FileTool {

	/**
	 * 将homeDir 目录下（包括子目录）所有的文本文件（扩展名为.txt，扩展名不是.txt的文件不要动，扩展名区分大小写) 文件中，orgStr替换为
	 * targetStr 所有文本文件均为UTF-8编码 例如将某个目录中所有文本文件中的 南开大学 替换为 天津大学
	 * 
	 * @param homeDir
	 * @param orgStr
	 * @param targetStr
	 */
	public void replaceTxtFileContent(String homeDir, String orgStr, String targetStr) {
		File file = new File(homeDir);
		if (!file.isDirectory()) {
			Operate(homeDir, orgStr, targetStr);
		} else {
			File[] list = file.listFiles();
			for (File f : list) {
				String s = f.getName();
				String path = homeDir + '/' + s;
				if (f.isDirectory() || s.endsWith("txt")) {
					replaceTxtFileContent(path, orgStr, targetStr);
				}
			}
		}
	}

	private void Operate(String file, String orgStr, String targetStr) {
		// TODO Auto-generated method stub
		// System.out.println(file + " ok");
		String s = readFromTxt(file);

		String content = s.replace(orgStr, targetStr);
		try {
			OutputStream out = new FileOutputStream(file);
			// System.out.println(content);
			out.write(content.getBytes());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private String readFromTxt(String filename) {
		Reader reader = null;
		try {
			StringBuffer buf = new StringBuffer();
			char[] chars = new char[1024];
			// InputStream in=new FileInputStream(filename);

			reader = new InputStreamReader(new FileInputStream(filename));
			int readed = reader.read(chars);
			while (readed != -1) {
				buf.append(chars, 0, readed);
				readed = reader.read(chars);
			}
			reader.close();
			return buf.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
}
