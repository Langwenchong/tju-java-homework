/**
 * 
 */
package com.huawei.classroom.student.h15;

import java.util.List;

/**
 * 在本包下增加合适的类和方法，使得Test类能够测试通过
 * 
 * 不要引用jdk1.8以外第三方的包
 * 
 * @author cjy
 *
 */
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			StringBuffer buf = new StringBuffer();
			/**
			 * 作业一 测试程序输入一个StringBuffer，刚输入的时候StringBuffer值为空
			 * 等待1000ms后，这个StringBuffer的值变为"ok"
			 */
			ThreadUtil threadUtil = new ThreadUtil(buf);
			threadUtil.start();
			if (buf.length() > 0) {
				System.out.println("第一小题 错误,现在不能给buf值必须为空");
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (buf.toString().equalsIgnoreCase("ok")) {
				System.out.println("第一小题 正确，测试程序在休眠1000毫秒以后，需要从buf中得到\"ok\"值");
			}
			/**
			 * 作业二，多线程方式，统计[start,end)区间所有的质数，并且小到大排序返回
			 */

			PrimeUtil util = new PrimeUtil();
			// 测试的时候 start、end、threadCount都有可能变化
			long start = 1000000L;// 测试的时候可能为大于2的任何一个整数
			long end = start * 2;// 测试的时候 可能为大于start的任何一个整数
			int threadCount = 4;// 测试的时候取值可能为[1,20]之间
			long l = System.currentTimeMillis();
			// 多线程计算
			List<Long> list = util.getPrimeList(start, end, threadCount);
			// 要求算法具有一定的效率速度
			long cost = (System.currentTimeMillis() - l);
			System.out.println(cost + "耗时 " + cost + " ms! 参考：Intel I5-7200U 耗时700ms 左右!");
			if (cost > 1500) {
				System.out.println("计算速度太慢或者使用了电池供电， 请设法优化你的程序或者请在使用外接电源情况下跑你的程序！");
			}
			// 测试的时候，会随机的从list中检查一些结果，本例子检查的是0,10001,20001...位置的质数
			long[] result = { 1000003, 1138589, 1278481, 1420121, 1561801, 1705141, 1849319, 1993921 };
			int j = 0;
			boolean flag = true;
			for (int i = 0; i < list.size(); i = i + 10000) {
				if (result[j] != list.get(i)) {
					System.out.println(list.get(i));
					System.out.print("第" + i + "个质数错误!");
					flag = false;
				}
				j++;
			}
			if (flag) {
				System.out.println("第二小题测试正确");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
