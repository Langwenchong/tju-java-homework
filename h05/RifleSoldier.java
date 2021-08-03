package com.huawei.classroom.student.h05;

public class RifleSoldier extends Soldier {
	public void attack(Soldier obj) {
		if (obj instanceof Dog) {
			obj.health -= 50;
		} else {
			obj.health -= 5;
		}
		if (obj instanceof RifleSoldier || obj instanceof RPGSoldier) {
			if (obj.isDestroyed()) {
				Soldier.subLivingSoldierCount();
			}
		}
	}

	public void attack(Tank obj) {
		obj.health -= 5;
	}

	public void attack(Barrack obj) {
		obj.health -= 5;
	}

	public void attack(WarFactory obj) {
		obj.health -= 5;
	}
}