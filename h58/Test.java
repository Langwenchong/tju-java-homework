package com.huawei.classroom.student.h58;

import java.util.Map;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		VoteRecord vote = new VoteRecord();
		long l = System.currentTimeMillis();

		/**
		 * fileName是一个投票的明细记录，里面逐行存放了 投票的时间（yyyy-MM-dd HH:mm:ss 格式） +\t+投票的微信ID+\t+候选人
		 * 存放按时间递增（但是可能出现同一秒出现若干条记录的情况） 现在需要完成投票统计的过程，具体要求如下： 1个微信ID 1分钟内 最多投1票 多余的票数无效;
		 * 1个微信ID 10分钟内 最多只能投5票 多余的票无效;其中微信ID不固定，候选人姓名不固定 测试的时候要求10万行记录处理时间不超过3秒
		 */
		Map<String, Integer> map = vote
				.calcRecording("D://javacode/my_test/src/com/huawei/classroom/student/h58/vote_detail.txt");
		// "xxxx/vote_detail.txt");

		System.out.println(map);
		System.out.println(System.currentTimeMillis() - l + " ms cost!");
		// 参考答案如下，答案要求误差控制在 20%以内
		// wang 6191
		// zhao 12607
		// zhang 6308
		// li 6267
	}

}
