package com.huawei.classroom.student.h05;

public class RPGSoldier extends Soldier {
	public void attack(Soldier obj) {
		obj.health -= 10;
		if (obj instanceof RifleSoldier || obj instanceof RPGSoldier) {
			if (obj.isDestroyed()) {
				Soldier.subLivingSoldierCount();
			}
		}
	}

	public void attack(Tank obj) {
		obj.health -= 10;
	}

	public void attack(Barrack obj) {
		obj.health -= 10;
	}

	public void attack(WarFactory obj) {
		obj.health -= 10;
	}
}