package com.huawei.classroom.student.h06;

public class Dog extends Soldier {
	public Dog(int x, int y) {
		super(50, 5, 5, x, y);
	}

	public void attack(Basic obj) {
		int enemy_x = obj.x;
		int enemy_y = obj.y;
		if (judge(enemy_x, enemy_y)) {
			if (obj instanceof RifleSoldier || obj instanceof RPGSoldier) {
				obj.changeHealth(50);
			} else
				obj.health -= this.atk;
		}
	}
}
