/**
 * 
 */
package com.huawei.classroom.student.h13;

import java.util.List;

/**
 * 实验一
 *
 */
public class Test {

	/**
	 * 
	 */
	public Test() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/*
		 * 
		 * 现在有一个文本文件red.txt（其格式和内容见red.txt)里面存放了红楼梦120回的内容,
		 * 请完成Analysis类，增加完成适当的方法，使得该程序可以完成如下功能： 1
		 * 统计任意词在红楼梦中每回出现的频率。getStringFrequent(str) 2
		 * 不考虑空格、回车、所有标点符号、制表符的情况下，统计整个红楼梦中topN的两个字的组合。 getTopNWords(n) 参考的输出结果见：参考运行结果
		 * 提示：Analysis中已经有了readFromTxt（不要修改这个方法，否则可能在你的电脑上读出的不乱码，在我的电脑上读出乱码）
		 * 和讲红楼梦拆分为120回的方法。 将小说分成120个章节的时候，不用过分纠结小说中的干扰字符，例如： 手机电子书·大学生小说网.......
		 * 更新时间:2006-7-26 11:43:00 本章字数:6394 等等
		 * 
		 */

		try {
			// 测试的时候，红楼梦文件名，这个文件名不固定，测试的时候可能在别的位置
			String filename = "D:\\test\\java\\com\\huawei\\classroom\\student\\h13\\red.txt";
			// 使用文件名初始化Analysis类
			Analysis analysis = new Analysis(filename);
			// 要统计的汉字，测试的时候不固定，可能统计任意的汉字
			// 通过统计 "之" 在每回中出现的频率，你是否能感觉到前80章 和后40章的写作风格不同
			// 再看看 从多少回开始，贾府中的笑声开始减少了
			String[] strs = { "笑道", "之" };
			for (String str : strs) {
				int[] counts = analysis.getStringFrequent(str);
				if (counts.length != 120) {
					System.out.println("拆分的章节数量不对");
				}
				for (int i = 0; i < counts.length; i++) {
					System.out.println("第" + (i + 1) + " 回 出现   " + str + " 次数=" + counts[i]);
				}
			}
			List<String> top = analysis.getTopNWords(10);
			for (int i = 0; i < top.size(); i++) {
				System.out.println(top.get(i));
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

	}

}
