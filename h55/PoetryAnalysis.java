package com.huawei.classroom.student.h55;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PoetryAnalysis {

	/**
	 * 
	 * @param pathFilename
	 *            包含诗歌内容的源文件
	 * @param chars
	 *            需要统计的字 以半角分号分割 统计
	 * 
	 */
	Map<String, Integer> map = new HashMap();
	Set<String> set = new HashSet();

	public void analysis(String pathFilename, String chars) {
		map.clear();
		String s = readFromTxt(pathFilename);
		// System.out.println(s);
		char[] arr = s.toCharArray();
		// System.out.println(arr);
		String[] ref = chars.split(";");
		// System.out.println(ref[1]);
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < ref.length; j++) {
				String s1 = "";
				String s2 = "";

				if (String.valueOf(arr[i]).equals(ref[j])) {
					if (arr[i - 1] != '，' && arr[i - 1] != '。') {
						s1 = "" + arr[i - 1] + arr[i];
						ckeck(s1);
					}
					if (arr[i + 1] != '，' && arr[i + 1] != '。') {
						s2 = "" + arr[i] + arr[i + 1];
						ckeck(s2);
					}
				}
			}
		}
		int n = 10;
		while (n > 0) {
			// 初始化
			int maxn = -1;
			String maxKey = null;
			// 遍历map，每次都找到唯一一个最高频率的词语
			for (String key : this.map.keySet()) {
				// 特判这些情况跳过
				// 记录当前最高频词语
				if (this.map.get(key) > maxn) {
					maxn = this.map.get(key);
					maxKey = key;
				}
			}
			String ans = maxKey + String.valueOf(map.get(maxKey));
			System.out.println(ans);
			map.remove(maxKey);
			n--;
		}
	}

	private void ckeck(String s) {
		// TODO Auto-generated method stub
		if (this.map.containsKey(s)) {
			int num = map.get(s);
			num += 1;
			map.put(s, num);
		} else {
			map.put(s, 1);
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
