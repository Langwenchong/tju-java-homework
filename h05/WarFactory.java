package com.huawei.classroom.student.h05;

public class WarFactory {
	public int health = 100;

	public int getHealth() {
		return this.health;
	}

	public Boolean isDestroyed() {
		if (this.health <= 0) {
			return true;
		} else
			return false;
	}

	public Tank building(EnumObjectType x) {
		Tank obj;
		switch (x) {
		case mediumTank:
			obj = new MediumTank(100, 10);
			break;
		case heavyTank:
			obj = new HeavyTank(200, 20);
			break;
		default:
			obj = new Tank();
			break;
		}
		return obj;
	}
}