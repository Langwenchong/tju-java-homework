package com.huawei.classroom.student.h15;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//不会吧不会把，你这道题居然不会~
//这没手都行吗~
public class PrimeUtil {
	public long start;
	public long end;
	public int threadCount;

	// 最后返还的存储从小到大排序质数的list
	public List<Long> list = new ArrayList<>();

	public List getPrimeList(long start, long end, int threadCount) {
		// 初始化
		this.start = start;
		this.end = end;
		this.threadCount = threadCount;
		PrimeThread[] threads = new PrimeThread[threadCount];
		for (int i = 0; i < threads.length; i++) {
			// 创建thredCount个线程并未每一个线程分配工作范围
			long threadStart = start + (end - start) / threadCount * i;
			long threadEnd = start + (end - start) / threadCount * (i + 1);
			// System.out.println("thread " + i + ": " + threadStart);
			// System.out.println("thread " + i + ": " + threadEnd);
			threads[i] = new PrimeThread(threadStart, threadEnd);
			threads[i].start();
		}
		for (int i = 0; i < threads.length; i++) {
			try {
				// 等待每一个线程的结束
				threads[i].join();
				// 获取每一个线程检索那部分的结果list
				// System.out.println(threads[i].list);
				List<Long> tmp = threads[i].getList();
				// 加到总答案list列表中，这也是使用ArrayList的原因
				list.addAll(tmp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		Collections.sort(list);
		// System.out.println(list);
		return list;
	}

}
