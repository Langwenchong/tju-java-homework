/**
 * 
 */
package com.huawei.classroom.student.h53;

/**
 * @author Administrator
 *
 */
public class RabbitCount {

	/**
	 * 1对兔子出生以后经过180天可以生出一窝（2对）兔子，以后每隔90天繁殖一次生出一窝（2对）兔子 每对兔子的寿命是700天
	 * 
	 * @param startCount
	 *            第0天 开始的时候初生的兔子对数
	 * @param months
	 *            经过的天份数
	 * @return 目前系统中存活的兔子的对数
	 */
	// 一代兔子数量，和距离预期时间的剩余时间
	public int getLivingRabbit(int startCount, int days) {
		// 数量
		int num = 0;
		// 死亡时间
		int ddl = days - 700;
		// 如果days<=700，那么这批兔子可以活到统计日期
		if (days <= 700)
			num += startCount;
		// 是否是第一窝
		boolean flag = false;
		// 是第一窝，且days还有180天
		if (!flag && days >= ddl && days - 180 >= 0) {
			num += getLivingRabbit(2 * startCount, days - 180);
			days -= 180;
			flag = true;
		}
		// 没死之前一直生
		while (flag && days >= ddl && days - 90 >= 0) {
			num += getLivingRabbit(2 * startCount, days - 90);
			days -= 90;
		}
		return num;
	}
}
