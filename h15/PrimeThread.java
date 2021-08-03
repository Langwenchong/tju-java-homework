package com.huawei.classroom.student.h15;

import java.util.ArrayList;
import java.util.List;

//这你居然也看？？？
//这不就是爆搜吗？？？
public class PrimeThread extends Thread {
	public List<Long> list = new ArrayList<>();
	public long start;
	public long end;

	public PrimeThread(long start, long end) {
		this.start = start;
		this.end = end;
	}

	public List<Long> getList() {
		return this.list;
	}

	@Override
	public void run() {
		for (long i = start; i < end; i++) {
			boolean v = true;
			for (long j = 2; j <= Math.sqrt(i); j++) {
				if (i % j == 0) {
					v = false;
					break;
				}
			}
			if (v) {
				list.add(i);
			}
		}
	}
}
