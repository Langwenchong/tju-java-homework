package com.huawei.classroom.student.h07;

public abstract class Soldier extends GameObject {

	public static int livingSoldierCount = 0;
	public static int deadedSoldierCount = 0;

	public Soldier() {
	};

	public Soldier(int health, int strength, int range, int x, int y) {
		super(health, strength, range, x, y);
		// TODO Auto-generated constructor stub
	}

	public static int getLivingSoldierCount() {
		return livingSoldierCount;
	}

	public static int getDeadedSoldierCount() {
		return deadedSoldierCount;
	}

	public static void addLivingSoldierCount() {
		livingSoldierCount++;
	}

	public static void subLivingSoldierCount() {
		livingSoldierCount--;
		deadedSoldierCount++;
	}
}
