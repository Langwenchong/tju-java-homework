package com.huawei.classroom.student.h55;

public class Test {

	public static void main(String[] args) {

		// TODO Auto-generated constructor stub
		PoetryAnalysis util = new PoetryAnalysis();
		/**
		 * 用计算机来证明 为什么说李白是浪漫主义诗人 杜甫是现实主义诗人 分析不同诗人使用一些汉字时候的特点
		 * 
		 * 1 分析不同诗人使用一个汉字的时候，将这些汉字组成什么词汇使用在诗句里面 2按这些词汇出现的频率高低排序； 3只要是两个汉字连起来就视为一个词。
		 * 
		 * 此题目不要求精确匹配答案，甚至不要求返回结果，自己输出结果和参考答案对比一下就行 注意：因为每个人程序实现稍微有所区别（例如对标点 空格 处理的不同
		 * )，所以本文件给出的答案仅供参考 注意： 本题目批改的时候 只要可以编译通过并运行就可以，不评判具体返回字符等
		 */
		// chars 若干汉字组成的字符串以;分割，1统计这些汉字组成什么词汇出现在诗句里面，2按这些词汇出现的频率高低排序；3只要是两个汉字连起来就视为一个词
		String chars = "春;夏;秋;冬;暑;寒;风;雨;雪;霜;露";

		util.analysis("D://javacode/my_test/src/com/huawei/classroom/student/h55/libai.txt", chars);
		util.analysis("D://javacode/my_test/src/com/huawei/classroom/student/h55/dufu.txt", chars);
		// 春;夏;秋;冬;暑;寒;风;雨;雪;霜;露 是几个和季节有关的词汇，李白和杜甫在高频词上有所不同，李白喜欢 春风 风吹 秋月 ，杜甫喜欢 风尘 秋风
		// 参考运行结果，仅供参考
		// 李白 杜甫
		// 词汇 频率 词汇 频率
		// 春风 72 风尘 48
		// 风吹 51 秋风 30
		// 秋月 40 风吹 28
		// 清风 28 天寒 27
		// 秋风 25 清秋 25
		// 东风 24 春色 20
		// 白雪 21 春风 19
		// 秋浦 21 风雨 17
		// 长风 21 云雨 16
		// 秋霜 20 高秋 16
		chars = "醉;酒;饮;杯";
		util.analysis("D://javacode/my_test/src/com/huawei/classroom/student/h55/libai.txt", chars);
		util.analysis("D://javacode/my_test/src/com/huawei/classroom/student/h55/dufu.txt", chars);
		// 参考运行结果，仅供参考，李白喝酒比杜甫多 而且酒量也比杜甫大
		// 李白 杜甫
		// 词汇 频率 词汇 频率
		// 美酒 27 酒酣 10
		// 一杯 21 杯酒 7
		// 杯酒 14 嗜酒 6
		// 对酒 13 痛饮 6
		// 三杯 11 醉眠 6
		// 斗酒 11 对酒 5
		// 杯中 8 春酒 5
		// 置酒 8 杯中 5
		// 饮酒 8 酒杯 5
		// 衔杯 7 酒肉 5
		chars = "东;西;南;北";
		util.analysis("D://javacode/my_test/src/com/huawei/classroom/student/h55/libai.txt", chars);
		util.analysis("D://javacode/my_test/src/com/huawei/classroom/student/h55/dufu.txt", chars);
		// 参考运行结果，仅供参考，李白更喜欢东风 杜甫总是想到北风
		// 李白 杜甫
		// 词汇 频率 词汇 频率
		// 东风 24 西南 15
		// 东海 23 北斗 14
		// 东山 20 北风 14
		// 东流 19 东西 13
		// 南山 19 东流 12
		// 西来 16 南国 12
		// 东南 12 南征 11
		// 北斗 12 西江 11
		// 东方 10 山东 9
		// 北海 10 瀼西 9

		// 大家可以分析别的词汇，用计算机来证明 为什么说李白是浪漫主义诗人 杜甫是现实主义诗人
	}

}
