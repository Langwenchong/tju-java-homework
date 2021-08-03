package com.huawei.classroom.student.h15;

public class ThreadUtil extends Thread {
	public StringBuffer sb;

	public ThreadUtil(StringBuffer sb) {
		this.sb = sb;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(500);
			// 在这里给sb即buf赋值ok即可，有手就行啊拆~
			sb.append("ok");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
