
package com.huawei.classroom.student.h13;

import java.io.Closeable;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 在本包下增加合适的类和方法，使得Test类能够测试通过
 * 
 * 不要引用jdk1.8以外第三方的包
 * 
 * @author cjy
 *
 */
public class Analysis {
	// chapters记录各章回的内容
	private String[] chapters = null;
	// map统计每一个词语的出现频率
	private Map<String, Integer> map = null;
	// list存放前n个高频词语
	private List<String> words = null;

	/**
	 * @throws Exception
	 * 
	 */
	public Analysis(String filename) throws Exception {
		// 调用写好的分120章回的函数得到0~120章回的内容数组
		this.chapters = splitContentToChapter(readFromTxt(filename));
		// 没有第0章回，需要去掉
		this.chapters = Arrays.copyOfRange(this.chapters, 1, this.chapters.length);
	}

	/**
	 * 提示 ：将一个文本文件读取到一个字符串中返回
	 * 
	 * @param filename
	 *            红楼梦文本文件的全路径名
	 * @return 文本的内容
	 */
	private String readFromTxt(String filename) throws Exception {
		Reader reader = null;
		try {
			StringBuffer buf = new StringBuffer();
			char[] chars = new char[1024];
			// InputStream in=new FileInputStream(filename);

			reader = new InputStreamReader(new FileInputStream(filename), "UTF-8");
			int readed = reader.read(chars);
			while (readed != -1) {
				buf.append(chars, 0, readed);
				readed = reader.read(chars);
			}
			return buf.toString();
		} finally {
			close(reader);
		}
	}

	/**
	 * 返回红楼梦中出现频率最高的N个次，频率从高到低排列（所谓词就是两个相邻的汉字）
	 * 
	 * @param n
	 * @return
	 */
	public List<String> getTopNWords(int n) {
		// 初始化
		String s = new String();
		this.map = new LinkedHashMap();
		this.words = new LinkedList();
		// 遍历每一个章节的内容
		for (String chp : chapters) {
			// 获取词语,
			for (int i = 0; i + 1 < chp.length(); i++) {
				// 注意实际取的是两个字符组成的词语i-i+1
				s = chp.substring(i, i + 2);
				// map统计词语频率
				if (this.map.containsKey(s)) {
					int number = map.get(s);
					this.map.put(s, number + 1);
				} else
					this.map.put(s, 1);
			}
		}
		// 寻找前N个高频词语
		while (n > 0) {
			// 初始化
			int maxn = -1;
			String maxKey = null;
			// 遍历map，每次都找到唯一一个最高频率的词语
			for (String key : this.map.keySet()) {
				// 特判这些情况跳过
				if (key.contains("：") || key.contains("，") || key.trim().equals("") || key.contains("。")
						|| key.contains("．") || key.contains("？")) {
					continue;
				}
				// 记录当前最高频词语
				if (this.map.get(key) > maxn) {
					maxn = this.map.get(key);
					maxKey = key;
				}
			}
			// 添加到words中，所以words是降序频率的词语，并且排名为top1-topN
			this.words.add(maxKey);
			// 将这个词语移除
			this.map.remove(maxKey);
			// 找下一个次高频词语
			n--;
		}
		return this.words;
	}

	/**
	 * 关闭输入输入流
	 * 
	 * @param inout
	 */
	private void close(Closeable inout) {
		if (inout != null) {
			try {
				inout.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * 提示 将红楼梦文本文件拆分为120个章节的方法
	 * 
	 * @param content
	 * @return 返回120个元素的字符串数组
	 */
	private String[] splitContentToChapter(String content) {
		// 提示 使用 content.split(" 第[一,二,三,四,五,六,七,八,九,十,零]{1,5}回 ");正则表达拆分
		// 百度一下正则表达式
		String contents[] = content.split(" 第[一,二,三,四,五,六,七,八,九,十,零]{1,5}回 ");
		return contents;
	}

	/**
	 * 统计红楼梦章节字符串str出现的频率
	 * 
	 * @param str
	 * @return
	 * @throws Exception
	 */
	public int[] getStringFrequent(String str) throws Exception {
		// 共120张，对每一章统计一遍str
		int[] a = new int[120];
		// 第几章回
		int chpIndx = -1;
		// 某一章回中已找到内容字符串的第几位置
		int tmp = 0;

		// 遍历每一章回
		for (String chp : this.chapters) {
			// 随便定义不为-1即可
			int index = 99;
			// 从第0章回开始
			chpIndx++;
			// 从本章的第一个字符开始寻找
			tmp = 0;
			// 不为-1说明又找到了一个str
			while (index != -1) {
				// 返还找到的str的首字符位置
				index = chp.indexOf(str, tmp);
				// 本章回str出现的频率+1
				a[chpIndx]++;
				// 下一次从index+1开始找
				tmp = index + 1;
			}
			// 多数了一次，减去一次
			a[chpIndx]--;
		}
		return a;
	}

}
