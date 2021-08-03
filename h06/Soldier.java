package com.huawei.classroom.student.h06;

public class Soldier extends GameBase {
	private static int livingSoldierCount;
	private static int deadedSoldierCount;

	public Soldier() {
	};

	public Soldier(int health, int atk, int len, int x, int y) {
		super(health, atk, len, x, y);
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
