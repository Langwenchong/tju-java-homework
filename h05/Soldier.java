package com.huawei.classroom.student.h05;

public class Soldier {
	public int health = 50;
	private static int livingSoldierCount;
	private static int deadedSoldierCount;

	public Boolean isDestroyed() {
		if (this.health <= 0) {
			return true;
		} else
			return false;
	}

	public int getHealth() {
		return this.health;
	}

	public static int getLivingSoldierCount() {
		return livingSoldierCount;
	}

	public static int getDeadedSoldierCount() {
		return deadedSoldierCount;
	}

	public static void subLivingSoldierCount() {
		livingSoldierCount--;
		deadedSoldierCount++;
	}

	public static void addLivingSoldierCount() {
		livingSoldierCount++;
	}
}